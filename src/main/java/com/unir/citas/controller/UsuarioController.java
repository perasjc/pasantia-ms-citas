package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.Usuario;
import com.unir.citas.service.IUsuarioService;

@RestController
@RequestMapping("/clinica/usuarios/")
public class UsuarioController {

	private IUsuarioService service;
	
	@Autowired
	public UsuarioController(IUsuarioService usuarioService) {
		this.service = usuarioService;
	}
	
	@GetMapping
	public List<Usuario> listar(){
		return service.listar();
	}
	
	@GetMapping("{id}")
	public Usuario leerPorId(@PathVariable("id") Integer id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(Usuario user) {
		service.registrar(user);
	}
	
	@PutMapping
	public void modificar(Usuario user) {
		service.modificar(user);
	}
	
}
