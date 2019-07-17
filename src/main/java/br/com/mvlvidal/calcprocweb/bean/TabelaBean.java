package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

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
        
        Tabela tab2 = tabDao.salvar(tab1);
        
        if (tab2 != null){
            tab1 = tab2;
        }
    }
    
    public void editar(Long id){
        
        tab1 = tabDao.find(id);
        
    }
    
    public void excluir(Long id){
 
        if(id != null){            
            tabDao.deletar(id);
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
