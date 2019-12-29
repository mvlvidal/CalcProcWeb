package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.TabelaDao;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
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
@ManagedBean(name = "tabelaProcedimentosBean")
public class TabelaProcedimentosBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private TabelaProcedimentos tab1;
    private TabelaDao tabDao;
    private List<TabelaProcedimentos> tabelas;
    private List<String> tiposTabela;
    private boolean editar;

    // CONSTRUTOR ----------------------------------------------
    
    @PostConstruct
    public void init() {

        tab1 = new TabelaProcedimentos();
        tabDao = new TabelaDao();
        tabelas = new ArrayList<>();
        listar();
        tiposTabela = new ArrayList<>();
        tiposTabela = carregaTipos();
        this.editar = false;
    }

    // MÉTODOS -------------------------------------------------
    
    public void salvar() {

        TabelaProcedimentos tab2 = tabDao.salvar(tab1);

        if (tab2 != null) {
            tab1 = tab2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Tabela de Procedimentos salvo."));
            tabelas = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o tabela de procedimento."));
        }
    }

    public void editar() {

        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");

        if (id != null) {
            tab1 = tabDao.find(Long.parseLong(id));
            this.editar = true;
        }

    }

    public void excluir(Long id) {

        if (id != null) {
            tabDao.deletar(id);
        }
    }

    public List<String> carregaTipos() {

        List<String> lista = new ArrayList<>();

        lista.add("AMB");
        lista.add("CBHPM");

        return lista;
    }

    public List<TabelaProcedimentos> carregaTabelas(String tipo) {

        List<TabelaProcedimentos> lista = tabDao.listar(tipo);

        return lista;
    }

    public void listar() {

        tabelas = tabDao.listar();

    }

    
    // GETS E SETS --------------------------------------------------
    
    public TabelaProcedimentos getTab1() {
        return tab1;
    }

    public void setTab1(TabelaProcedimentos tab1) {
        this.tab1 = tab1;
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

    public boolean getEditar() {
        return editar;
    }

    public void setEditar(boolean editar) {
        this.editar = editar;
    }

}
