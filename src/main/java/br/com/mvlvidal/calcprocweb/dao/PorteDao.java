package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Porte;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class PorteDao extends GenericDao<Porte, Long>{
 
    public PorteDao(){
        super(Porte.class);
    }
    
    public List<Porte> listar(Long id){
        
        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Porte.class);
        criteria.add(Restrictions.eq("tabelaPortes.id",id));
              
        return criteria.list();
    }
}
