package CRUD;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class NonBDDAPICalls {
	
	@BeforeClass
	public void setBaseURI()
	{
		RestAssured.baseURI="https://reqres.in";
	}

	@Test
	public void createUser()
	{
		RestAssured.baseURI="https://reqres.in";
		String body="{\r\n" + 
				"    \"name\": \"morpheus\",\r\n" + 
				"    \"job\": \"leader\"\r\n" + 
				"}";
		RequestSpecification request=RestAssured.given();
		request.body(body);
		Response res=request.post("/api/users");
		JsonPath js=res.jsonPath();
		String id=js.getString("id");
		System.out.println("ID created"+ id);
		Assert.assertNotNull(id);
		//Assert.assertTrue(res.getStatusLine().contains("OK"));

	}
	
	@Test
	public void getUser()
	{
		RestAssured.baseURI="https://reqres.in";		
		RequestSpecification request=RestAssured.given().log().all();
		Response response=request.get("/api/users?page=2");
		List<Map<String, Object>> userMap = response.jsonPath().getList("data");
		System.out.println(userMap);
		for(int i=0;i<userMap.size();i++)
		{			
			String email=userMap.get(i).get("email").toString();
			System.out.println(email);
		}

	}
	
	@Test(enabled=false)
	public void getUserTypeRef()
	{
		RestAssured.baseURI="https://reqres.in";		
		RequestSpecification request=RestAssured.given().log().all();
		Response response=request.get("/api/users?page=2");
		List<Map<String, Object>> userMap = response.as(new TypeRef<List<Map<String,Object>>>(){});
		System.out.println(userMap);
		for(int i=0;i<userMap.size();i++)
		{			
			String email=userMap.get(i).get("email").toString();
			System.out.println(email);
		}

	}
	

}
