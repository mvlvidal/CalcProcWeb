package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Procedimento;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class ProcedimentoDao extends GenericDao<Procedimento, Long> {
   
    public ProcedimentoDao(){
        super(Procedimento.class);
    } 
    
    public List<Procedimento> listar(Tabela tab) {
        
        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
               
        criteria.add(Restrictions.eq("tabela",tab));
        
        return criteria.list();
    }
    
}
