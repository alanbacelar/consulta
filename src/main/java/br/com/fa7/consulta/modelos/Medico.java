package br.com.fa7.consulta.modelos;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import br.com.fa7.consulta.interfaces.Model;

@Entity
@Table(name="medico")
public class Medico extends BaseModel implements Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -189585170648051615L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_medico")
	private Integer id;
	
	@Basic(optional = false)
	private String nome;
	
	@Basic(optional = false)
	private String sobrenome;
	
	//@OneToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE, orphanRemoval=true)
	@ManyToOne(fetch=FetchType.EAGER, targetEntity = Especialidade.class)
	@JoinColumn(name="id_especialidade", nullable = false)
	private Especialidade especialidade;
	
	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}
	
	public Medico() {
	
	}

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

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public void setEspecialidade(Especialidade especialidade) {
		this.especialidade = especialidade;
	}
	
	
	
}