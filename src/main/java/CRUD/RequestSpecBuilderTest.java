package CRUD;

import org.testng.annotations.Test;

import com.google.gson.JsonObject;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RequestSpecBuilderTest extends BaseClass {
	

	@Test(enabled = true)
	public void getUserGson() {

		Response response=RestAssured.given().spec(request_spec).when().get("/api/users?page=2");
		JsonObject jsonObject=gson.fromJson(response.getBody().asString(), JsonObject.class);
		System.out.println("ID is:="+jsonObject.get("data").getAsJsonArray().get(0).getAsJsonObject().get("id"));
	}
	@Test(enabled = true)
	public void getUserRequestResponseSpecBuilder() {

		Response resp=RestAssured.given().spec(request_spec).when().get("/api/users?page=2");
		resp.then().assertThat().spec(response_spec_200_ok);
		
	}
	@Test(enabled = true)
	public void getUserSpec() {

		RequestSpecification request=RestAssured.given().spec(request_spec);
		Response resp=request.get("/api/users?page=2");
		resp.then().assertThat().spec(response_spec_200_ok);		
		
	}


}
