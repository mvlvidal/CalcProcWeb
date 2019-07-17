package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.EdicaoDao;
import br.com.mvlvidal.calcprocweb.model.Edicao;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "ediBean")
public class EdicaoBean {
    
    private Edicao edi1;
    private EdicaoDao ediDao;
    private List<Edicao> edicoes;
    
    @PostConstruct
    public void init(){
        
        edi1 = new Edicao();
        ediDao = new EdicaoDao();
        edicoes = new ArrayList<>();
        edicoes = ediDao.listar();
        
    }
    
    public void salvar(){
        
        Edicao edi2 = edi1;
        
        if(edi2 != null){
            ediDao.salvar(edi1);
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

    
}
