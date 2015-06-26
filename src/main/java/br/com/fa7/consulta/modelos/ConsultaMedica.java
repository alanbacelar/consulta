package br.com.fa7.consulta.modelos;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="consulta_medica")
public class ConsultaMedica {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_consulta")
	private Long id;

	@ManyToOne
	private Especialidade especialidade;
	
	@ManyToOne
	private Paciente paciente;
	
	@Column(name="data_consulta")
	@Basic(optional = false)
	private Date dataConsulta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	
	public Date getDataConsulta() {
		return dataConsulta;
	}

	public void setDataConsulta(Date dataConsulta) {
		this.dataConsulta = dataConsulta;
	}
	
	
}