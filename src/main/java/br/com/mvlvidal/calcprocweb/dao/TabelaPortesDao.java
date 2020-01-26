package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TabelaPortesDao extends GenericDao<TabelaPortes , Long>{
   
    public TabelaPortesDao(){
        super(TabelaPortes.class);
    }
    
    public List<TabelaPortes> listar(String nome){
        
        Session sessao = HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(TabelaPortes.class);
        criteria.add(Restrictions.like("nome","%"+nome+"%"));       
        return criteria.list();
        
    }
    
}
