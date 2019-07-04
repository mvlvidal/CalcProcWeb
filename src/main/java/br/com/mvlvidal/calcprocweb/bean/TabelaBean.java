package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean(name="tabBean")
public class TabelaBean {

    private Tabela tab1;
    private TabelaDao tabDao;
    private List<Tabela> tabelas;
    
    @PostConstruct
    public void init(){
    
        tab1 = new Tabela();
        tabDao = new TabelaDao();
        tabelas = new ArrayList<>();
        tabelas = tabDao.listar();
        
    }
    
    public void salvar(){
        
        Tabela tab2 = tab1;
        
        if(tab2 != null){
            tabDao.salvar(tab1);
        }
        
    }

    public Tabela getTab1() {
        return tab1;
    }

    public void setTab1(Tabela tab1) {
        this.tab1 = tab1;
    }

    public List<Tabela> getTabelas() {
        return tabelas;
    }

    public void setTabelas(List<Tabela> tabelas) {
        this.tabelas = tabelas;
    }
    
    
}
