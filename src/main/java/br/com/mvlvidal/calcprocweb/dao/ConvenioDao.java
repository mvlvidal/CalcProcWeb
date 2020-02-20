/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Convenio;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

/**
 *
 * @author mvlvidal
 */
public class ConvenioDao extends GenericDao<Convenio, Long>{
    
     public ConvenioDao(){
        super(Convenio.class);
    }
    
    public List<Convenio> listarPorNome(String nome){
        
        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Convenio.class);
        criteria.add(Restrictions.like("nome","%"+nome+"%"));
              
        return criteria.list();
    }
}
