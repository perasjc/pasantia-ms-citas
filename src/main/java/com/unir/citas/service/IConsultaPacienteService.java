package com.unir.citas.service;

import java.util.List;

import com.unir.citas.dto.ConsultaListaExamenDTO;
import com.unir.citas.dto.FiltroConsultaDTO;
import com.unir.citas.model.ConsultaPaciente;

public interface IConsultaPacienteService extends ICRUD<ConsultaPaciente>{
	
	ConsultaPaciente registrarTransaccional(ConsultaListaExamenDTO consultaDTO);
	
	List<ConsultaPaciente> buscar(FiltroConsultaDTO filtro);

	List<ConsultaPaciente> buscarFecha(FiltroConsultaDTO filtro);

}
