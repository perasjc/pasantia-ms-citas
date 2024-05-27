package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.Medico;
import com.unir.citas.repository.IMedicoRepository;
import com.unir.citas.service.IMedicoService;

@Service
public class MedicoServiceImpl implements IMedicoService {

	@Autowired
	private IMedicoRepository repo; 
	
	@Override
	public void registrar(Medico med) {
		repo.save(med);
	}

	@Override
	public void modificar(Medico med) {
		repo.save(med);		
	}

	@Override
	public List<Medico> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<Medico> leerPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		
	}

}
