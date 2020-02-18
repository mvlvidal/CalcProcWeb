/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.converter;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author Marcus Vidal
 */
@FacesConverter(forClass = Procedimento.class, value = "procedimentoConverter")
public class ProcedimentoConverter implements Converter{

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        if (value != null) {

            Long cod = Long.parseLong(value);          
            ProcedimentoDao procedimentoDao = new ProcedimentoDao();
            Procedimento procedimento = procedimentoDao.find(cod);

            return procedimento;
        }

        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object objeto) {
        
        if (objeto != null) {
            Procedimento procedimento = (Procedimento) objeto;
            return procedimento.getId().toString();
        }

        return null;
    }
    
}
