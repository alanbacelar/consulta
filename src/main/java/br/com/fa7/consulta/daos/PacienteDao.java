package br.com.fa7.consulta.daos;

import java.util.List;

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.Paciente;

@Stateless
public class PacienteDao extends GenericDao {
	
	public void salvar(Paciente paciente) {
		super.salvar(paciente);
		System.out.println("SALVANDO DAO: " + paciente.getNome());
	}
	
	public Paciente buscarPaciente(Integer id) {
		return (Paciente) super.busca(Paciente.class, id);
	}
	
	@SuppressWarnings("unchecked")
	public List<Paciente> listarPacientes(){
		return super.getEntityManager().createQuery("Select p from Paciente p Order By p.nome").getResultList();
	}
	
}
