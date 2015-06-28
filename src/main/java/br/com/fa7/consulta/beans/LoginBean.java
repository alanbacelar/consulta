package br.com.fa7.consulta.beans;

import java.io.IOException;

import javax.enterprise.inject.Model;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;

import br.com.fa7.consulta.daos.UsuarioDao;
import br.com.fa7.consulta.exception.UsuarioInvalidoException;
import br.com.fa7.consulta.modelos.Usuario;

@Model
public class LoginBean {

	private Usuario usuario = new Usuario();

	@Inject
	private UsuarioDao dao;

	@Inject
	private AutenticarBean autenticar;
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void autenticar() throws IOException {
		Usuario usuarioEncontrado;
		try {
			usuarioEncontrado = this.dao.autenticarUsuario(usuario);
			
			if (usuarioEncontrado != null) {
				autenticar.logar(usuarioEncontrado);
			}
			
		} catch (UsuarioInvalidoException e) {
			// TODO Auto-generated catch block
			this.usuario = new Usuario();
			FacesContext.getCurrentInstance().addMessage("loginForm",
					new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), "Usuário e/ou senha inválidos"));
		}
	}

	public void logout() throws IOException  {
		this.autenticar.deslogar();
	}
}