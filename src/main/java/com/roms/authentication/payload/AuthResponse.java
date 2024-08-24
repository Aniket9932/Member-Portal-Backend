package com.roms.authentication.payload;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AuthResponse {
	private String userName;
	private long id;
	private String token;
}
