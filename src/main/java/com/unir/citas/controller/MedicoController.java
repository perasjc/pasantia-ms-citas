package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.Medico;
import com.unir.citas.service.IMedicoService;


@RestController
@RequestMapping("/clinica/medicos/")
public class MedicoController {

	@Autowired
	private IMedicoService service;
	
	@GetMapping
	public List<Medico> listar(){
		return service.listar();
	}
	
	@GetMapping("{id}")
	public Medico leerPorId(@PathVariable("id") Long id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(Medico med) {
		service.registrar(med);
	}
	
	@PutMapping
	public void modificar(Medico med) {
		service.modificar(med);
	}
	
}
