package br.com.fa7.consulta.modelos;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import br.com.fa7.consulta.interfaces.Model;

@Entity
@Table(name="especialidade")
public class Especialidade extends BaseModel implements Model {
	
	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidade")
	private Integer id;
	
	@Column(name="nome_especialidade")
	@Basic(optional = false)
	private String nomeEspecialidade;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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