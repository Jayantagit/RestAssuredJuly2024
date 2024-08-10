package JsonValidate;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import POJO.Customer;

public class JsonInclude {

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		Customer customer = new Customer("jayanta", "Mumbai", true);
		String jsonString = mapper.writeValueAsString(customer);
		System.out.println(jsonString);
		Customer cust = mapper.readValue(new File("./src/test/resources/payloads/customer.json"), Customer.class);
		System.out.println(cust.getName()+cust.getLocation()+cust.isActive());

	}

}
