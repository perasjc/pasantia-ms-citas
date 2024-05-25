package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.Paciente;

public interface IPacienteService {

	void registrar(Paciente pac);
	void modificar(Paciente pac);
	List<Paciente> listar();
	Optional<Paciente> leerPorId(Long id);
	void eliinar(Long id);
}
