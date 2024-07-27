package JsonUpdate;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonIOException;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import Utils.APICalls;

public class GSONUpdate {

	public static void main(String[] args) throws JsonIOException, IOException {
		String path = "./src/test/resources/payloads/petstore.json";
		Gson gson = new Gson();
		Map<String, Object> petMap = gson.fromJson(new FileReader(path), new TypeToken<Map<String, Object>>() {
		}.getType());
		
		petMap.put("lastName", "Mandal");
		System.out.println(petMap);
		FileWriter fw=new FileWriter(new File(path));
		
		

	}

}
