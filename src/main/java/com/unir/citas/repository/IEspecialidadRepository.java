package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.Especialidad;

@Repository
public interface IEspecialidadRepository extends JpaRepository<Especialidad,Long>{
	
}
