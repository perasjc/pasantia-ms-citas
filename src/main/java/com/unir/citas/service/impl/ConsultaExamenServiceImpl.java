package com.unir.citas.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.model.ConsultaExamen;
import com.unir.citas.repository.IConsultaExamenRepository;
import com.unir.citas.service.IConsultaExamenService;

@Service
public class ConsultaExamenServiceImpl implements IConsultaExamenService{

	@Autowired
	private IConsultaExamenRepository repo;
	
	@Override
	public List<ConsultaExamen> listarExamenesPorConsulta(Long idconsulta) {
		return repo.listarExamenesPorConsulta(idconsulta);
	}

}
