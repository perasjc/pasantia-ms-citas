package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.TipoExamen;
import com.unir.citas.repository.ITipoExamenRepository;
import com.unir.citas.service.ITipoExamenService;

@Service
public class TipoExamenServiceImpl implements ITipoExamenService {

	@Autowired
	private ITipoExamenRepository repo; 
	
	@Override
	public void registrar(TipoExamen exam) {
		repo.save(exam);
	}

	@Override
	public void modificar(TipoExamen exam) {
		repo.save(exam);		
	}

	@Override
	public List<TipoExamen> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<TipoExamen> leerPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		
	}

}
