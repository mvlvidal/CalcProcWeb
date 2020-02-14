package br.com.mvlvidal.calcprocweb.converter;

import br.com.mvlvidal.calcprocweb.dao.TabelaProcedimentosDao;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TabelaProcedimentos.class, value = "conversorTabelaProcedimentos")
public class ConversorTabelaProcedimentos implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        TabelaProcedimentos tabela;

        if (value != null) {

            Long cod = Long.parseLong(value);

            TabelaProcedimentosDao tabDao = new TabelaProcedimentosDao();
            tabela = tabDao.find(cod);
            return tabela;
        }
        
        return null;

    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {
        if (objeto != null) {
            TabelaProcedimentos tabela = (TabelaProcedimentos) objeto;
            return tabela.getId().toString();
        }

        return null;
    }

}
