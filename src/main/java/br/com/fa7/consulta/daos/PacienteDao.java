package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.Paciente;

@Stateless
public class PacienteDao extends GenericDao {
	
	public void salvar(Paciente paciente) {
		salvar(paciente);
	}
	
	public Paciente buscar(String idPaciente) {
		TypedQuery<Paciente> query = getEntityManager().createQuery(
				"select p from Paciente p where p.id=:idPaciente ", Paciente.class);

		return query.setParameter("id", idPaciente).getSingleResult();
	}
	
	public void remover(String idPaciente){
		remover(buscar(idPaciente));
	}
	
}
