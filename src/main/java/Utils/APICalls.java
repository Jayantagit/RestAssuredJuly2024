package Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

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

}
