package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaProcedimentosDao;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "tabelaProcedimentosBean")
public class TabelaProcedimentosBean{

    private TabelaProcedimentos tabelaProcedimentos1;
    private TabelaProcedimentosDao tabelaProcedimentosDao;
    private List<TabelaProcedimentos> tabelas;
    private List<String> tiposTabela;
    private Pesquisa pesquisa;

    // CONSTRUTOR ----------------------------------------------
    @PostConstruct
    public void init() {

        tabelaProcedimentos1 = new TabelaProcedimentos();
        tabelaProcedimentosDao = new TabelaProcedimentosDao();
        tabelas = new ArrayList<>();
        listar();
        tiposTabela = carregaTipos();
        pesquisa = new Pesquisa();
    }

    // MÉTODOS -------------------------------------------------
    public void salvar() {

        TabelaProcedimentos tabelaProcedimentos2 = tabelaProcedimentosDao.salvar(tabelaProcedimentos1);

        if (tabelaProcedimentos2 != null) {
            tabelaProcedimentos1 = tabelaProcedimentos2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "TabelaProcedimentos salvo."));
            tabelas = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
        }

    }

    public void consultar() {

        if (this.pesquisa.getNome() != null && !this.pesquisa.getNome().isEmpty() && this.pesquisa.getTipo() != null && !this.pesquisa.getTipo().isEmpty()) {
            tabelas = tabelaProcedimentosDao.listarPorNomeETipo(this.pesquisa.getNome(), this.pesquisa.getTipo());
        } else {
            if (this.pesquisa.getTipo() != null && !this.pesquisa.getTipo().isEmpty()) {
                tabelas = tabelaProcedimentosDao.listarPorTipo(this.pesquisa.getTipo());
            } else {
                if (this.pesquisa.getNome() != null && !this.pesquisa.getNome().isEmpty()) {
                    tabelas = tabelaProcedimentosDao.listarPorNome(this.pesquisa.getNome());
                } else {
                    listar();
                }
            }
        }
    }

    public void excluir(Long id) {
        tabelaProcedimentosDao.deletar(id);
        tabelas = new ArrayList<>();
        listar();
    }

    public List<String> carregaTipos() {

        List<String> lista = new ArrayList<>();

        lista.add("AMB");
        lista.add("CBHPM");

        return lista;
    }

    public List<TabelaProcedimentos> carregaTabelas(String tipo) {

        List<TabelaProcedimentos> lista = tabelaProcedimentosDao.listarPorTipo(tipo);

        return lista;
    }

    public void listar() {

        tabelas = tabelaProcedimentosDao.listar();

    }

    // GETS E SETS --------------------------------------------------
    public TabelaProcedimentos getTabelaProcedimentos1() {
        return tabelaProcedimentos1;
    }

    public void setTabelaProcedimentos1(TabelaProcedimentos tabelaProcedimentos1) {
        this.tabelaProcedimentos1 = tabelaProcedimentos1;
    }

    public List<TabelaProcedimentos> getTabelas() {
        return tabelas;
    }

    public void setTabelas(List<TabelaProcedimentos> tabelas) {
        this.tabelas = tabelas;
    }

    public List<String> getTiposTabela() {
        return tiposTabela;
    }

    public void setTiposTabela(List<String> tiposTabela) {
        this.tiposTabela = tiposTabela;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

}
