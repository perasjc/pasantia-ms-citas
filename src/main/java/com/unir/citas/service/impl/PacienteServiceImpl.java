package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.Paciente;
import com.unir.citas.repository.IPacienteRepository;
import com.unir.citas.service.IPacienteService;

@Service
public class PacienteServiceImpl implements IPacienteService {

	@Autowired
	private IPacienteRepository repo; 
	
	@Override
	public void registrar(Paciente pac) {
		repo.save(pac);
	}

	@Override
	public void modificar(Paciente pac) {
		repo.save(pac);		
	}

	@Override
	public List<Paciente> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Paciente> leerPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void eliinar(Long id) {
		repo.deleteById(id);
		
	}

}
