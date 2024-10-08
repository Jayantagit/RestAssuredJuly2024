package HotelBooking;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import POJO.Token;
import POJO.User;
import Utils.APICalls;
import io.restassured.http.ContentType;
import io.restassured.mapper.ObjectMapperType;
import io.restassured.response.Response;

public class CreateToken {
	APICalls apiCalls;

	@BeforeClass
	public void setBaseURI() {
		baseURI = "https://restful-booker.herokuapp.com";
		apiCalls = new APICalls();
	}

	@Test
	public void generateTokenGSON() {
		Response response = given().contentType(ContentType.JSON)
				.body(apiCalls.getJsonObjectFromFileInPayloadFolder("./src/test/resources/payloads/token.json"),
						ObjectMapperType.GSON)
				.post("/auth");
		String authToken = response.jsonPath().getString("token");
		System.out.println(authToken);
	}

	@Test
	public void generateTokenPOJO() {
		User user = new User("admin", "password123");
		Response response = given().contentType(ContentType.JSON).body(user).post("/auth");
		//System.out.println(response.getBody().asString());
		String authToken = response.jsonPath().getString("token");
		System.out.println(authToken);
	}
	
	@Test
	public void generateTokenUsingMapper() {
		User user = new User("admin", "password123");
		Response response = given().contentType(ContentType.JSON).body(user).post("/auth");
		Token token=apiCalls.toJsonObject(response,Token.class);
		System.out.println(token.getToken());
	//	String authToken = jsonObject.getAsJsonObject().get("token").toString();
	//	System.out.println(authToken);
	}

}
