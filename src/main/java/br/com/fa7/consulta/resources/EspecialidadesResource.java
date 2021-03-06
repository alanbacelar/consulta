package br.com.fa7.consulta.resources;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;

import br.com.fa7.consulta.daos.EspecialidadeDao;
import br.com.fa7.consulta.modelos.Especialidade;

@Stateless
@Path("especialidades")
public class EspecialidadesResource extends BaseResource {

	Especialidade especialidade;

	@Inject
	EspecialidadeDao dao;

	@Override
	public String getPath() {
		return "/especialidades/";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String lista() {
		return new Gson().toJson(dao.listarEspecialidades());
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") Integer id) {
		return dao.buscarEspecialidade(id).toJSON();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo){
		especialidade = new Gson().fromJson(conteudo, Especialidade.class);
		dao.salvar(especialidade);

		return responseCreated(especialidade);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualiza(String conteudo){
		especialidade = new Gson().fromJson(conteudo, Especialidade.class);
		dao.atualizar(especialidade);

		return responseOK();
	}

	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer id){
		especialidade = dao.buscarEspecialidade(id);
		dao.remover(especialidade);

		return responseOK();
	}

}
