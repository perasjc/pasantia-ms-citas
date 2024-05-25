package com.unir.citas.service;

import java.util.List;

import com.unir.citas.model.ConsultaExamen;

public interface IConsultaExamenService {

	List<ConsultaExamen> listarExamenesPorConsulta(Long idconsulta);
}
