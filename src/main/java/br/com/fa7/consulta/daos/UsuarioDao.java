package br.com.fa7.consulta.daos;

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
		return getEntityManager().find(Usuario.class, id);
	}

	public void atualizarUsuario(Integer id){
		super.atualizar(buscarUsuario(id));
	}
	
}
