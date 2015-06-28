package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.Medico;

@Stateless
public class MedicoDao extends GenericDao {
	
	public Medico buscarMedico(Integer id) {
		try {
			return (Medico) super.busca(Medico.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Medico();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Medico> listarMedicos() {
		return (List<Medico>) super.listarTodos(Medico.class);
	}
	
}
