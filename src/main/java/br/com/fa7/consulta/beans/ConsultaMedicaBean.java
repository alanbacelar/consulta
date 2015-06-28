package br.com.fa7.consulta.beans;

import java.io.IOException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.ConsultaMedicaDao;
import br.com.fa7.consulta.modelos.ConsultaMedica;

@Named
@RequestScoped
public class ConsultaMedicaBean {
	
	private ConsultaMedica consulta = new ConsultaMedica();

	@Inject
	private ConsultaMedicaDao dao;

	public void salvar() throws IOException {
		dao.salvar(consulta);
		System.out.println("INSERIDO: " + consulta.getPaciente().getNome());
		
		FacesContext.getCurrentInstance().getExternalContext().redirect("consultas.xhtml");
	}

	public void remover(Integer id) {
		dao.remover(dao.buscarConsulta(id));
		System.out.println("REMOVIDO: " + consulta.getPaciente().getNome());
	}

	public ConsultaMedica getConsulta() {
		return consulta;
	}

	public List<ConsultaMedica> getConsultas() {
		return dao.listarConsultas();
	}
}
