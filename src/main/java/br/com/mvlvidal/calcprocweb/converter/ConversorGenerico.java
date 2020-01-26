/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.converter;

import br.com.mvlvidal.calcprocweb.model.AbstractModel;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author mvlvidal
 */
@FacesConverter(forClass = AbstractModel.class, value = "conversorGenerico")
public class ConversorGenerico implements Converter {

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String value) {
        if (value != null && !value.isEmpty()) {
            return (AbstractModel) uic.getAttributes().get(value);
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object value) {
        if (value instanceof AbstractModel) {
            AbstractModel entity = (AbstractModel) value;
            if (entity != null && entity instanceof AbstractModel && entity.getId() != null) {
                uic.getAttributes().put(entity.getId().toString(), entity);
                return entity.getId().toString();
            }
        }
        return "";
    }

}
