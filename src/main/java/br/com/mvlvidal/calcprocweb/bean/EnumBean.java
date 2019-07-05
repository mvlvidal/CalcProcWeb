package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ClassificacaoDao;
import br.com.mvlvidal.calcprocweb.dao.TipoProcedimentoDao;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean(name="enumBean")
public class EnumBean {

    private TipoProcedimentoDao tipoProcDao;
    private ClassificacaoDao classifDao;
    
    @PostConstruct
    public void init(){
        
        tipoProcDao = new TipoProcedimentoDao();
        classifDao = new ClassificacaoDao();
        
    }

    public TipoProcedimentoDao getTipoProcDao() {
        return tipoProcDao;
    }

    public void setTipoProcDao(TipoProcedimentoDao tipoProcDao) {
        this.tipoProcDao = tipoProcDao;
    }

    public ClassificacaoDao getClassifDao() {
        return classifDao;
    }

    public void setClassifDao(ClassificacaoDao classifDao) {
        this.classifDao = classifDao;
    }
        
}
