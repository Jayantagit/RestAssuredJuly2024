package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
@RequiredArgsConstructor
public class User {
	
	@JsonProperty("username")
	@NonNull
	private String username;
	
	@JsonProperty("password")
	@NonNull
	private String password;

}
