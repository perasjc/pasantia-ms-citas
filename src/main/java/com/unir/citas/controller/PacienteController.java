package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.Paciente;
import com.unir.citas.service.IPacienteService;


@RestController
public class PacienteController {

	@Autowired
	private IPacienteService service;
	
	@GetMapping
	public List<Paciente> listar(){
		return service.listar();
	}
	
	@GetMapping("/{id}")
	public Paciente leerPorId(@PathVariable("id") Long id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(Paciente psc) {
		service.registrar(psc);
	}
	
	@PutMapping
	public void modificar(Paciente pac) {
		service.modificar(pac);
	}
	
}
