package com.unir.citas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.TipoExamen;

@Repository
public interface ITipoExamenRepository extends JpaRepository<TipoExamen,Long>{
	
}
