package models;

import lombok.Builder;
import lombok.Data;

@Builder
public @Data class GetToken{

	@Builder.Default
	private String username = "admin";

	@Builder.Default
	private String password = "password123";

}