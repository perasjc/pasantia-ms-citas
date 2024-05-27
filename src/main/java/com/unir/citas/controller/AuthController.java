package com.unir.citas.controller;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.dto.DtoAuthRespuesta;
import com.unir.citas.dto.DtoLogin;
import com.unir.citas.dto.DtoRegistro;
import com.unir.citas.model.Rol;
import com.unir.citas.model.Usuario;
import com.unir.citas.repository.IRolRepo;
import com.unir.citas.repository.IUsuarioRepo;
import com.unir.citas.security.JwtGenerador;

@RestController
@RequestMapping("/api/auth/")
public class AuthController {

	private AuthenticationManager authenticationManager;
	
	private PasswordEncoder passwordEncoder;
	
	private IRolRepo rolRepo;
	
	private IUsuarioRepo usuarioRepo;
	
	private JwtGenerador jwtGenerador;

	@Autowired
	public AuthController(AuthenticationManager authenticationManager, PasswordEncoder passwordEncoder,
			IRolRepo rolRepo, IUsuarioRepo usuarioRepo, JwtGenerador jwtGenerador) {
		this.authenticationManager = authenticationManager;
		this.passwordEncoder = passwordEncoder;
		this.rolRepo = rolRepo;
		this.usuarioRepo = usuarioRepo;
		this.jwtGenerador = jwtGenerador;
	}
	
	@PostMapping("register")
	public ResponseEntity<String> registrar(@RequestBody DtoRegistro dtoRegistro){
		if(usuarioRepo.existsByUsername(dtoRegistro.getUsername())) {
			return new ResponseEntity<>("El usuario ya existe, intenta con otro", HttpStatus.BAD_REQUEST);
		}
		Usuario usuario = new Usuario();
		usuario.setUsername(dtoRegistro.getUsername());
		usuario.setPassword(passwordEncoder.encode(dtoRegistro.getPassword()));
		usuario.setEnabled(true);
		Rol rol = rolRepo.findByNombre("USER").get();
		usuario.setRoles(Collections.singletonList(rol));
		usuarioRepo.save(usuario);
		return new ResponseEntity<>("Registro de usuario exitoso", HttpStatus.OK);
	}
	
	@PostMapping("login")
	public ResponseEntity<DtoAuthRespuesta> login(@RequestBody DtoLogin dtoLogin){
		Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
				dtoLogin.getUsername(), dtoLogin.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String token = jwtGenerador.generarToken(authentication);
		return new ResponseEntity<>(new DtoAuthRespuesta(token), HttpStatus.OK);
	}
	
}
