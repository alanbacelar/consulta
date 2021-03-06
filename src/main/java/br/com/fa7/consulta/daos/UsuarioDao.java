package br.com.fa7.consulta.daos;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.exception.UsuarioInvalidoException;
import br.com.fa7.consulta.modelos.Usuario;

@Stateless
@Startup
public class UsuarioDao extends GenericDao {

	public Usuario buscaPeloLogin(String login) {
		try {
			TypedQuery<Usuario> query = getEntityManager().createQuery("select u from Usuario u where u.login = :login ", Usuario.class);
			return query.setParameter("login", login).getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}
	
	public boolean hasUsuarioAdmin() {
		Usuario admin = buscaPeloLogin("admin");
		return (admin != null);
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
	public List<Usuario> listarTodos() {
		return (List<Usuario>) super.listarTodos(Usuario.class);
	}

	public Usuario autenticarUsuario(Usuario usuario)
			throws UsuarioInvalidoException {

		TypedQuery<Usuario> query = getEntityManager()
				.createQuery(
						"select u from Usuario u where u.login =:login and u.senha =:senha ",
						Usuario.class);

		try {
			return (Usuario) query.setParameter("login", usuario.getLogin())
					.setParameter("senha", usuario.getSenha())
					.getSingleResult();
		} catch (NoResultException e) {
			throw new UsuarioInvalidoException();	
		}
	}
	
	@PostConstruct
	void criaUsuarioAdmin() {
		if (!hasUsuarioAdmin()) {
			getEntityManager().persist(new Usuario("Admin", "admin@admin.com", "admin", "pass"));
			System.out.println("Usuário admin criado com a senha: pass.");
		}		
	}

}
