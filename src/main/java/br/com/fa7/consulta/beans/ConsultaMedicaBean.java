package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
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

	public void salvar() {
		dao.salvar(consulta);
		System.out.println("INSERIDO: " + consulta.getPaciente().getNome());
	}

	public void remover(String id) {
		dao.remover(id);
		System.out.println("REMOVIDO: " + consulta.getPaciente().getNome());
	}

	public ConsultaMedica getConsulta() {
		return consulta;
	}

	@SuppressWarnings("unchecked")
	public List<ConsultaMedica> getMedicos() {
		return (List<ConsultaMedica>) dao.listarTodos(ConsultaMedica.class);
	}
}
