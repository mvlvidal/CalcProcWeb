package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import br.com.mvlvidal.calcprocweb.model.Tabela;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ViewScoped
@ManagedBean(name = "proBean")
public class ProcedimentoBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Procedimento proc1;
    private ProcedimentoDao procDao;
    private List<Procedimento> procedimentos;  
    private List<String> classificacoes;
    private Tabela tabela;
    private boolean editar;

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
        procedimentos = procDao.listar();
        classificacoes = new ArrayList<>();
        classificacoes = carregaClassif();
        tabela = new Tabela();
        this.editar = false;

        //VALORES PADRÃO
        proc1.setAux(0);
        proc1.setCo(0.0f);
        proc1.setQtdFilme(0.0f);
        proc1.setpAnestesico(0);
        proc1.setCh(0.0f);
    }

    //MÉTODOS
    public String salvar() {
        
        proc1.setTabela(tabela);
        Procedimento proc2 = procDao.salvar(proc1);

        if (proc2 != null) {          
            proc1 = proc2; 
            this.editar = false;
            procedimentos = procDao.listar(proc1.getTabela().getId());
            return "cad-procedimento";
        }
        return "";
    }
    
    public String editar(Long id){
        if(id != 0 || id != null){
            this.editar = true;
            proc1 = procDao.find(id);
            tabela = proc1.getTabela();
            return "cad-procedimento";
        }
        return "";
    }
    
    public String excluir(Long id){
        if(id != null || id != 0){
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
       
        Tabela tab2 = tabela;
        
        if(tab2.getId() == 0){            
            procedimentos = procDao.listar();
        }else{
            procedimentos = procDao.listar(tabela.getId());
            //TODO Mensagem tabela sem procedimentos cadastrados
        }
        
        return "cad-procedimento";
    }
    
    public void calcularProcedimento(){
    
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

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }

    public boolean isEditar() {
        return editar;
    }

}
