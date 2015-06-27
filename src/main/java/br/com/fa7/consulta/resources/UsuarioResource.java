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

import br.com.fa7.consulta.daos.UsuarioDao;
import br.com.fa7.consulta.modelos.Usuario;

@Stateless
@Path("usuarios")
public class UsuarioResource extends BaseResource {

	Usuario usuario;
	
	@Inject
	UsuarioDao dao;
	
	@Override
	public String getPath() {
		return "/usuarios/";
	}

	@GET
	@Path("{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public String busca(@PathParam("id") Integer id) {
		return dao.busca(id).toJSON();
	}
	
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response adiciona(String conteudo){
		usuario = new Gson().fromJson(conteudo, Usuario.class);
		dao.salvar(usuario);

		return responseCreated(usuario);
	}

	@PUT
	@Produces(MediaType.APPLICATION_JSON)
	public Response atualiza(String conteudo){
		usuario = new Gson().fromJson(conteudo, Usuario.class);
		dao.atualizar(usuario);

		return responseOK();
	}
	
	
	@DELETE
	@Path("{id}")
	public Response remover(@PathParam("id") Integer id){
		usuario = dao.busca(id);
		dao.remover(usuario);

		return responseOK();
	}
	

}
