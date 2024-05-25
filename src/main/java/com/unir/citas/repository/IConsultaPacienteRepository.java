package com.unir.citas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.ConsultaPaciente;

@Repository
public interface IConsultaPacienteRepository extends JpaRepository<ConsultaPaciente,Long>{
	
	@Query("from ConsultaPaciente cp where cp.paciente.cedula =:cedula or LOWER(cp.paciente.nombres) like %:nombreCompleto% or LOWER(cp.paciente.apellido1) like %:nombreCompleto%")
	List<ConsultaPaciente> buscar(@Param("cedula")String cedula,@Param("nombreCompleto") String nombreCompleto);

	// >= <
	@Query("from ConsultaPaciente cp where cp.fechaConsulta between :fechaConsulta and :fechaSgte")
	List<ConsultaPaciente> buscarFecha(@Param("fechaConsulta") LocalDateTime fechaConsulta, @Param("fechaSgte") LocalDateTime fechaSgte);

}
