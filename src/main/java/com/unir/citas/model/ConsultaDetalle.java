package com.unir.citas.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="consultadetalle")
public class ConsultaDetalle {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultaDetalle;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "consultaPaciente", nullable = false)
	private ConsultaPaciente consultaPaciente;
	
	private String diagnostico;
	private String tratamiento;
	
	public Long getIdConsultaDetalle() {
		return idConsultaDetalle;
	}
	public void setIdConsultaDetalle(Long idConsultaDetalle) {
		this.idConsultaDetalle = idConsultaDetalle;
	}
	public ConsultaPaciente getConsultaPaciente() {
		return consultaPaciente;
	}
	public void setConsultaPaciente(ConsultaPaciente consultaPaciente) {
		this.consultaPaciente = consultaPaciente;
	}
	public String getDiagnostico() {
		return diagnostico;
	}
	public void setDiagnostico(String diagnostico) {
		this.diagnostico = diagnostico;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	
}
