package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.EdicaoDao;
import br.com.mvlvidal.calcprocweb.model.Edicao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean(name = "tabBean")
public class EdicaoBean {
    
    private Edicao tab1;
    private EdicaoDao tabDao;
    private List<Edicao> tabelas;
    
    @PostConstruct
    public void init(){
        
        tab1 = new Edicao();
        tabDao = new EdicaoDao();
        tabelas = new ArrayList<>();
        tabelas = tabDao.listar();
        
    }
    
    public void salvar(){
        
        Edicao tab2 = tab1;
        
        if(tab2 != null){
            tabDao.salvar(tab1);
        }
        
    }

    public Edicao getTab1() {
        return tab1;
    }

    public void setTab1(Edicao tab1) {
        this.tab1 = tab1;
    }

    public List<Edicao> getTabelas() {
        return tabelas;
    }

    public void setTabelas(List<Edicao> tabelas) {
        this.tabelas = tabelas;
    }
    
    
}
