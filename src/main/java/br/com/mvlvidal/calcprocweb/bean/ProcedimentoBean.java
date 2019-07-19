package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.event.AjaxBehaviorEvent;

@ViewScoped
@ManagedBean(name = "proBean")
public class ProcedimentoBean {

    private Procedimento proc1;
    private ProcedimentoDao procDao;
    private List<Procedimento> procedimentos;
    private List<String> classificacoes;

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
        //procedimentos = procDao.listar();
        classificacoes = new ArrayList<>();
        classificacoes = carregaClassif();

        //VALORES PADRÃO
        proc1.setAux(0);
        proc1.setCo(0.0f);
        proc1.setQtdFilme(0.0f);
        proc1.setpAnestesico(0);
        proc1.setCh(0.0f);
    }

    //MÉTODOS
    public void salvar() {

        Procedimento proc2 = proc1;

        if (proc2 != null) {
            procDao.salvar(proc1);
        }

    }

    public void calcularAMB() {

        totalProc = proc1.getCh() * valCh;
        totalFilme = proc1.getQtdFilme() * valFilme;

        totalProc += totalFilme;

    }

    public List<String> carregaClassif() {

        List<String> lista = new ArrayList<>();

        lista.add("HM");
        lista.add("SADT");

        return lista;
    }
    
    public void carregaProcsTabela(){
       
        procedimentos = procDao.listar(proc1.getTabela().getId());
           
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

}
