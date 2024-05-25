package com.unir.citas.service;

import java.util.List;

public interface ICRUD<T> {

	T registrar(T t);
	T modificar(T t);
	T leerPorId(Long id);
	List<T> listar();
	void eliminar(Long id);
}
