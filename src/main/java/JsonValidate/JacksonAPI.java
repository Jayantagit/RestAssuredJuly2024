package JsonValidate;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.core.exc.StreamWriteException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import POJO.Customer;
import POJO.Person;

public class JacksonAPI {

	public static void main(String[] args) throws StreamWriteException, DatabindException, IOException {
		Person p = new Person("jayanta", 35);
		ObjectMapper mapper=new ObjectMapper();
		mapper.enable(SerializationFeature.INDENT_OUTPUT);
		mapper.writeValue(new File("./src/test/resources/payloads/person.json"),p);
		System.out.println("======SERIALIZATION DONE============");
	
	}

}
