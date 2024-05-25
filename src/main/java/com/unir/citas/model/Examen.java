package com.unir.citas.model;

import java.sql.Timestamp;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="examen")
public class Examen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idExamen;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_TipoExamen", referencedColumnName = "idTipoExamen")
	private TipoExamen tipoExamen;
	
	private String descripcion;
	private Timestamp fechaExamen;
	public Long getIdExamen() {
		return idExamen;
	}
	public void setIdExamen(Long idExamen) {
		this.idExamen = idExamen;
	}
	public TipoExamen getTipoExamen() {
		return tipoExamen;
	}
	public void setTipoExamen(TipoExamen tipoExamen) {
		this.tipoExamen = tipoExamen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Timestamp getFechaExamen() {
		return fechaExamen;
	}
	public void setFechaExamen(Timestamp fechaExamen) {
		this.fechaExamen = fechaExamen;
	}

}
