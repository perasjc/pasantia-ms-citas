package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.Medico;

public interface IMedicoService {

	void registrar(Medico med);
	void modificar(Medico med);
	List<Medico> listar();
	Optional<Medico> leerPorId(Long id);
	void eliminar(Long id);
}
