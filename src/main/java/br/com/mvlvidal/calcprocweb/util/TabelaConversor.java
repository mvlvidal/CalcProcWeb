package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Tabela.class, value="tabelaConversor")
public class TabelaConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null) {
            
            Long cod = Long.parseLong(value);
            
            TabelaDao tabDao = new TabelaDao();           
            Tabela tab = new Tabela();
            
            List<Tabela> tabelas = tabDao.listar();
            
            for (Tabela t: tabelas) {
                if(t.getId().equals(cod)){
                    tab = t;
                }
            }
            
            return tab;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {

        if (value != null) {
            Tabela tab = new Tabela();
            tab = (Tabela) value;
            return tab.getId().toString();
        }

        return null;
    }

}
