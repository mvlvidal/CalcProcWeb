/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ConvenioDao;
import br.com.mvlvidal.calcprocweb.model.Convenio;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

/**
 *
 * @author mvlvidal
 */
@ManagedBean
@ViewScoped
public class ConvenioBean implements Serializable {

    private Convenio co1;
    private ConvenioDao convenioDao;
    private List<Convenio> convenios;
    private boolean editar;

    // CONSTRUTOR ---------------------------------------------------
    @PostConstruct
    public void init() {

        co1 = new Convenio();
        convenioDao = new ConvenioDao();
        convenios = new ArrayList<>();
        listar();
        this.editar = false;
    }

    // MÉTODOS -----------------------------------------------------
    
    public void listar() {

        convenios = convenioDao.listar();

    }

    public void salvar() {

        Convenio co2 = convenioDao.salvar(co1);

        if (co2 != null) {
            co1 = co2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Convênio salvo."));
            this.editar = false;
            convenios = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o convênio."));
        }

    }

    public void editar() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");

        if (id != null) {
            co1 = convenioDao.find(Long.parseLong(id));
            this.editar = true;
        }

    }

    public void excluir(Long id) {
        convenioDao.deletar(id);
        convenios = new ArrayList<>();
        listar();
    }
    
    
    // GETS E SETS -------------------------------------------------

    public Convenio getCo1() {
        return co1;
    }

    public void setCo1(Convenio co1) {
        this.co1 = co1;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    public boolean isEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }
       
}
