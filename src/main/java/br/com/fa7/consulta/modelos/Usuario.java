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
@Table(name="usuario")
public class Usuario extends BaseModel implements Model {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -741175755545108409L;
	
	public Usuario() {}
	
	public Usuario(String nome, String email, String login, String senha) {
		this.nome = nome;
		this.email = email;
		this.login = login;
		this.senha = senha;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_usuario")
	private Integer id;
	
	@Basic(optional = false)
	private String login;
	
	@Basic(optional = false)
	private String nome;
	
	@Basic(optional = false)
	private String email;
	
	@Basic(optional = false)
	private String senha;
	
	public Integer getId() {
		return this.id;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	
}
