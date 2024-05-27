package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.HorarioMedico;

public interface IHorarioMedicoService {

	void registrar(HorarioMedico hmed);
	void modificar(HorarioMedico hmed);
	List<HorarioMedico> listar();
	Optional<HorarioMedico> leerPorId(Long id);
	void eliminar(Long id);
}
