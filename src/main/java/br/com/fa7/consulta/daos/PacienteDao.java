package br.com.fa7.consulta.daos;

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.Paciente;

@Stateless
public class PacienteDao extends GenericDao {
	
	public void salvar(Paciente paciente) {
		super.salvar(paciente);
		System.out.println("SALVANDO DAO: " + paciente.getNome());
	}
	
	public Paciente busca(Integer id) {
		return (Paciente) super.busca(Paciente.class, id);
	}
	
}
