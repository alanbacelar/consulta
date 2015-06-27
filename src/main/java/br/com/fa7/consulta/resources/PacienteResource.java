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

import br.com.fa7.consulta.daos.PacienteDao;
import br.com.fa7.consulta.modelos.Paciente;

@Stateless
@Path("pacientes")
public class PacienteResource extends BaseResource {

	Paciente paciente;
	
	@Inject
	PacienteDao dao;
	
	@Override
	public String getPath() {
		return "/pacientes/";
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") Integer id) {
		return dao.buscarPaciente(id).toJSON();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo){
		paciente = new Gson().fromJson(conteudo, Paciente.class);
		dao.salvar(paciente);

		return responseCreated(paciente);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualiza(String conteudo){
		paciente = new Gson().fromJson(conteudo, Paciente.class);
		dao.atualizar(paciente);

		return responseOK();
	}
	
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer id){
		paciente = dao.buscarPaciente(id);
		dao.remover(paciente);

		return responseOK();
	}
	

}
