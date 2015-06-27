package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Medico;

@Stateless
public class MedicoDao extends GenericDao {
	
	public Medico buscarMedico(String idMedico) {
		TypedQuery<Medico> query = getEntityManager().createQuery(
				"select m from Medico m where m.id=:idMedico ", Medico.class);

		return query.setParameter("id", idMedico).getSingleResult();
	}
	
}
