package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.EdicaoDao;
import br.com.mvlvidal.calcprocweb.model.Edicao;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ediBean")
public class EdicaoBean implements Serializable{
    
    private Edicao edi1;
    private EdicaoDao ediDao;
    private List<Edicao> edicoes;
    private boolean editar;
    
    @PostConstruct
    public void init(){
        
        edi1 = new Edicao();
        ediDao = new EdicaoDao();
        edicoes = new ArrayList<>();
        edicoes = ediDao.listar();
        this.editar = false;
        
    }
    
    public String salvar(){
        
        Edicao edi2 = ediDao.salvar(edi1);
        
        if(edi2 != null){
            edi1 = edi2;
            this.editar = false;
            edicoes = ediDao.listar();
            return "cad-edicao";
        }else{
            return "";
        }
        
    }
    
    public String editar(Long id){
        
        if(id != null || id != 0){
            this.editar = true;
            edi1 = ediDao.find(id);            
            return "cad-edicao";
        }else{
            return "";
        }
    }
    
    public String excluir(Long id){
        
        if(id != null || id != 0){
            ediDao.deletar(id);
            edicoes = ediDao.listar();
            return "cad-edicao";
        }else{
            return "";
        }
    }

    public Edicao getEdi1() {
        return edi1;
    }

    public void setEdi1(Edicao edi1) {
        this.edi1 = edi1;
    }

    public List<Edicao> getEdicoes() {
        return edicoes;
    }

    public void setEdicoes(List<Edicao> edicoes) {
        this.edicoes = edicoes;
    }

    public boolean isEditar() {
        return editar;
    }
   
}
