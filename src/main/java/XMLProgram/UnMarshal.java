package XMLProgram;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import POJO.Person;

public class UnMarshal {

	public static void main(String[] args) throws JAXBException {
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Unmarshaller unmarshaller =context.createUnmarshaller();
		Person person=(Person)unmarshaller.unmarshal(new File("./src/test/resources/payloads/person.xml"));
		System.out.println(person.getName());

	}

}
