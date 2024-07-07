package CRUD;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.response.Response;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.util.HashMap;
import java.util.Map;

public class HotelBookerApi {
	String authToken;
	int bookingId;
	
	@BeforeClass
	public void setBaseURI() {
		baseURI = "https://restful-booker.herokuapp.com";
	}

	@Test(priority=1)
	public void createToken() {
		
		Response response=given().header("Content-Type", "application/json").
		body("{\r\n" + 
				"    \"username\" : \"admin\",\r\n" + 
				"    \"password\" : \"password123\"\r\n" + 
				"}").post("/auth");
		authToken=response.jsonPath().getString("token");
	}
	
	@Test(priority=2)
	public void createBooking() {
		
		Response response=given().header("Content-Type", "application/json").
		body("{\r\n" + 
				"    \"firstname\" : \"Jim\",\r\n" + 
				"    \"lastname\" : \"Brown\",\r\n" + 
				"    \"totalprice\" : 111,\r\n" + 
				"    \"depositpaid\" : true,\r\n" + 
				"    \"bookingdates\" : {\r\n" + 
				"        \"checkin\" : \"2018-01-01\",\r\n" + 
				"        \"checkout\" : \"2019-01-01\"\r\n" + 
				"    },\r\n" + 
				"    \"additionalneeds\" : \"Breakfast\"\r\n" + 
				"}").post("/booking");
		bookingId=response.jsonPath().getInt("bookingid");
	}
	
	@Test(priority=3)
	public void getBooking() {
		
		Response response=given().pathParam("bookingIdval", bookingId)
				.get("/booking/{bookingIdval}");
		System.out.println(response.getBody().asPrettyString());
	}
	
	@Test(priority=4)
	public void updateBooking() {
		
		Map<String,Object> restFullheaders=new HashMap<String,Object>();
		restFullheaders.put("Content-Type", "application/json");
		restFullheaders.put("Accept", "application/json");
		restFullheaders.put("cookie", "token="+authToken);
		Response response=given().log().all().headers(restFullheaders).
								body("{\r\n" + 
										"    \"firstname\" : \"James\",\r\n" + 
										"    \"lastname\" : \"Brown\",\r\n" + 
										"    \"totalprice\" : 111,\r\n" + 
										"    \"depositpaid\" : true,\r\n" + 
										"    \"bookingdates\" : {\r\n" + 
										"        \"checkin\" : \"2018-01-01\",\r\n" + 
										"        \"checkout\" : \"2019-01-01\"\r\n" + 
										"    },\r\n" + 
										"    \"additionalneeds\" : \"Dinner\"\r\n" + 
										"}").post("/booking");
		System.out.println(response.getBody().asPrettyString());
	}



}
