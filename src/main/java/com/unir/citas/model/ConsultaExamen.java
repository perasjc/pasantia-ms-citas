package com.unir.citas.model;

import java.sql.Timestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultaexamen")
public class ConsultaExamen {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultaExamen;

	@ManyToOne
	@JoinColumn(name = "idConsultaPaciente", nullable = false, foreignKey = @ForeignKey(name = "fk_consultaexamen_consultaPaciente"))
	private ConsultaPaciente consultaPaciente;

	@ManyToOne
	@JoinColumn(name = "idExamen", nullable = false, foreignKey = @ForeignKey(name = "fk_consultaexamen_examen"))
	private Examen examen;

	private String tratamiento;
	private Timestamp fechaAtencion;
	private String rutaPdf;

	public Long getIdConsultaExamen() {
		return idConsultaExamen;
	}

	public void setIdConsultaExamen(Long idConsultaExamen) {
		this.idConsultaExamen = idConsultaExamen;
	}

	public ConsultaPaciente getConsultaPaciente() {
		return consultaPaciente;
	}

	public void setConsultaPaciente(ConsultaPaciente consultaPaciente) {
		this.consultaPaciente = consultaPaciente;
	}

	public Examen getExamen() {
		return examen;
	}

	public void setExamen(Examen examen) {
		this.examen = examen;
	}

	public String getTratamiento() {
		return tratamiento;
	}

	public void setTratamiento(String tratamiento) {
		this.tratamiento = tratamiento;
	}

	public Timestamp getFechaAtencion() {
		return fechaAtencion;
	}

	public void setFechaAtencion(Timestamp fechaAtencion) {
		this.fechaAtencion = fechaAtencion;
	}

	public String getRutaPdf() {
		return rutaPdf;
	}

	public void setRutaPdf(String rutaPdf) {
		this.rutaPdf = rutaPdf;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idConsultaExamen == null) ? 0 : idConsultaExamen.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ConsultaExamen other = (ConsultaExamen) obj;
		if (idConsultaExamen == null) {
			if (other.idConsultaExamen != null)
				return false;
		} else if (!idConsultaExamen.equals(other.idConsultaExamen))
			return false;
		return true;
	}

}
