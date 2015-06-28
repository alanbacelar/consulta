package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.ConsultaMedica;

@Stateless
public class ConsultaMedicaDao extends GenericDao {

	public ConsultaMedica buscarConsulta(Integer id) {
		try {
			return (ConsultaMedica) super.busca(ConsultaMedica.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ConsultaMedica();
		}
	}

	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> listarConsultas() {
		return (List<ConsultaMedica>) super.listarTodos(ConsultaMedica.class, "dataConsulta");
	}

}
