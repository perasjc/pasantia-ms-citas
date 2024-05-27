package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.Especialidad;

public interface IEspecialidadService {

	void registrar(Especialidad esp);
	void modificar(Especialidad esp);
	List<Especialidad> listar();
	Optional<Especialidad> leerPorId(Long id);
	void eliminar(Long id);
}
