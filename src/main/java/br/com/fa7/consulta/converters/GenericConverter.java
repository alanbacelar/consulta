package br.com.fa7.consulta.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.fa7.consulta.interfaces.Model;

@FacesConverter(forClass=Model.class)
public class GenericConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.isEmpty()) {
            return (Model) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Model) {
            Model entity= (Model) value;
            if (entity != null && entity instanceof Model && entity.getId() != null) {
                component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
