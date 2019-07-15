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
    private List<String> tiposTabela;
    
    @PostConstruct
    public void init(){
    
        tab1 = new Tabela();
        tabDao = new TabelaDao();
        tabelas = new ArrayList<>();
        tabelas = tabDao.listar();
        tiposTabela = new ArrayList<>();
        tiposTabela = carregaTipos();
        
    }
    
    public void salvar(){
        
        Tabela tab2 = tab1;
        
        if(tab2 != null){
            tabDao.salvar(tab1);
        }
        
    }
    
    public void selecionar(Tabela tab){
        
        if(tab != null){
            tab1 = tab;
        }
    }
    
    public void excluir(Tabela tab){
 
        if(tab1 != null){            
            tabDao.deletar(tab1.getId());
        }else{
            System.out.println("@@ ID NULO! @@");
        }
    }

    public List<String> carregaTipos(){
        
        List<String> lista = new ArrayList<>();
  
        lista.add("AMB");
        lista.add("CBHPM");
        
        return lista;
    }
    
    public List<Tabela> carregaTabelas(String tipo){
        List<Tabela> lista = new ArrayList<>();
        
        lista = tabDao.listar(tipo);
        
        return lista;
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

    public List<String> getTiposTabela() {
        return tiposTabela;
    }

    public void setTiposTabela(List<String> tiposTabela) {
        this.tiposTabela = tiposTabela;
    }
    
    
}
