package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TabelaProcedimentosDao extends GenericDao<TabelaProcedimentos, Long> implements Serializable{

    public TabelaProcedimentosDao() {
        super(TabelaProcedimentos.class);
    }    
    
    public List<TabelaProcedimentos> listarPorTipo(String tipo) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(TabelaProcedimentos.class);
        criteria.add(Restrictions.eq("tipoTab", tipo));

        return criteria.list();
    }
    
    public List<TabelaProcedimentos> listarPorNome(String nome) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(TabelaProcedimentos.class);
        criteria.add(Restrictions.like("nome","%"+nome+"%"));

        return criteria.list();
    }
    
    public List<TabelaProcedimentos> listarPorNomeETipo(String nome, String tipo) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(TabelaProcedimentos.class);
        criteria.add(Restrictions.like("nome","%"+nome+"%"));
        criteria.add(Restrictions.eq("tipoTab",tipo));

        return criteria.list();
    }
    
    
}
