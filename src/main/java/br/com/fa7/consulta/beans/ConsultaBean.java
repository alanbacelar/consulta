package br.com.fa7.consulta.beans;

import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import br.com.fa7.consulta.daos.ConsultaDao;
import br.com.fa7.consulta.modelos.Consulta;

@Named
@RequestScoped
public class ConsultaBean {
	private Consulta consulta = new Consulta();
	
	@Inject
	private ConsultaDao dao;
	
	public void cadastrar() {
		dao.inserir(consulta);
		System.out.println("INSERIDO: " + consulta.getNome());
	}
	
	public Consulta getConsulta() {
		return consulta;
	}
	
	
	public List<Consulta> getConsultas() {
		return dao.todas();
	}
	
	
}
