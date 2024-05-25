package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.unir.citas.model.Usuario;


public interface IUsuarioRepo  extends JpaRepository<Usuario, Integer> {

	//select * from usuario where username = ?
	Usuario findOneByUsername(String username);
}
