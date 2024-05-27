package com.unir.citas.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.unir.citas.model.Usuario;
import com.unir.citas.repository.IUsuarioRepo;


@Service
public class CustomUserDetailsService implements UserDetailsService{

	@Autowired
	private IUsuarioRepo repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = repo.findOneByUsername(username).orElseThrow(()->new UsernameNotFoundException("Usuario no encontrado"));
		
		if(usuario == null) {
			throw new UsernameNotFoundException(String.format("Usuario no existe", username));
		}
		
		List<GrantedAuthority> roles = new ArrayList<>();
		
		usuario.getRoles().forEach(rol -> {
			roles.add(new SimpleGrantedAuthority(rol.getNombre()));
		});
		
		UserDetails userDetails = new User(usuario.getUsername(), usuario.getPassword(), roles);
		return userDetails;
	
	}
}
