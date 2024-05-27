package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.Usuario;

public interface IUsuarioService {

	void registrar(Usuario user);
	void modificar(Usuario user);
	List<Usuario> listar();
	Optional<Usuario> leerPorId(Integer id);
	void eliminar(Integer id);
}
