package br.com.fa7.consulta.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.UsuarioDao;
import br.com.fa7.consulta.modelos.Usuario;

@Named
@RequestScoped
public class UsuarioBean {
	
	private Usuario usuario = new Usuario();
	
	@Inject
	private UsuarioDao dao;
	
	public void salvar() throws IOException {
		dao.salvar(usuario);
		System.out.println("INSERIDO: " + usuario.getNome());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("usuarios.xhtml");
	}
	
	public void remover(String login){
		dao.remover(login);
		System.out.println("REMOVIDO: " + usuario.getNome());
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
		
	@SuppressWarnings("unchecked")
	public List<Usuario> getUsuarios() {
		return (List<Usuario>) dao.listarTodos(Usuario.class);
	}
	
}
