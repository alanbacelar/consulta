package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.MedicoDao;
import br.com.fa7.consulta.modelos.Medico;

@Named
@RequestScoped
public class MedicoBean {
	
	private Medico medico = new Medico();

	@Inject
	private MedicoDao dao;

	public void salvar() {
		dao.salvar(medico);
		System.out.println("INSERIDO: " + medico.getNome());
	}

	public void remover(String id) {
		dao.remover(id);
		System.out.println("REMOVIDO: " + medico.getNome());
	}

	public Medico getMedico() {
		return medico;
	}

	@SuppressWarnings("unchecked")
	public List<Medico> getMedicos() {
		return (List<Medico>) dao.listarTodos(Medico.class);
	}
}
