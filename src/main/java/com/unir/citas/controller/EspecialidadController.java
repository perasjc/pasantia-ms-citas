package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.Especialidad;
import com.unir.citas.service.IEspecialidadService;


@RestController
@RequestMapping("/clinica/especialidades/")
public class EspecialidadController {

	@Autowired
	private IEspecialidadService service;
	
	@GetMapping
	public List<Especialidad> listar(){
		return service.listar();
	}
	
	@GetMapping("{id}")
	public Especialidad leerPorId(@PathVariable("id") Long id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(Especialidad esp) {
		service.registrar(esp);
	}
	
	@PutMapping
	public void modificar(Especialidad esp) {
		service.modificar(esp);
	}
	
}
