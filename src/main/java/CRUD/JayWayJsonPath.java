package CRUD;

import java.util.List;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.common.mapper.TypeRef;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;


public class JayWayJsonPath {
	
	@BeforeClass
	public void setBaseURI()
	{
		RestAssured.baseURI="https://reqres.in";
	}

	
	
	@Test
	public void getUserJayway()
	{
		RestAssured.baseURI="https://reqres.in";		
		RequestSpecification request=RestAssured.given().log().all();
		Response response=request.get("/api/users?page=2");
		List<Map<String, Object>> userMap=JsonPath.read(response.getBody().asString(), "$.data");
		System.out.println(userMap);
		

	}
	

}
