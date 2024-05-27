package com.unir.citas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.unir.citas.model.TipoExamen;
import com.unir.citas.service.ITipoExamenService;


@RestController
@RequestMapping("/clinica/tipoexamenes/")
public class TipoExamenController {

	@Autowired
	private ITipoExamenService service;
	
	@GetMapping
	public List<TipoExamen> listar(){
		return service.listar();
	}
	
	@GetMapping("{id}")
	public TipoExamen leerPorId(@PathVariable("id") Long id) {
		return service.leerPorId(id).get();
	}
	
	@PostMapping
	public void registrar(TipoExamen exam) {
		service.registrar(exam);
	}
	
	@PutMapping
	public void modificar(TipoExamen exam) {
		service.modificar(exam);
	}
	
}
