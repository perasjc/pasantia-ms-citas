package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.Paciente;

@Repository
public interface IPacienteRepository extends JpaRepository<Paciente,Long>{
	
}
