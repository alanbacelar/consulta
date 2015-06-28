package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.Paciente;

@Stateless
public class PacienteDao extends GenericDao {
	
	public Paciente buscarPaciente(Integer id) {
		try {
			return (Paciente) super.busca(Paciente.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Paciente();
		}
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listarPacientes(){
		return (List<Paciente>) super.listarTodos(Paciente.class);
	}
	
}
