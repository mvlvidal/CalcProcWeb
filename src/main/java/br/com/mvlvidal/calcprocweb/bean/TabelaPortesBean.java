package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
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
@ManagedBean(name = "tabelaPortesBean")
public class TabelaPortesBean implements Serializable {

    private TabelaPortes tp1;
    private TabelaPortesDao tabelaPortesDao;
    private List<TabelaPortes> tabelasPortes;
    private boolean editar;

    // CONSTRUTOR ---------------------------------------------------
    @PostConstruct
    public void init() {

        tp1 = new TabelaPortes();
        tabelaPortesDao = new TabelaPortesDao();
        tabelasPortes = new ArrayList<>();
        listar();
        this.editar = false;

    }

    // MÉTODOS -----------------------------------------------------
    public void listar() {

        tabelasPortes = tabelaPortesDao.listar();

    }

    public void salvar() {

        TabelaPortes tp2 = tabelaPortesDao.salvar(tp1);

        if (tp2 != null) {
            tp1 = tp2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "TabelaPortes salvo."));
            this.editar = false;
            tabelasPortes = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
        }

    }

    public void editar() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");

        if (id != null) {
            tp1 = tabelaPortesDao.find(Long.parseLong(id));
            this.editar = true;
        }

    }

    public void excluir(Long id) {
        tabelaPortesDao.deletar(id);
        tabelasPortes = new ArrayList<>();
        listar();
    }

    // GETS E SETS -------------------------------------------------

    public TabelaPortes getTp1() {
        return tp1;
    }

    public void setTp1(TabelaPortes tp1) {
        this.tp1 = tp1;
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

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
   
    
}
