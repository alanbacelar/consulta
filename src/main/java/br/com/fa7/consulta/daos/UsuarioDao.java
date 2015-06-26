package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Usuario;

@Stateless
public class UsuarioDao extends GenericDao {
	
	public void salvar(Usuario usuario) {
		salvar(usuario);
	}
	
	public Usuario buscaPeloLogin(String login) {
		TypedQuery<Usuario> query = getEntityManager().createQuery(
				"select u from Usuario u where u.login=:login ", Usuario.class);

		return query.setParameter("login", login).getSingleResult();
	}
	
	public void remover(String login){
		remover(buscaPeloLogin(login));
	}
	
}
