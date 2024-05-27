package com.unir.citas.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.unir.citas.model.Rol;

@Repository
public interface IRolRepo extends JpaRepository<Rol, Integer>{

	Optional<Rol> findByNombre(String nombre); 
}
