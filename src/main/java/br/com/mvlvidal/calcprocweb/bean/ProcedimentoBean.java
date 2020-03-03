package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ConvenioDao;
import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.dao.TabelaProcedimentosDao;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import br.com.mvlvidal.calcprocweb.model.TabelaProcedimentos;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ViewScoped
@ManagedBean(name = "procedimentoBean")
public class ProcedimentoBean{

    private static final long serialVersionUID = 1L;

    private Procedimento procedimento1;
    private ProcedimentoDao procedimentoDao;
    private TabelaProcedimentosDao tabelaProcedimentosDao;
    private List<Procedimento> procedimentos;
    private List<String> classificacoes;
    private TabelaProcedimentos tabelaProcedimentos;
    private Pesquisa pesquisa;
    private ConvenioDao convenioDao;

    //Variáveis Calculo Geral
    private float totalProc;
    private float totalFilme;
    private float valFilme;

    //Variáveis Calculo AMB
    private float valCh;

    //Variáveis Calculo CBHPM
    private float uco;

    @PostConstruct
    public void init() {
        
        pesquisa = new Pesquisa();
        procedimento1 = new Procedimento();
        procedimentoDao = new ProcedimentoDao();
        tabelaProcedimentosDao = new TabelaProcedimentosDao();
        procedimentos = new ArrayList<>();
        classificacoes = new ArrayList<>();
        classificacoes = carregaClassif();
        tabelaProcedimentos = new TabelaProcedimentos();
        convenioDao = new ConvenioDao();

        consultar();

        //VALORES PADRÃO
        //procedimento1.setAux(0);
        //procedimento1.setCo(0.0f);
        //procedimento1.setQtdFilme(0.0f);
        //procedimento1.setpAnestesico(0);
        //procedimento1.setCh(0.0f);
    }

    //MÉTODOS
    public void salvar() {

        Procedimento procedimento2 = procedimentoDao.salvar(procedimento1);

        if (procedimento2 != null) {
            procedimento1 = procedimento2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Procedimento salvo."));
            consultar();
        } else {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o procedimento."));
        }

    }

    public void excluir(Long id) {
        if (id != null) {
            procedimentoDao.deletar(id);
            consultar();
        }
    }

    public List<String> carregaClassif() {

        List<String> lista = new ArrayList<>();

        lista.add("HM");
        lista.add("SADT");

        return lista;
    }

    public void consultar() {

        System.out.println(pesquisa.getTabelaProcedimentos());

        if (pesquisa.getTabelaProcedimentos() != null) {
            procedimentos = procedimentoDao.listarPorTabela(pesquisa.getTabelaProcedimentos());
        } else {
            if (pesquisa.getTabelaProcedimentos() != null && pesquisa.getDescricao() != null && !pesquisa.getDescricao().isEmpty()) {
                procedimentos = procedimentoDao.listarPorDescricaoETabela(pesquisa.getDescricao(), pesquisa.getTabelaProcedimentos());
            } else {
                procedimentos = procedimentoDao.listar();
            }
        }

    }

    public List<TabelaProcedimentos> carregaAutocomplete(String nome) {
        return tabelaProcedimentosDao.listarPorNome(nome);
    } 

    //GETS e SETS
    public Procedimento getProcedimento1() {
        return procedimento1;
    }

    public void setProcedimento1(Procedimento procedimento1) {
        this.procedimento1 = procedimento1;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public List<String> getClassificacoes() {
        return classificacoes;
    }

    public void setClassificacoes(List<String> classificacoes) {
        this.classificacoes = classificacoes;
    }

    public float getTotalProc() {
        return totalProc;
    }

    public void setTotalProc(float totalProc) {
        this.totalProc = totalProc;
    }

    public float getTotalFilme() {
        return totalFilme;
    }

    public void setTotalFilme(float totalFilme) {
        this.totalFilme = totalFilme;
    }

    public float getValFilme() {
        return valFilme;
    }

    public void setValFilme(float valFilme) {
        this.valFilme = valFilme;
    }

    public float getValCh() {
        return valCh;
    }

    public void setValCh(float valCh) {
        this.valCh = valCh;
    }

    public float getUco() {
        return uco;
    }

    public void setUco(float uco) {
        this.uco = uco;
    }

    public TabelaProcedimentos getTabelaProcedimentos() {
        return tabelaProcedimentos;
    }

    public void setTabelaProcedimentos(TabelaProcedimentos tabelaProcedimentos) {
        this.tabelaProcedimentos = tabelaProcedimentos;
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
