package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fa7.consulta.interfaces.Model;

@Stateless
@Startup
public abstract class GenericDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Model modelo){
		em.persist(modelo);
	}
	
	public void remover(Model modelo){
		em.remove(modelo);
	}
	
	public Model atualizar(Model modelo){
		return em.merge(modelo);
	}
	
	public List<?> listarTodos(Class<?> c){
		return em.createQuery("Select c from "+c.getName()+" c").getResultList();
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
}
