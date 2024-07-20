package HotelBooking;

import static io.restassured.RestAssured.*;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

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
	public void generateToken() {
		Response response = given().contentType(ContentType.JSON)
				.body(apiCalls.getJsonObjectFromFileInPayloadFolder("./src/test/resources/payloads/toke.json"),
						ObjectMapperType.GSON)
				.post("/auth");
		String authToken = response.jsonPath().getString("token");
		System.out.println(authToken);
	}
	@Test
	public void generateTokenPOJO() {
		User user=new User("admin","password123");
		Response response = given().contentType(ContentType.JSON)
				.body(user)
				.post("/auth");
		String authToken = response.jsonPath().getString("token");
		System.out.println(authToken);
	}

}
