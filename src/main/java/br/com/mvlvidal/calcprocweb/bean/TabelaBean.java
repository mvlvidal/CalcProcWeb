package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ViewScoped
@ManagedBean(name="tabBean")
public class TabelaBean implements Serializable{

    private static final long serialVersionUID = 1L;
    
    private Tabela tab1;
    private TabelaDao tabDao;
    private List<Tabela> tabelas;
    private List<String> tiposTabela;
    private boolean editar;
    
    @PostConstruct
    public void init(){
    
        tab1 = new Tabela();
        tabDao = new TabelaDao();
        tabelas = new ArrayList<>();
        listar();
        tiposTabela = new ArrayList<>();
        tiposTabela = carregaTipos();
        this.editar = false;
    }
    
    public void salvar(){
        
        Tabela tab2 = tabDao.salvar(tab1);
        
        if (tab2 != null){
            tab1 = tab2;
            listar();
        }
    }
    
    public void editar(){
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");
        
        if(id != null){
            tab1 = tabDao.find(Long.parseLong(id));
            this.editar = true;
        }
        
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
        
        List<Tabela> lista = tabDao.listar(tipo);
        
        return lista;
    }
    
    public void listar(){
    
        tabelas = tabDao.listar();
        
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

    public boolean getEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
    
    
}
