package com.unir.citas.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.HorarioMedico;
import com.unir.citas.repository.IHorarioMedicoRepository;
import com.unir.citas.service.IHorarioMedicoService;

@Service
public class HorarioMedicoServiceImpl implements IHorarioMedicoService {

	@Autowired
	private IHorarioMedicoRepository repo; 
	
	@Override
	public void registrar(HorarioMedico hmed) {
		repo.save(hmed);
	}

	@Override
	public void modificar(HorarioMedico hmed) {
		repo.save(hmed);		
	}

	@Override
	public List<HorarioMedico> listar() {
		return repo.findAll();
	}

	@Override
	public Optional<HorarioMedico> leerPorId(Long id) {
		return repo.findById(id);
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
		
	}

}
