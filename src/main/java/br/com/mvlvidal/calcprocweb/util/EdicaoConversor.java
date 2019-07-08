package br.com.mvlvidal.calcprocweb.util;

import br.com.mvlvidal.calcprocweb.dao.EdicaoDao;
import br.com.mvlvidal.calcprocweb.model.Edicao;
import java.util.ArrayList;
import java.util.List;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = Edicao.class, value = "edicaoConversor")
public class EdicaoConversor implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {

        if (value != null) {

            int cod = Integer.parseInt(value);

            System.out.println("@@@@@@@ VALOR: " + cod);
            
            Edicao edicao = new Edicao();
            List<Edicao> edicoes = new ArrayList<>();           
            EdicaoDao ediDao = new EdicaoDao();           
            edicoes = ediDao.listar();
            
            for(Edicao e: edicoes){
                if(e.getId() == cod){
                    edicao = e;
                }
            }

            return edicao;
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object objeto) {

        if (objeto != null) {
            Edicao edicao = (Edicao) objeto;
            return edicao.getId().toString();
        }

        return null;
    }

}
