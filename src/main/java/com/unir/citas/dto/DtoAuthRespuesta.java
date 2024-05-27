package com.unir.citas.dto;

public class DtoAuthRespuesta {

	private String accessToken;
	private String tokenType = "Bearer ";
		
	public DtoAuthRespuesta(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getAccessToken() {
		return accessToken;
	}
	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}
	public String getTokenType() {
		return tokenType;
	}
	public void setTokenType(String tokenType) {
		this.tokenType = tokenType;
	}
	
	
}
