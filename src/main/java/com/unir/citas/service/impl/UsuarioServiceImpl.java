package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.Usuario;
import com.unir.citas.repository.IUsuarioRepo;
import com.unir.citas.service.IUsuarioService;

@Service
public class UsuarioServiceImpl implements IUsuarioService {

	@Autowired
	private IUsuarioRepo repo; 
	
	@Override
	public void registrar(Usuario user) {
		repo.save(user);
	}

	@Override
	public void modificar(Usuario user) {
		repo.save(user);		
	}

	@Override
	public List<Usuario> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Usuario> leerPorId(Integer id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Integer id) {
		repo.deleteById(id);
		
	}

}
