package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Usuario;

@Stateless
public class UsuarioDao extends GenericDao {
	
	public Usuario buscaPeloLogin(String login) {
		TypedQuery<Usuario> query = getEntityManager().createQuery(
				"select u from Usuario u where u.login = :login ", Usuario.class);

		return query.setParameter("login", login).getSingleResult();
	}

	public Usuario buscarUsuario(Integer id) {
		try {
			return (Usuario) super.busca(Usuario.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Usuario();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Usuario> listarTodos(){
		return (List<Usuario>) super.listarTodos(Usuario.class);
	}

}
