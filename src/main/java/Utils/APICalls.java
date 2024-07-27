package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import io.restassured.response.Response;

public class APICalls {

	public JsonObject getJsonObjectFromFileInPayloadFolder(String path) {
		FileReader fileReader = null;
		Gson gson = new Gson();
		JsonObject jsonObject = null;
		try {
			fileReader = new FileReader(new File(path));
			jsonObject = gson.fromJson(fileReader, JsonObject.class);
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		return jsonObject;
	}
	


	public <T> T toJsonObject(Response jsonResponse,Class<T> clazz) {
		ObjectMapper mapper = new ObjectMapper();		
		try {
			return mapper.readValue(jsonResponse.getBody().asString(), clazz);
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
