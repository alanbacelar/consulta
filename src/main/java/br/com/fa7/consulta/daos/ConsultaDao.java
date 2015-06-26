package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.fa7.consulta.modelos.Consulta;

@Stateless
public class ConsultaDao {
	
	@PersistenceContext
	private EntityManager em;
	
	public void inserir(Consulta consulta) {
		em.persist(consulta);
	}
	
	public List<Consulta> todas() {
		return em.createQuery("SELECT c FROM Consulta c", Consulta.class).getResultList();
	}
	
}
