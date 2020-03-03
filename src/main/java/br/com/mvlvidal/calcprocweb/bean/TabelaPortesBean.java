package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "tabelaPortesBean")
public class TabelaPortesBean{

    private TabelaPortes tp1;
    private Pesquisa pesquisa;
    private TabelaPortesDao tabelaPortesDao;
    private List<TabelaPortes> tabelasPortes;

    // CONSTRUTOR ---------------------------------------------------
    @PostConstruct
    public void init() {

        tp1 = new TabelaPortes();
        pesquisa = new Pesquisa();
        tabelaPortesDao = new TabelaPortesDao();
        tabelasPortes = new ArrayList<>();
        listar();
    }

    // MÉTODOS -----------------------------------------------------
    public void listar() {

        tabelasPortes = tabelaPortesDao.listar();

    }

    public void consultar() {
        if (this.pesquisa != null) {
            tabelasPortes = new ArrayList<>();
            tabelasPortes = tabelaPortesDao.listar(this.pesquisa.getNome());
        } else {
            tabelasPortes = new ArrayList<>();
            listar();
        }
    }

    public void salvar() {

        TabelaPortes tp2 = tabelaPortesDao.salvar(tp1);

        if (tp2 != null) {
            tp1 = tp2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "TabelaPortes salvo."));
            tabelasPortes = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
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

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }
}
