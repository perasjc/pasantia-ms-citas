package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.Especialidad;
import com.unir.citas.repository.IEspecialidadRepository;
import com.unir.citas.service.IEspecialidadService;

@Service
public class EspecialidadServiceImpl implements IEspecialidadService {

	@Autowired
	private IEspecialidadRepository repo; 
	
	@Override
	public void registrar(Especialidad esp) {
		repo.save(esp);
	}

	@Override
	public void modificar(Especialidad esp) {
		repo.save(esp);		
	}

	@Override
	public List<Especialidad> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Especialidad> leerPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		
	}

}
