package JsonUpdate;

import com.google.gson.JsonObject;

import Utils.APICalls;

public class GSONBuilderUpdate {

	public static void main(String[] args) {
		APICalls apiCalls=new APICalls();
		String payloadPath = "./src/test/resources/payloads/petstore.json";
		apiCalls.updateKeyValueOnPayload("lastName","Mandal",payloadPath);
		
		

	}

}
