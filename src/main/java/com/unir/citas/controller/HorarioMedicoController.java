package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.HorarioMedico;
import com.unir.citas.service.IHorarioMedicoService;


@RestController
@RequestMapping("/clinica/horarios/")
public class HorarioMedicoController {

	@Autowired
	private IHorarioMedicoService service;
	
	@GetMapping
	public List<HorarioMedico> listar(){
		return service.listar();
	}
	
	@GetMapping("{id}")
	public HorarioMedico leerPorId(@PathVariable("id") Long id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(HorarioMedico hmed) {
		service.registrar(hmed);
	}
	
	@PutMapping
	public void modificar(HorarioMedico hmed) {
		service.modificar(hmed);
	}
	
}
