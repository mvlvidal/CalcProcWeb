package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Tabela.class, value = "tabelaConversor")
public class TabelaConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        Tabela tabela;

        if (value != null) {

            Long cod = Long.parseLong(value);

            TabelaDao tabDao = new TabelaDao();
            tabela = tabDao.find(cod);
            return tabela;
        }
        
        return null;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
        if (objeto != null) {
            Tabela tabela = (Tabela) objeto;
            return tabela.getId().toString();
        }

        return null;
    }

}
