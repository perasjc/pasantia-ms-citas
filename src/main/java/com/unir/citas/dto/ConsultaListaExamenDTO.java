package com.unir.citas.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.unir.citas.model.ConsultaPaciente;
import com.unir.citas.model.Examen;

public class ConsultaListaExamenDTO {

	private ConsultaPaciente consultaPaciente;
	private List<Examen> listExamen;
	private String tratamiento;
	private LocalDateTime fechaAtencion;
	private String rutaPdf;
	
	public ConsultaPaciente getConsultaPaciente() {
		return consultaPaciente;
	}
	public void setConsultaPaciente(ConsultaPaciente consultaPaciente) {
		this.consultaPaciente = consultaPaciente;
	}
	public List<Examen> getListExamen() {
		return listExamen;
	}
	public void setListExamen(List<Examen> listExamen) {
		this.listExamen = listExamen;
	}
	public String getTratamiento() {
		return tratamiento;
	}
	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}
	public LocalDateTime getFechaAtencion() {
		return fechaAtencion;
	}
	public void setFechaAtencion(LocalDateTime fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}
	public String getRutaPdf() {
		return rutaPdf;
	}
	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}	

}
