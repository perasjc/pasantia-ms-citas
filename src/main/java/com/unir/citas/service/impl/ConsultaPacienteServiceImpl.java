package com.unir.citas.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.unir.citas.dto.ConsultaListaExamenDTO;
import com.unir.citas.dto.FiltroConsultaDTO;
import com.unir.citas.model.ConsultaPaciente;
import com.unir.citas.repository.IConsultaExamenRepository;
import com.unir.citas.repository.IConsultaPacienteRepository;
import com.unir.citas.service.IConsultaPacienteService;

import jakarta.transaction.Transactional;

@Service
public class ConsultaPacienteServiceImpl implements IConsultaPacienteService {
	
	@Autowired	
	private IConsultaPacienteRepository repo;
	
	@Autowired
	private IConsultaExamenRepository ceRepo;

	@Override
	public ConsultaPaciente registrar(ConsultaPaciente obj) {
		obj.getConsultaDetalle().forEach(det -> {
			det.setConsultaPaciente(obj);
		});
		
		/*for(DetalleConsulta det : obj.getDetalleConsulta()) {
			det.setConsulta(obj);
		}*/
		return repo.save(obj);	
	}

	@Override
	public ConsultaPaciente modificar(ConsultaPaciente obj) {
		return repo.save(obj);
	}

	@Override
	public ConsultaPaciente leerPorId(Long id) {
		return repo.findById(id).get();
	}

	@Override
	public List<ConsultaPaciente> listar() {
		return repo.findAll();
	}

	@Override
	public void eliminar(Long id) {
		repo.deleteById(id);
	}

	@Transactional
	@Override
	public ConsultaPaciente registrarTransaccional(ConsultaListaExamenDTO consultaDTO) {
		consultaDTO.getConsultaPaciente().getConsultaDetalle().forEach(det -> det.setConsultaPaciente(consultaDTO.getConsultaPaciente()));
		repo.save(consultaDTO.getConsultaPaciente());
		
		consultaDTO.getListExamen().forEach(ex -> ceRepo.registrar(consultaDTO.getConsultaPaciente().getIdConsultaPaciente(), ex.getIdExamen(), consultaDTO.getTratamiento(), consultaDTO.getFechaAtencion(), consultaDTO.getRutaPdf()));
		return consultaDTO.getConsultaPaciente();
	}

	@Override
	public List<ConsultaPaciente> buscar(FiltroConsultaDTO filtro) {
		return repo.buscar(filtro.getCedula(), filtro.getNombres());
	}

	@Override
	public List<ConsultaPaciente> buscarFecha(FiltroConsultaDTO filtro) {
		LocalDateTime fechaSgte = filtro.getFechaConsulta().plusDays(1);
		return repo.buscarFecha(filtro.getFechaConsulta(), fechaSgte);
	}


}
