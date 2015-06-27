package br.com.fa7.consulta.modelos;

import java.io.Serializable;

import br.com.fa7.consulta.interfaces.Model;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

abstract class BaseModel implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3698671391121720774L;

	abstract public Integer getId();

	public String toJSON() {
		return new Gson().toJson(this);
	}

	public String toXML() {
		return new XStream().toXML(this);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Model other = (Model) obj;
		if (getId() == null) {
			if (other.getId() != null) {
				return false;
			}
		} else if (!getId().equals(other.getId())) {
			return false;
		}
		return true;
	}

}
