package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.Medico;

@Repository
public interface IMedicoRepository extends JpaRepository<Medico,Long>{
	
}
