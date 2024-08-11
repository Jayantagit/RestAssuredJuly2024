package APITests;

import static io.restassured.RestAssured.*;

import org.testng.annotations.Test;

import POJO.Pet;

import static org.hamcrest.Matchers.*;

import java.util.Arrays;
import java.util.List;

public class XMLTest {

	@Test(priority = 1)
	public void postTest() {
		String payload = "<Pet>\r\n" + "	<id>0</id>\r\n" + "	<Category>\r\n" + "		<id>0</id>\r\n"
				+ "		<name>string</name>\r\n" + "	</Category>\r\n" + "	<name>doggie</name>\r\n"
				+ "	<photoUrls>\r\n" + "		<photoUrl>string</photoUrl>\r\n" + "	</photoUrls>\r\n"
				+ "	<tags>\r\n" + "		<Tag>\r\n" + "			<id>0</id>\r\n" + "			<name>string</name>\r\n"
				+ "		</Tag>\r\n" + "	</tags>\r\n" + "	<status>available</status>\r\n" + "</Pet>";
		baseURI = "https://petstore.swagger.io/v2";
		given().log().all().header("accept", " application/xml").header("Content-Type", " application/xml")
				.body(payload).when().post("/pet").then().log().all().assertThat().statusCode(200).and()
				.body("Pet.name", equalTo("doggie"));
	}

	@Test(priority = 2)
	public void xmlPojoTest() {

		Pet pet = new Pet();
		pet.setId(789);
		Pet.Category category = new Pet.Category();
		category.setId(189);
		category.setName("Breed");
		pet.setCategory(category);
		List<String> photoURLs = Arrays.asList("https://google.com", "https://google1.com");
		pet.setPhotoUrls(photoURLs);
		Pet.Tag tag1 = new Pet.Tag();
		tag1.setId(109);
		tag1.setName("joy");
		Pet.Tag tag2 = new Pet.Tag();
		tag2.setId(110);
		tag1.setName("joya");
		pet.setTags(Arrays.asList(tag1, tag2));
		pet.setStatus("avilable");
		baseURI = "https://petstore.swagger.io/v2";
		given().log().all().header("accept", " application/xml").header("Content-Type", " application/xml").body(pet)
				.when().post("/pet").then().log().all().assertThat().statusCode(200);

	}

}
