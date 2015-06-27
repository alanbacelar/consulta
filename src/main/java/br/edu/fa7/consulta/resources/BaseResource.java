package br.edu.fa7.consulta.resources;

import java.net.URI;

import javax.ws.rs.core.Response;

import br.com.fa7.consulta.interfaces.Model;

abstract class BaseResource {
	
	public Response responseCreated(Model model) {
		URI uri = URI.create(getPath() + model.getId());
		return Response.created(uri).build();
	}
	
	public Response responseOK() {
		return Response.ok().build();
	}
	
	abstract public String getPath();
}
