package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Especialidade;

@Stateless
public class EspecialidadeDao extends GenericDao {
	
	public void salvar(Especialidade especialidade) {
		salvar(especialidade);
	}
	
	public Especialidade buscar(String idEspecialidade) {
		TypedQuery<Especialidade> query = getEntityManager().createQuery(
				"select e from Especialidade e where e.id=:idEspecialidade ", Especialidade.class);

		return query.setParameter("id", idEspecialidade).getSingleResult();
	}
	
	public void remover(String idEspecialidade){
		remover(buscar(idEspecialidade));
	}
}
