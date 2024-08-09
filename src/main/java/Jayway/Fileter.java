package Jayway;

import java.util.List;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;

public class Fileter {

	public static void main(String[] args) {
		String json = "[ {\r\n" + "  \"id\" : 786,\r\n" + "  \"username\" : \"Mukesh\",\r\n"
				+ "  \"firstName\" : \"Mukesh\",\r\n" + "  \"lastName\" : \"Mandal\",\r\n"
				+ "  \"email\" : \"mukesh@gmail.com\",\r\n" + "  \"password\" : \"mukesh@123\",\r\n"
				+ "  \"phone\" : \"9090909090\",\r\n" + "  \"userStatus\" : 1\r\n" + "}, {\r\n" + "  \"id\" : 787,\r\n"
				+ "  \"username\" : \"Jayanta\",\r\n" + "  \"firstName\" : \"Mukesh\",\r\n"
				+ "  \"lastName\" : \"Mandal\",\r\n" + "  \"email\" : \"mukesh@gmail.com\",\r\n"
				+ "  \"password\" : \"mukesh@123\",\r\n" + "  \"phone\" : \"9090909090\",\r\n"
				+ "  \"userStatus\" : 1\r\n" + "} ]";
		int count = JsonPath.parse(json).read("$.length()");
		System.out.println("size of array is :" + count);
		List<Object> countFilter = JsonPath
				.using(Configuration.defaultConfiguration().addOptions(Option.SUPPRESS_EXCEPTIONS)).parse(json)
				.read("[?(@.username==='Mukesh')]");
		System.out.println("size of array is :" + countFilter.size());

	}

}
