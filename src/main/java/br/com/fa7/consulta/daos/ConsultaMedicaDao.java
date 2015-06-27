package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.TypedQuery;

import br.com.fa7.consulta.modelos.ConsultaMedica;

@Stateless
public class ConsultaMedicaDao extends GenericDao {

	public ConsultaMedica buscarMedico(String idConsulta) {
		TypedQuery<ConsultaMedica> query = getEntityManager().createQuery(
				"select c from ConsultaMedica c where c.id=:idPaciente ",
				ConsultaMedica.class);

		return query.setParameter("id", idConsulta).getSingleResult();
	}

	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> listarConsultas() {
		return super
				.getEntityManager()
				.createQuery(
						"Select c from ConsultaMedica c Join Fetch c.medico Join Fetch c.paciente Join Fetch c.medico.especialidade Order By c.dataConsulta")
				.getResultList();
	}

}
