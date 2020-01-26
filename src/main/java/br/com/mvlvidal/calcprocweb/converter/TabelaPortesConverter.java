package br.com.mvlvidal.calcprocweb.converter;

import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TabelaPortes.class, value = "tabelaPortesConverter")
public class TabelaPortesConverter implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null) {

            Long cod = Long.parseLong(value);          
            TabelaPortesDao tabelaPortesDao = new TabelaPortesDao();
            TabelaPortes tabelaPortes = tabelaPortesDao.find(cod);

            return tabelaPortes;
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {

        if (objeto != null) {
            TabelaPortes tabelaPortes = (TabelaPortes) objeto;
            return tabelaPortes.getId().toString();
        }

        return null;
    }

}
