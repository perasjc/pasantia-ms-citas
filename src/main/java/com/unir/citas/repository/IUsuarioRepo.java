package com.unir.citas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.citas.model.Usuario;



public interface IUsuarioRepo  extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Optional<Usuario> findOneByUsername(String username);
	
	Boolean existsByUsername(String username);
}
