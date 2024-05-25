package com.unir.citas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tipoexamen")
public class TipoExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idTipoExamen;
	
	private String tipo;
	private Integer estado;
	
	@OneToOne(mappedBy = "tipoExamen")
    private Examen examen;

	private String color;
	private String imagen;
	private String ruta;
	private String titulo;
		
	public Long getIdTipoExamen() {
		return idTipoExamen;
	}

	public void setIdTipoExamen(Long idTipoExamen) {
		this.idTipoExamen = idTipoExamen;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public Integer getEstado() {
		return estado;
	}

	public void setEstado(Integer estado) {
		this.estado = estado;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

}
