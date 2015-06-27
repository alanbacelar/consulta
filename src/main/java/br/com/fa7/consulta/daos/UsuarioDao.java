package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Usuario;

@Stateless
public class UsuarioDao extends GenericDao {
	
	public void salvar(Usuario usuario) {
		super.salvar(usuario);
	}
	
	public Usuario buscaPeloLogin(String login) {
		TypedQuery<Usuario> query = getEntityManager().createQuery(
				"select u from Usuario u where u.login = :login ", Usuario.class);

		return query.setParameter("login", login).getSingleResult();
	}

	public Usuario busca(Integer id) {
		return (Usuario) super.busca(Usuario.class, id);
	}
	
	public void atualizar(Integer id){
		remover(busca(id));
	}
	
	public void remover(Integer id){
		remover(busca(id));
	}
	
}
