package com.unir.citas.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.ConsultaExamen;


@Repository
public interface IConsultaExamenRepository extends JpaRepository<ConsultaExamen,Long>{

	//@Transactional
	@Modifying
	@Query(value = "INSERT INTO consultaexamen(id_consulta_Paciente, id_examen, tratamiento, fecha_atencion, ruta_pdf) VALUES (:idConsultaPaciente, :idExamen, :tratamiento, :fechaAtencion, :rutaPdf)", nativeQuery = true)
	Integer registrar(@Param("idConsultaPaciente") Long idConsultaPaciente, @Param("idExamen") Long idExamen, @Param("tratamiento") String tratamiento, @Param("fechaAtencion") LocalDateTime fechaAtencion, @Param("rutaPdf") String rutaPdf);
	
	@Query("from ConsultaExamen ce where ce.consultaPaciente.idConsultaPaciente = :idConsultaPaciente")
	List<ConsultaExamen> listarExamenesPorConsulta(@Param("idConsultaPaciente") Long idConsultaPaciente);
}
