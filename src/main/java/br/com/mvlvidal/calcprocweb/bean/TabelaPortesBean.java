package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "tabelaPortesBean")
public class TabelaPortesBean implements Serializable{
    
    private TabelaPortes edi1;
    private TabelaPortesDao ediDao;
    private List<TabelaPortes> tabelasPortes;
    private boolean editar;
    
    @PostConstruct
    public void init(){
        
        edi1 = new TabelaPortes();
        ediDao = new TabelaPortesDao();
        tabelasPortes = new ArrayList<>();
        tabelasPortes = ediDao.listar();
        this.editar = false;
        
    }
    
    public String salvar(){
        
        TabelaPortes edi2 = ediDao.salvar(edi1);
        
        if(edi2 != null){
            edi1 = edi2;
            this.editar = false;
            tabelasPortes = ediDao.listar();
            return "cad-tabelaPortes";
        }else{
            return "";
        }
        
    }
    
    public String editar(Long id){
        
        if(id != null || id != 0){
            this.editar = true;
            edi1 = ediDao.find(id);            
            return "cad-tabelaPortes";
        }else{
            return "";
        }
    }
    
    public String excluir(Long id){
        
        if(id != null || id != 0){
            ediDao.deletar(id);
            tabelasPortes = ediDao.listar();
            return "cad-tabelaPortes";
        }else{
            return "";
        }
    }

    public TabelaPortes getEdi1() {
        return edi1;
    }

    public void setEdi1(TabelaPortes edi1) {
        this.edi1 = edi1;
    }

    public List<TabelaPortes> getTabelasPortes() {
        return tabelasPortes;
    }

    public void setTabelasPortes(List<TabelaPortes> tabelasPortes) {
        this.tabelasPortes = tabelasPortes;
    }

    public boolean isEditar() {
        return editar;
    }
   
}
