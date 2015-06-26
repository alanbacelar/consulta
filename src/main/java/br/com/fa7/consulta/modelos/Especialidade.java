package br.com.fa7.consulta.modelos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="especialidade")
public class Especialidade {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidade")
	private Long id;
	
	@Column(name="nome_especialidade")
	@Basic(optional = false)
	private String nomeEspecialidade;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNomeEspecialidade() {
		return nomeEspecialidade;
	}

	public void setNomeEspecialidade(String nomeEspecialidade) {
		this.nomeEspecialidade = nomeEspecialidade;
	}

	public Especialidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}