package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Startup;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
@Startup
public abstract class GenericDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void salvar(Object obj){
		em.persist(obj);
	}
	
	public void remover(Object obj){
		em.remove(obj);
	}
	
	public List<?> listarTodos(Class<?> c){
		return em.createQuery("Select c from "+c.getName()+" c").getResultList();
	}
	
	public EntityManager getEntityManager(){
		return em;
	}
}
