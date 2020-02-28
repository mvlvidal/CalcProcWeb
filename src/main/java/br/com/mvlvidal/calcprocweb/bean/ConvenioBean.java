package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ConvenioDao;
import br.com.mvlvidal.calcprocweb.dao.TabelaPortesDao;
import br.com.mvlvidal.calcprocweb.dao.TabelaProcedimentosDao;
import br.com.mvlvidal.calcprocweb.model.Convenio;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.TabelaPortes;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author mvlvidal
 */
@ManagedBean
@ViewScoped
public class ConvenioBean implements Serializable {

    private static final long serialVersionUID = 1L;
    
    private Convenio convenio1;
    private ConvenioDao convenioDao;
    private List<Convenio> convenios;
    private Pesquisa pesquisa;
    private TabelaProcedimentosDao tabelaProcedimentosDao;
    private TabelaPortesDao tabelaPortesDao;

    // CONSTRUTOR ---------------------------------------------------
    @PostConstruct
    public void init() {

        tabelaProcedimentosDao = new TabelaProcedimentosDao();
        tabelaPortesDao = new TabelaPortesDao();
        pesquisa = new Pesquisa();
        convenio1 = new Convenio();
        convenioDao = new ConvenioDao();
        convenios = new ArrayList<>();
        listar();
    }

    // MÉTODOS -----------------------------------------------------
    public void listar() {

        convenios = convenioDao.listar();

    }

    public void salvar() {

        Convenio convenio2 = convenioDao.salvar(convenio1);

        if (convenio2 != null) {
            convenio1 = convenio2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Convenio salvo."));
            convenios = new ArrayList<>();
            listar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o porte."));
        }

    }

    public void consultar() {

        if (pesquisa.getNome() != null && !pesquisa.getNome().isEmpty()) {
            convenios = convenioDao.listarPorNome(pesquisa.getNome());
        } else {
            listar();
        }

    }

    public void excluir(Long id) {
        convenioDao.deletar(id);
        listar();
    }

    public List<Convenio> carregaAutocomplete(String nome) {
        return convenioDao.listarPorNome(nome);
    }
    
    public List<TabelaProcedimentos> carregaAutoCompleteTabelaProcedimentos(String nome){
        return tabelaProcedimentosDao.listarPorNome(nome);
    }

    public List<TabelaPortes> carregaAutoCompleteTabelaPortes(String nome){
        return tabelaPortesDao.listar(nome);
    }
    
    // GETS E SETS -------------------------------------------------
    public Convenio getConvenio1() {
        return convenio1;
    }

    public void setConvenio1(Convenio convenio1) {
        this.convenio1 = convenio1;
    }

    public List<Convenio> getConvenios() {
        return convenios;
    }

    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    /**
     * @return the pesquisa
     */
    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

}
