package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.PacienteDao;
import br.com.fa7.consulta.modelos.Paciente;

@Named
@RequestScoped
public class PacienteBean {
	private Paciente paciente = new Paciente();

	@Inject
	private PacienteDao dao;

	public void salvar() {
		dao.salvar(paciente);
		System.out.println("INSERIDO: " + paciente.getNome());
	}

	public void remover(String login) {
		dao.remover(login);
		System.out.println("REMOVIDO: " + paciente.getNome());
	}

	public Paciente getPaciente() {
		return paciente;
	}

	@SuppressWarnings("unchecked")
	public List<Paciente> getPacientes() {
		return (List<Paciente>) dao.listarTodos(Paciente.class);
	}
}
