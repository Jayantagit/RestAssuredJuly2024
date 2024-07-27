package POJO;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@RequiredArgsConstructor(access=AccessLevel.PUBLIC)
@ToString
public class UserPOJO {
	
	@JsonProperty("username")
	@NonNull
	private String username;
	
	@JsonProperty("password")
	@NonNull
	private String password;

}
