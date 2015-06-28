package br.com.fa7.consulta.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.EspecialidadeDao;
import br.com.fa7.consulta.modelos.Especialidade;

@Named
@RequestScoped
public class EspecialidadeBean {
	
	private Especialidade especialidade = new Especialidade();
	
	@Inject
	private EspecialidadeDao dao;
	
	public void salvar() throws IOException {
		dao.salvar(especialidade);
		System.out.println("INSERIDO: " + especialidade.getNomeEspecialidade());
		FacesContext.getCurrentInstance().getExternalContext().redirect("especialidades.xhtml");
	}

	public void removerEspecialidade(String id) {
		dao.remover(dao.buscarEspecialidade(id));
		System.out.println("REMOVIDO: " + especialidade.getNomeEspecialidade());
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public List<Especialidade> getEspecialidades() {
		return dao.listarEspecialidades(); 
	}
}
