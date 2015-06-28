package br.com.fa7.consulta.daos;

import java.util.List;	

import javax.ejb.Stateless;

import br.com.fa7.consulta.modelos.Especialidade;

@Stateless
public class EspecialidadeDao extends GenericDao {
	
	public Especialidade buscarEspecialidade(Integer id) {
		try {
			return (Especialidade) super.busca(Especialidade.class, id);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new Especialidade();
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public List<Especialidade> listarEspecialidades(){
		return (List<Especialidade>) super.listarTodos(Especialidade.class);
	}
	
}
