package br.com.fa7.consulta.modelos;

import com.google.gson.Gson;
import com.thoughtworks.xstream.XStream;

abstract class BaseModel {
	
	abstract public Integer getId();
	
	public String toJSON() {
		return new Gson().toJson(this);
	}
	
	public String toXML() {
		return new XStream().toXML(this);
	}

}
