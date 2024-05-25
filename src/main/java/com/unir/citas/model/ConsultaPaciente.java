package com.unir.citas.model;

import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "consultapaciente")
public class ConsultaPaciente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idConsultaPaciente;

	@ManyToOne
	@JoinColumn(name = "idPaciente", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_paciente"))
	private Paciente paciente;

	@ManyToOne
	@JoinColumn(name = "idHorarioMedico", nullable = false, foreignKey = @ForeignKey(name = "fk_consulta_horarioMedico"))
	private HorarioMedico horarioMedico;

	@OneToMany(mappedBy = "consultaPaciente", cascade = { CascadeType.ALL, CascadeType.MERGE,
			CascadeType.REMOVE }, fetch = FetchType.LAZY, orphanRemoval = true)
	private List<ConsultaDetalle> consultaDetalle;

	@JsonSerialize(using = ToStringSerializer.class) // ISODate
	private LocalDateTime fechaConsulta;

	@Column(name = "estado", nullable = false, length = 50)
	private Integer estado;

	public Long getIdConsultaPaciente() {
		return idConsultaPaciente;
	}

	public void setIdConsultaPaciente(Long idConsultaPaciente) {
		this.idConsultaPaciente = idConsultaPaciente;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}

	public HorarioMedico getHorarioMedico() {
		return horarioMedico;
	}

	public void setHorarioMedico(HorarioMedico horarioMedico) {
		this.horarioMedico = horarioMedico;
	}

	public List<ConsultaDetalle> getConsultaDetalle() {
		return consultaDetalle;
	}

	public void setConsultaDetalle(List<ConsultaDetalle> consultaDetalle) {
		this.consultaDetalle = consultaDetalle;
	}

	public LocalDateTime getFechaConsulta() {
		return fechaConsulta;
	}

	public void setFechaConsulta(LocalDateTime fechaConsulta) {
		this.fechaConsulta = fechaConsulta;
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
		result = prime * result + ((idConsultaPaciente == null) ? 0 : idConsultaPaciente.hashCode());
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
		ConsultaPaciente other = (ConsultaPaciente) obj;
		if (idConsultaPaciente == null) {
			if (other.idConsultaPaciente != null)
				return false;
		} else if (!idConsultaPaciente.equals(other.idConsultaPaciente))
			return false;
		return true;
	}

}
