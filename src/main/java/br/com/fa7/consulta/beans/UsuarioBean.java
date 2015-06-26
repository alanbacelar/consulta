package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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
	
	public void salvar() {
		dao.salvar(usuario);
		System.out.println("INSERIDO: " + usuario.getNome());
	}
	
	public void remover(String login){
		dao.remover(login);
		System.out.println("REMOVIDO: " + usuario.getNome());
	}
	
	public Usuario getUsuario() {
		return usuario;
	}
		
	@SuppressWarnings("unchecked")
	public List<Usuario> getConsultas() {
		return (List<Usuario>) dao.listarTodos(Usuario.class);
	}
	
}
