package br.com.mvlvidal.calcprocweb.dao;

import br.com.mvlvidal.calcprocweb.model.Procedimento;

public class ProcedimentoDao extends GenericDao<Procedimento, Long> {
   
    public ProcedimentoDao(){
        super(Procedimento.class);
    }
}
