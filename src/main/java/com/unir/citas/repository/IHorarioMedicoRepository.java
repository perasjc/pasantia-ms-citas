package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.HorarioMedico;

@Repository
public interface IHorarioMedicoRepository extends JpaRepository<HorarioMedico,Long>{
	
}
