package br.com.fa7.consulta.beans;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;

import br.com.fa7.consulta.modelos.Usuario;

@Named 
@SessionScoped
public class AutenticarBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4749707607482619634L;
	
	private Usuario usuario;

	public void logar(Usuario usuario) throws IOException {
		this.usuario = usuario;
		FacesContext.getCurrentInstance().getExternalContext().redirect("index.xhtml");
	}

	public void deslogar() throws IOException {
		this.usuario = null;
		FacesContext.getCurrentInstance().getExternalContext().redirect("logout.xhtml");
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public boolean isLogado() {
		return usuario != null;
	}
}
