package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TabelaDao extends GenericDao<TabelaProcedimentos, Long> implements Serializable{

    public TabelaDao() {
        super(TabelaProcedimentos.class);
    }    
    
    public List<TabelaProcedimentos> listar(String tipo) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(TabelaProcedimentos.class);
        criteria.add(Restrictions.eq("tipoTab", tipo));

        return criteria.list();
    }
}
