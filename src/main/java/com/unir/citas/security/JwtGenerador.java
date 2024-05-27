package com.unir.citas.security;

import java.util.Date;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import com.unir.citas.constant.ConstantesSeguridad;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtGenerador {

	public String generarToken(Authentication authentication) {
		String username = authentication.getName();
		Date tiempoactual = new Date();
		Date expiracionToken = new Date(tiempoactual.getTime() + ConstantesSeguridad.JWT_EXPIRATION_TOKEN);
		String token = Jwts.builder()
				.setSubject(username)
				.setIssuedAt(new Date())
				.setExpiration(expiracionToken)
				.signWith(SignatureAlgorithm.HS512, ConstantesSeguridad.JWT_FIRMA)
				.compact();
		return token;
	}
	
	public String obtenerUsernameDeJwt(String token) {
		Claims claims = Jwts.parser()
				.setSigningKey(ConstantesSeguridad.JWT_FIRMA)
				.parseClaimsJws(token)
				.getBody();
		return claims.getSubject();
	}
	
	public Boolean validarToken(String token) {
		try {
			Jwts.parser().setSigningKey(ConstantesSeguridad.JWT_FIRMA).parseClaimsJws(token);
			return true;
		}catch(Exception e) {
			throw new AuthenticationCredentialsNotFoundException("Jwt ah expirado o esta incorrecto");
		}
	}
}
