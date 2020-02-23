package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Porte;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.List;
import javax.persistence.Query;
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
    
    public Porte buscarPorTabelaENome(TabelaPortes tabelaPortes, String nome){
        
        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Query q = sessao.createQuery("SELECT p FROM Porte p WHERE p.tabelaPortes = :tabela AND p.nome = :nome");
        q.setParameter("tabela", tabelaPortes);
        q.setParameter("nome", nome);
        
        Porte porte = (Porte)q.getSingleResult();
        
        return porte;
    }
}
