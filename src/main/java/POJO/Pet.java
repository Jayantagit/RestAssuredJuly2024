package POJO;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import groovy.transform.builder.Builder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@XmlRootElement(name="Pet") 
public class Pet {

	@JacksonXmlProperty(localName = "id")
	private long id;

	private Category Category;

	private String name;

	@JacksonXmlElementWrapper(localName = "photoUrls")
	@JacksonXmlProperty(localName = "photoUrl")
	private List<String> photoUrls;

	@JacksonXmlElementWrapper(localName = "tags")
	@JacksonXmlProperty(localName = "Tag")
	private List<Tag> tags;

	private String status;

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder	
	public static class Category {
		private long id;
		private String name;

	}

	@Data
	@NoArgsConstructor
	@AllArgsConstructor
	@Builder	
	public static class Tag {
		private long id;
		private String name;

	}

}
