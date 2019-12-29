/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Convenio;

/**
 *
 * @author mvlvidal
 */
public class ConvenioDao extends GenericDao<Convenio, Long>{
    
     public ConvenioDao(){
        super(Convenio.class);
    }
    
}
