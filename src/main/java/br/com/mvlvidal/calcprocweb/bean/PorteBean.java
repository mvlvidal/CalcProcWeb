package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.Porte;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import org.primefaces.PrimeFaces;

@ViewScoped
@ManagedBean(name = "porteBean")
public class PorteBean{

    private Porte por1;
    private PorteDao porteDao;
    private List<Porte> portes;
    private Pesquisa pesquisa;

    private TabelaPortesDao tabelaPortesDao;

    // CONSTRUTOR ---------------------------------------------------
    @PostConstruct
    public void init() {

        por1 = new Porte();
        porteDao = new PorteDao();
        tabelaPortesDao = new TabelaPortesDao();
        portes = new ArrayList<>();
        listar();
        pesquisa = new Pesquisa();

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
            portes = new ArrayList<>();
            listar();
            PrimeFaces current = PrimeFaces.current();
            current.executeScript("PF('dialogCadastro').hide();");
            por1 = new Porte();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
        }

    }

    public void consultar() {

        if (pesquisa.getTabelaPortes() != null) {
            portes = new ArrayList<>();
            portes = porteDao.listar(pesquisa.getTabelaPortes().getId());
        } else {
            portes = new ArrayList<>();
            listar();
        }

    }

    public void excluir(Long id) {
        porteDao.deletar(id);
        portes = new ArrayList<>();
        listar();
    }

    public List<TabelaPortes> carregaAutocomplete(String nome) {
        return tabelaPortesDao.listar(nome);
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

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

}
