package br.com.mvlvidal.calcprocweb.converter;

import br.com.mvlvidal.calcprocweb.dao.ConvenioDao;
import br.com.mvlvidal.calcprocweb.model.Convenio;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Marcus Vidal
 */
@FacesConverter(forClass = Convenio.class, value = "convenioConverter")
public class ConvenioConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {

            Long cod = Long.parseLong(value);          
            ConvenioDao convenioDao = new ConvenioDao();
            Convenio convenio = convenioDao.find(cod);

            return convenio;
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        
        if (objeto != null) {
            Convenio convenio = (Convenio) objeto;
            return convenio.getId().toString();
        }

        return null;
    }
    
}
