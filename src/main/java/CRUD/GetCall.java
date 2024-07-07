package CRUD;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class GetCall {

	public static void main(String[] args) {
		RestAssured.baseURI="https://reqres.in";
		Response response=RestAssured.get("/api/users?page=2");
		//System.out.println(response.getBody().asString());
		System.out.println(response.getBody().asPrettyString());
		System.out.println(response.getStatusCode());
		System.out.println(response.getHeaders());

	}

}
