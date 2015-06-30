package br.com.fa7.consultas.managedbeans;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.fa7.consulta.modelos.Usuario;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;

@ManagedBean
public class UsuarioMB implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -301762493176837308L;

	private Usuario usuario = new Usuario();
	private Client c = Client.create();
	private Gson gson = new Gson();
	private static final String URL = "http://localhost:8080/consulta/api/usuarios";

	public List<Usuario> listarUsuarios() {
		WebResource wr = c.resource(URL);
		String json = wr.get(String.class);
		return gson.fromJson(json, new TypeToken<List<Usuario>>() {
		}.getType());
	}

	public void salvar() throws IOException {
		WebResource wr = c.resource(URL);
		if (usuario.getId() == null) {
			wr.type("application/json").accept("application/json")
					.post(new Gson().toJson(usuario));
		} else {
			wr.type("application/json").accept("application/json")
					.put(new Gson().toJson(usuario));
		}
		FacesContext.getCurrentInstance().getExternalContext()
				.redirect("usuarios-rest.xhtml");
	}

	public void remover() throws IOException {
		WebResource wr = c.resource(URL + "/" + usuario.getId());
		wr.delete();
		FacesContext.getCurrentInstance().getExternalContext()
		.redirect("usuarios-rest.xhtml");
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
