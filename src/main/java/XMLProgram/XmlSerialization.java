package XMLProgram;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import POJO.Person;

public class XmlSerialization {

	public static void main(String[] args) throws JAXBException {
		Person p = new Person("jayanta", 35);
		JAXBContext context = JAXBContext.newInstance(Person.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(p, new File("./src/test/resources/payloads/person.xml"));

	}

}
