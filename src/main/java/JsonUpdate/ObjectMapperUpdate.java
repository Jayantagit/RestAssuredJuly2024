package JsonUpdate;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectMapperUpdate {

	public static void main(String[] args) {
		ObjectMapper mapper=new ObjectMapper();
		try {
			Map<String,Object> petStoreMap=mapper.readValue(new File("./src/test/resources/payloads/petstore.json"), 
					new TypeReference<Map<String,Object>>(){});
			petStoreMap.put("email", "jkm@test.com");
			mapper.writeValue(new File("./src/test/resources/payloads/petstore.json"), petStoreMap);
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
