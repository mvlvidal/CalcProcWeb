package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean
public class ProcedimentoBean {
    
    Procedimento proc1;
    ProcedimentoDao procDao;
    List<Procedimento> procedimentos;
    
    @PostConstruct
    public void init(){
    
        proc1 = new Procedimento();
        procDao = new ProcedimentoDao();
        procedimentos = new ArrayList<>();
        procedimentos = procDao.listar();
        
    }
    
    public void salvar(){
        
        Procedimento proc2 = proc1;
        
        if(proc2 != null){
            procDao.salvar(proc1);
        }
        
    }
    
}
