package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TabelaPortes.class, value = "tabelaPortesConversor")

public class TabelaPortesConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null) {

            Long cod = Long.parseLong(value);

            TabelaPortes tabelaPortes = new TabelaPortes();                     
            TabelaPortesDao ediDao = new TabelaPortesDao(); 
            List<TabelaPortes> tabelasPortes = new ArrayList<>();
            tabelasPortes = ediDao.listar();
            
            for(TabelaPortes t: tabelasPortes){
                if(t.getId().equals(cod)){
                    tabelaPortes = t;
                }
            }

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
