package com.unir.citas.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="horariomedico")
public class HorarioMedico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idHorarioMedico;
	
	@ManyToOne
	@JoinColumn(name = "idMedico", nullable = false, foreignKey = @ForeignKey(name = "fk_horariomedico_medico"))
	private Medico medico;
	
	private LocalDateTime horario;
	private Integer disponibilidad;
	private Float valorAtencion;
	private Integer estado;
	
	public Long getIdHorarioMedico() {
		return idHorarioMedico;
	}
	public void setIdHorarioMedico(Long idHorarioMedico) {
		this.idHorarioMedico = idHorarioMedico;
	}
	public Medico getMedico() {
		return medico;
	}
	public void setMedico(Medico medico) {
		this.medico = medico;
	}
	public LocalDateTime getHorario() {
		return horario;
	}
	public void setHorario(LocalDateTime horario) {
		this.horario = horario;
	}
	public Integer getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(Integer disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	public Float getValorAtencion() {
		return valorAtencion;
	}
	public void setValorAtencion(Float valorAtencion) {
		this.valorAtencion = valorAtencion;
	}
	public Integer getEstado() {
		return estado;
	}
	public void setEstado(Integer estado) {
		this.estado = estado;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idHorarioMedico == null) ? 0 : idHorarioMedico.hashCode());
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
		HorarioMedico other = (HorarioMedico) obj;
		if (idHorarioMedico == null) {
			if (other.idHorarioMedico != null)
				return false;
		} else if (!idHorarioMedico.equals(other.idHorarioMedico))
			return false;
		return true;
	}
}
