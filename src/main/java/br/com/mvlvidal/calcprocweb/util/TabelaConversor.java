package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Tabela.class, value="tabelaConversor")
public class TabelaConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        
        if (value != null || value.contains(null)) {
            
            Long cod = Long.parseLong(value);
            
            TabelaDao tabDao = new TabelaDao();           
            Tabela tab = tabDao.find(cod);
           
            return tab;
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        
        Tabela tabela = (Tabela)value;
        
        if (tabela != null) {  
            
            return String.valueOf(tabela.getId());
            
        }else{
            return "";
        }
    }

}
