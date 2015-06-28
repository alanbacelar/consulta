package br.com.fa7.consulta.modelos;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import br.com.fa7.consulta.interfaces.Model;

@Entity
@Table(name="especialidade")
public class Especialidade extends BaseModel implements Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7968084310834212579L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_especialidade")
	private Integer id;
	
	@Column(name="nome")
	@Basic(optional = false)
	private String nome;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Especialidade() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}