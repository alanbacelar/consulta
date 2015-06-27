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
@Table(name="paciente")
public class Paciente extends BaseModel implements Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6918653979355869140L;

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_paciente")
	private Integer id;
	
	@Basic(optional = false)
	private String nome;
	
	@Basic(optional = false)
	private String sobrenome;
	
	@Basic(optional = true)
	private String email;
	
	public Paciente(){
		
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

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}