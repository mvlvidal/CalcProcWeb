package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;

public class TabelaDao extends GenericDao<Tabela, Long>{

    public TabelaDao() {
        super(Tabela.class);
    }    
    
    public List<Tabela> listar(String tipo) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Tabela.class);
        criteria.add(Restrictions.eq("tipoTab", tipo));

        return criteria.list();
    }
}
