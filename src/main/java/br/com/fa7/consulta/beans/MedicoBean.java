package br.com.fa7.consulta.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
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

	public void salvar() throws IOException {
		dao.salvar(medico);
		System.out.println("INSERIDO: " + medico.getNome());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("medicos.xhtml");
	}

	public void removerMedico(String id) {
		dao.remover(dao.buscarMedico(id));
		System.out.println("REMOVIDO: " + medico.getNome());
	}

	public Medico getMedico() {
		return medico;
	}

	public List<Medico> getMedicos() {
		List<Medico> medicos = dao.listarMedicos();
		
		return  medicos;//(List<Medico>) dao.listarTodos(Medico.class);
	}
}
