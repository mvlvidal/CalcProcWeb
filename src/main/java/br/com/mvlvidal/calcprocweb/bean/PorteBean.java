package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.model.Porte;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name="porBean")
public class PorteBean {

    private Porte por1;
    private PorteDao porDao;
    private List<Porte> portes;
    
    @PostConstruct
    public void init(){
    
        por1 = new Porte();
        porDao = new PorteDao();
        portes = new ArrayList<>();
        portes = porDao.listar();
        
    }
    
    public void salvar(){
        
        Porte por2 = por1;
        
        if(por2 != null){
            porDao.salvar(por1);
        }
        
    }

    public Porte getPor1() {
        return por1;
    }

    public void setPor1(Porte por1) {
        this.por1 = por1;
    }

    public List<Porte> getPortes() {
        return portes;
    }

    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }
    
    
}
