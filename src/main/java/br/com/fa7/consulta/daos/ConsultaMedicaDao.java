package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.ConsultaMedica;

@Stateless
public class ConsultaMedicaDao extends GenericDao {
	
	public void salvar(ConsultaMedica consulta) {
		salvar(consulta);
	}
	
	public ConsultaMedica buscar(String idConsulta) {
		TypedQuery<ConsultaMedica> query = getEntityManager().createQuery(
				"select c from ConsultaMedica c where c.id=:idPaciente ", ConsultaMedica.class);

		return query.setParameter("id", idConsulta).getSingleResult();
	}
	
	public void remover(String idConsulta){
		remover(buscar(idConsulta));
	}
}
