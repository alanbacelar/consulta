package br.com.fa7.converters;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import br.com.fa7.consulta.modelos.Especialidade;

@FacesConverter(forClass=Especialidade.class)
public class EspecialidadeConverter implements Converter {

	@Override
	public Object getAsObject(FacesContext context, UIComponent component,
			String value) {
		if (value != null && !value.isEmpty()) {
            return (Especialidade) component.getAttributes().get(value);
        }
        return null;
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component,
			Object value) {
		if (value instanceof Especialidade) {
            Especialidade entity= (Especialidade) value;
            if (entity != null && entity instanceof Especialidade && entity.getId() != null) {
                component.getAttributes().put( entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
	}

}
