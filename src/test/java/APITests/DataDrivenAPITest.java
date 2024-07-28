package APITests;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataDrivenAPITest {

	@Test(dataProvider = "DataApi")
	public void dataDriven(int id, String username, String firstName, String lastName, String email, String password,
			String phone, int userStatus) {

		System.out.println(id + ":" + username);
	}

	
	@DataProvider(name = "DataApi")
	public Object[][] getTestData1() {

		ObjectMapper mapper = new ObjectMapper();
		List<Map<String, Object>> petStoreList = null;

		try {
			petStoreList = mapper.readValue(new File("./src/test/resources/payloads/petstoreArray.json"),
					new TypeReference<List<Map<String, Object>>>() {
					});
		} catch (IOException e) {

			e.printStackTrace();
		}
		Object arr[][] = new Object[2][8];
		for (int r = 0; r < 2; r++) {

			arr[r][0] = petStoreList.get(r).get("id");
			arr[r][1] = petStoreList.get(r).get("username");
			arr[r][2] = petStoreList.get(r).get("firstName");
			arr[r][3] = petStoreList.get(r).get("lastName");
			arr[r][4] = petStoreList.get(r).get("email");
			arr[r][5] = petStoreList.get(r).get("password");
			arr[r][6] = petStoreList.get(r).get("phone");
			arr[r][7] = petStoreList.get(r).get("userStatus");

		}
		return arr;

	}
	
	@Test(description="JacksonEg",priority=2)
	public void dataDriven1() 
	{

		ObjectMapper mapper1 = new ObjectMapper();
		Map<String, Object> petStoreMap = null;

		
			try {
				petStoreMap = 
						mapper1.readValue(new File("./src/test/resources/payloads/petstore.json"),
						Map.class);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		System.out.println(petStoreMap);
	}


}
