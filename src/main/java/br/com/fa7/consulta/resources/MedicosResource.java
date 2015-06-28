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

import br.com.fa7.consulta.daos.MedicoDao;
import br.com.fa7.consulta.modelos.Medico;

@Stateless
@Path("medicos")
public class MedicosResource extends BaseResource {

	Medico medico;

	@Inject
	MedicoDao dao;

	@Override
	public String getPath() {
		return "/medicos/";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String lista() {
		return new Gson().toJson(dao.listarMedicos());
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") Integer id) {
		return dao.buscarMedico(id).toJSON();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo){
		medico = new Gson().fromJson(conteudo, Medico.class);
		dao.salvar(medico);

		return responseCreated(medico);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualiza(String conteudo){
		medico = new Gson().fromJson(conteudo, Medico.class);
		dao.atualizar(medico);

		return responseOK();
	}

	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer id) {
		medico = dao.buscarMedico(id);
		dao.remover(medico);

		return responseOK();
	}

}
