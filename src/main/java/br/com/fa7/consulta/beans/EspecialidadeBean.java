package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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
	
	public void salvar() {
		dao.salvar(especialidade);
		System.out.println("INSERIDO: " + especialidade.getNomeEspecialidade());
	}

	public void remover(String login) {
		dao.remover(login);
		System.out.println("REMOVIDO: " + especialidade.getNomeEspecialidade());
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	@SuppressWarnings("unchecked")
	public List<Especialidade> getEspecialidades() {
		return (List<Especialidade>) dao.listarTodos(Especialidade.class);
	}
}