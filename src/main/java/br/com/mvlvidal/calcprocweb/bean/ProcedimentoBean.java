package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

@ViewScoped
@ManagedBean(name = "proBean")
public class ProcedimentoBean {

    private Procedimento proc1;
    private ProcedimentoDao procDao;
    private List<Procedimento> procedimentos;
    private List<Procedimento> procedimentosAmb;
    private List<Procedimento> procedimentosCbhpm;

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
        procedimentosAmb = new ArrayList<>();
        procedimentosCbhpm = new ArrayList<>();
        procedimentos = procDao.listar();
        procedimentosAmb = procDao.listarAmb();
        procedimentosCbhpm = procDao.listarCbhpm();
    }

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

    public List<String> carregaTipos() {

        List<String> lista = new ArrayList<>();

        lista.add("AMB");
        lista.add("CBHPM");

        return lista;
    }
    
    public List<String> carregaClassif(){
        
       List<String> lista = new ArrayList<>();
       
       lista.add("HM");
       lista.add("SADT");
       
       return lista;
    }

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

    public List<Procedimento> getProcedimentosAmb() {
        return procedimentosAmb;
    }

    public void setProcedimentosAmb(List<Procedimento> procedimentosAmb) {
        this.procedimentosAmb = procedimentosAmb;
    }

    public List<Procedimento> getProcedimentosCbhpm() {
        return procedimentosCbhpm;
    }

    public void setProcedimentosCbhpm(List<Procedimento> procedimentosCbhpm) {
        this.procedimentosCbhpm = procedimentosCbhpm;
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
