package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.model.Porte;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

@ViewScoped
@ManagedBean(name = "porteBean")
public class PorteBean implements Serializable {

    private Porte por1;
    private PorteDao porteDao;
    private List<Porte> portes;
    private boolean editar;

    // CONSTRUTOR ---------------------------------------------------
    
    @PostConstruct
    public void init() {

        por1 = new Porte();
        porteDao = new PorteDao();
        portes = new ArrayList<>();
        listar();
        this.editar = false;

    }

    // MÉTODOS -----------------------------------------------------
    
    public void listar() {

        portes = porteDao.listar();

    }

    public void salvar() {

        Porte por2 = porteDao.salvar(por1);

        if (por2 != null) {
            por1 = por2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Porte salvo."));
            this.editar = false;
            portes = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
        }

    }

    public void editar() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");

        if (id != null) {
            por1 = porteDao.find(Long.parseLong(id));
            this.editar = true;
        }

    }

    public void excluir(Long id) {
        porteDao.deletar(id);
        portes = new ArrayList<>();
        listar();
    }
    
    // GETS E SETS -------------------------------------------------

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

    public boolean isEditar() {
        return editar;
    }

}
