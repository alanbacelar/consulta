package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Especialidade;

@Stateless
public class EspecialidadeDao extends GenericDao {
	
	public Especialidade buscarEspecialidade(String idEspecialidade) {
		TypedQuery<Especialidade> query = getEntityManager().createQuery(
				"select e from Especialidade e where e.id=:idEspecialidade ", Especialidade.class);

		return query.setParameter("id", idEspecialidade).getSingleResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<Especialidade> listarEspecialidades(){
		return super.getEntityManager().createQuery("Select e from Especialidade e").getResultList();
	}
	
}
