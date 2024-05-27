package com.unir.citas.service;

import java.util.List;
import java.util.Optional;

import com.unir.citas.model.TipoExamen;

public interface ITipoExamenService {

	void registrar(TipoExamen exam);
	void modificar(TipoExamen exam);
	List<TipoExamen> listar();
	Optional<TipoExamen> leerPorId(Long id);
	void eliminar(Long id);
}
