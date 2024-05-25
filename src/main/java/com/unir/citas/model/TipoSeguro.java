package com.unir.citas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="tiposeguro")
public class TipoSeguro {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoSeguro;
	
	private String seguro;
	
	private Integer estado;

	public Long getIdTipoSeguro() {
		return idTipoSeguro;
	}

	public void setIdTipoSeguro(Long idTipoSeguro) {
		this.idTipoSeguro = idTipoSeguro;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
}
