package CRUD;

import org.testng.annotations.BeforeClass;

import com.google.gson.Gson;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class BaseClass {
	RequestSpecification request_spec;
	ResponseSpecification response_spec_200_ok;
	Gson gson;

	@BeforeClass
	public void setup() {
		request_spec = new RequestSpecBuilder().setBaseUri("https://reqres.in").log(LogDetail.ALL).build();
		response_spec_200_ok = new ResponseSpecBuilder().expectStatusCode(200).log(LogDetail.ALL).build();
		gson=new Gson();
	}

}
