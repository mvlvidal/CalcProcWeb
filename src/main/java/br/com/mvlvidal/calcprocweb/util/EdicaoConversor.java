package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.model.Edicao;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Edicao.class, value = "edicaoConversor")
public class EdicaoConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value == null) {
            return null;
        }

        Object obj = value;
        
        Edicao edicao = new Edicao();
        
        edicao = (Edicao)obj;
        
        return edicao;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        return null;
    }
    
}
