package br.com.fa7.consulta.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.model.SelectItem;
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

	public void removerEspecialidade(String id) {
		dao.remover(dao.buscarEspecialidade(id));
		System.out.println("REMOVIDO: " + especialidade.getNomeEspecialidade());
	}

	public Especialidade getEspecialidade() {
		return especialidade;
	}

	public List<SelectItem> getEspecialidades() {
		List<SelectItem> lista = new ArrayList<SelectItem>();
		List<Especialidade> listaEspecialidades = dao.listarEspecialidades(); 
		
		for(int i = 0; i < listaEspecialidades.size(); i++){
			lista.add(new SelectItem(listaEspecialidades.get(i), 
					listaEspecialidades.get(i).getNomeEspecialidade()));
		}
		
		return lista;
	}
}
