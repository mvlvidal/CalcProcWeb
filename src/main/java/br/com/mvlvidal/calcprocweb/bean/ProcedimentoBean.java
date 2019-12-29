package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
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
@ManagedBean(name = "proBean")
public class ProcedimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Procedimento proc1;
    private ProcedimentoDao procDao;
    private List<Procedimento> procedimentos;
    private List<String> classificacoes;
    private TabelaProcedimentos tabela;

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

        proc1 = new Procedimento();
        procDao = new ProcedimentoDao();
        procedimentos = new ArrayList<>();
        listar();
        classificacoes = new ArrayList<>();
        classificacoes = carregaClassif();
        tabela = new TabelaProcedimentos();
        
        //VALORES PADRÃO
        proc1.setAux(0);
        proc1.setCo(0.0f);
        proc1.setQtdFilme(0.0f);
        proc1.setpAnestesico(0);
        proc1.setCh(0.0f);
    }

    //MÉTODOS
    public void salvar() {
        
        Procedimento proc2 = procDao.salvar(proc1);

        if (proc2 != null) {
            proc1 = proc2;
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso!", "Procedimento salvo."));
            procedimentos = new ArrayList<>();
            listar();
        }else{
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro!", "Erro ao tentar salvar o procedimento."));
        }
    }

    public void editar() {
        
        HttpServletRequest request = (HttpServletRequest) FacesContext.getCurrentInstance().getExternalContext().getRequest();
        String id = request.getParameter("id");
        
        if(id != null){
            proc1 = procDao.find(Long.parseLong(id));
        }
    }

    public String excluir(Long id) {
        if (id != null || id != 0) {
            procDao.deletar(id);
            return "cad-procedimento";
        }
        return "";
    }

    public List<String> carregaClassif() {

        List<String> lista = new ArrayList<>();

        lista.add("HM");
        lista.add("SADT");

        return lista;
    }

    public String filtrarTabela() {

        procedimentos = new ArrayList<>();
        
        TabelaProcedimentos tab2 = tabela;

        if (tab2.getId() == 0) {
            listar();
        } else {
            procedimentos = procDao.listar(tabela.getId());
            //TODO Mensagem tabela sem procedimentos cadastrados
        }

        return "cad-procedimento";
    }
    
    public void listar(){
     
        procedimentos = procDao.listar();
        
    }

    public void calcularProcedimento() {

    }

    //GETS e SETS
    public Procedimento getProc1() {
        return proc1;
    }

    public void setProc1(Procedimento proc1) {
        this.proc1 = proc1;
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

    public TabelaProcedimentos getTabela() {
        return tabela;
    }

    public void setTabela(TabelaProcedimentos tabela) {
        this.tabela = tabela;
    }

}
