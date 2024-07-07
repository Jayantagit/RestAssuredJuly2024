package CRUD;

import java.util.List;
import java.util.Map;

import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;

import io.restassured.specification.RequestSpecification;
import static org.hamcrest.Matchers.*;

public class ListUsers {

	@BeforeClass
	public void setBaseURI() {
		RestAssured.baseURI = "https://reqres.in";
	}

	@Test
	public void listUser() {

		RequestSpecification request = RestAssured.given();
		request.queryParam("page", "2");
		Response res = request.get("/api/users");
		System.out.println(res.getBody().asPrettyString());
		List<Integer> idList = res.jsonPath().getList("data.id");
		idList.forEach(System.out::println);

	}

	@Test
	public void listUserDetails() {

		RequestSpecification request = RestAssured.given();
		request.queryParam("page", "2");
		Response res = request.get("/api/users");
		System.out.println(res.getBody().asPrettyString());
		List<Map<String, Object>> userList = res.jsonPath().getList("data");
		System.out.println("===============");
		for (Map<String, Object> user : userList) {
			user.forEach((k, v) -> System.out.println(k + " " + v));
		}
		System.out.println("===============");

	}

	@Test
	public void listUserDetailsBDD() {

		RestAssured.given().log().all().queryParam("page", "2").when().get("/api/users").then().log().all().assertThat()
				.statusCode(200).and().body("total", equalTo(12)).and().body("data.id", Matchers.hasItems(7)).and()
				.body("data.email", everyItem(containsString("@reqres.in"))).body("data.email", endsWith("@reqres.in"))
				.body("support.text", notNullValue());

	}

}
