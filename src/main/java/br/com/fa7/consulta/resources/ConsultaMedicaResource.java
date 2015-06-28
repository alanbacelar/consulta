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

import br.com.fa7.consulta.daos.ConsultaMedicaDao;
import br.com.fa7.consulta.modelos.ConsultaMedica;

@Stateless
@Path("consultas")
public class ConsultaMedicaResource extends BaseResource {

	ConsultaMedica consulta;

	@Inject
	ConsultaMedicaDao dao;

	@Override
	public String getPath() {
		return "/consultas/";
	}
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public String lista() {
		return new Gson().toJson(dao.listarConsultas());
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") Integer id) {
		return dao.buscarConsulta(id).toJSON();
	}

	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo){
		consulta = new Gson().fromJson(conteudo, ConsultaMedica.class);
		dao.salvar(consulta);

		return responseCreated(consulta);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualiza(String conteudo){
		consulta = new Gson().fromJson(conteudo, ConsultaMedica.class);
		dao.atualizar(consulta);

		return responseOK();
	}

	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer id){
		consulta = dao.buscarConsulta(id);
		dao.remover(consulta);

		return responseOK();
	}

}
