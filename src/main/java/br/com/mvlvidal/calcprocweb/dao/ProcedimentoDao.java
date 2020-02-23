package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Procedimento;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.io.Serializable;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.LogicalExpression;
import org.hibernate.criterion.Restrictions;

public class ProcedimentoDao extends GenericDao<Procedimento, Long> implements Serializable {

    public ProcedimentoDao() {
        super(Procedimento.class);
    }

    public List<Procedimento> listarPorTabela(TabelaProcedimentos tabelaProcedimento) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        criteria.add(Restrictions.eq("tabela", tabelaProcedimento));

        return criteria.list();
    }

    public List<Procedimento> listarPorDescricaoETabela(String descricao, TabelaProcedimentos tabelaProcedimento) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        criteria.add(Restrictions.eq("tabela", tabelaProcedimento));
        criteria.add(Restrictions.like("descricao", "%" + descricao + "%"));

        return criteria.list();
    }

    public List<Procedimento> listarPorTabelas(TabelaProcedimentos tabHm, TabelaProcedimentos tabSadt) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        Criterion classificacaoHm = Restrictions.eq("classificacao", "HM");
        Criterion classificacaoSadt = Restrictions.eq("classificacao", "SADT");
        Criterion tabelaHm = Restrictions.eq("tabela", tabHm);
        Criterion tabelaSadt = Restrictions.eq("tabela", tabSadt);
        
        LogicalExpression andCriterioHm = Restrictions.and(tabelaHm, classificacaoHm);
        LogicalExpression andCriterioSadt = Restrictions.and(tabelaSadt, classificacaoSadt);
        
        LogicalExpression orCriterio = Restrictions.or(andCriterioHm,andCriterioSadt);
        
        criteria.add(orCriterio);

        return criteria.list();

    }

    public List<Procedimento> listarPorCódigoETabelas(Long codigo, TabelaProcedimentos tabHm, TabelaProcedimentos tabSadt) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        criteria.add(Restrictions.eq("codigo",codigo));
        Criterion classificacaoHm = Restrictions.eq("classificacao", "HM");
        Criterion classificacaoSadt = Restrictions.eq("classificacao", "SADT");
        Criterion tabelaHm = Restrictions.eq("tabela", tabHm);
        Criterion tabelaSadt = Restrictions.eq("tabela", tabSadt);
        
        LogicalExpression andCriterioHm = Restrictions.and(tabelaHm, classificacaoHm);
        LogicalExpression andCriterioSadt = Restrictions.and(tabelaSadt, classificacaoSadt);
        
        LogicalExpression orCriterio = Restrictions.or(andCriterioHm,andCriterioSadt);
        
        criteria.add(orCriterio);
        
        return criteria.list();

    }

    public List<Procedimento> listarPorDescricaoETabelas(String descricao, TabelaProcedimentos tabHm, TabelaProcedimentos tabSadt) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        criteria.add(Restrictions.like("descricao", "%" + descricao + "%"));
        Criterion classificacaoHm = Restrictions.eq("classificacao", "HM");
        Criterion classificacaoSadt = Restrictions.eq("classificacao", "SADT");
        Criterion tabelaHm = Restrictions.eq("tabela", tabHm);
        Criterion tabelaSadt = Restrictions.eq("tabela", tabSadt);
        
        LogicalExpression andCriterioHm = Restrictions.and(tabelaHm, classificacaoHm);
        LogicalExpression andCriterioSadt = Restrictions.and(tabelaSadt, classificacaoSadt);
        
        LogicalExpression orCriterio = Restrictions.or(andCriterioHm,andCriterioSadt);
        
        criteria.add(orCriterio);

        return criteria.list();

    }

    public List<Procedimento> listarPorCódigoDescricaoETabelas(Long codigo, String descricao, TabelaProcedimentos tabHm, TabelaProcedimentos tabSadt) {

        Session sessao = br.com.mvlvidal.calcprocweb.dao.HibernateUtil.getSession();

        Criteria criteria = sessao.createCriteria(Procedimento.class);
        criteria.add(Restrictions.eq("codigo",codigo));
        criteria.add(Restrictions.like("descricao", "%" + descricao + "%"));
        Criterion classificacaoHm = Restrictions.eq("classificacao", "HM");
        Criterion classificacaoSadt = Restrictions.eq("classificacao", "SADT");
        Criterion tabelaHm = Restrictions.eq("tabela", tabHm);
        Criterion tabelaSadt = Restrictions.eq("tabela", tabSadt);
        
        LogicalExpression andCriterioHm = Restrictions.and(tabelaHm, classificacaoHm);
        LogicalExpression andCriterioSadt = Restrictions.and(tabelaSadt, classificacaoSadt);
        
        LogicalExpression orCriterio = Restrictions.or(andCriterioHm,andCriterioSadt);
        
        criteria.add(orCriterio);

        return criteria.list();

    }

}
