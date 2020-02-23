/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.bean;

import br.com.mvlvidal.calcprocweb.dao.ConvenioDao;
import br.com.mvlvidal.calcprocweb.dao.PorteDao;
import br.com.mvlvidal.calcprocweb.dao.ProcedimentoDao;
import br.com.mvlvidal.calcprocweb.model.Calculo;
import br.com.mvlvidal.calcprocweb.model.Convenio;
import br.com.mvlvidal.calcprocweb.model.Pesquisa;
import br.com.mvlvidal.calcprocweb.model.Porte;
import br.com.mvlvidal.calcprocweb.model.Procedimento;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author Marcus Vidal
 */
@ViewScoped
@ManagedBean(name = "calculoProcedimentosBean")
public class CalculoProcedimentosBean implements Serializable {

    private Pesquisa pesquisa;
    private Procedimento procedimento;
    private ProcedimentoDao procedimentoDao;
    private PorteDao porteDao;
    private Porte porte;
    private ConvenioDao convenioDao;
    private Convenio convenio;
    private Calculo calculo;

    private List<Procedimento> procedimentos;
    private List<Convenio> convenios;

    // ----------------------- CONSTRUTOR -------------------------------//
    @PostConstruct
    public void init() {

        pesquisa = new Pesquisa();
        procedimento = new Procedimento();
        procedimentoDao = new ProcedimentoDao();
        convenioDao = new ConvenioDao();
        convenio = new Convenio();
        calculo = new Calculo();
        porteDao = new PorteDao();
        porte = new Porte();
    }

    // ----------------------- MÉTODOS ------------------------------//
    public List<Convenio> carregaAutocompleteConvenio(String nome) {
        return convenioDao.listarPorNome(nome);
    }

    public void consultar() {
        
        if(pesquisa.getConvenio() != null && pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getDescricao().isEmpty()){
            procedimentos = procedimentoDao.listarPorCódigoDescricaoETabelas(pesquisa.getCodigo(), pesquisa.getDescricao(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
        }else{
            if(pesquisa.getConvenio() != null && pesquisa.getCodigo() != null){
                procedimentos = procedimentoDao.listarPorCódigoETabelas(pesquisa.getCodigo(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
            }else{
                if(pesquisa.getConvenio() != null && pesquisa.getDescricao() != null && !pesquisa.getDescricao().isEmpty()){
                    procedimentos = procedimentoDao.listarPorDescricaoETabelas(pesquisa.getDescricao(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
                }else{
                    if(pesquisa.getConvenio() != null){
                        procedimentos = procedimentoDao.listarPorTabelas(pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
                    }
                }
            }
        }
        
    }

    public void calcularProcedimento() {

        this.convenio = pesquisa.getConvenio();
        
        porte = porteDao.buscarPorTabelaENome(convenio.getTabelaPortesHm(), procedimento.getPorteMedico());
        
        calculo.setValorPorteMedico(porte.getPreco() * convenio.getUcoHm());
        
        //calculo.setValorPorteMedico(procedimento.g);
        
    }

    // ----------------------- GETS E SETS --------------------------//
    /**
     * @return the procedimento
     */
    public Procedimento getProcedimento() {
        return procedimento;
    }

    /**
     * @param procedimento the procedimento to set
     */
    public void setProcedimento(Procedimento procedimento) {
        this.procedimento = procedimento;
    }

    /**
     * @return the procedimentos
     */
    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    /**
     * @param procedimentos the procedimentos to set
     */
    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    /**
     * @return the convenios
     */
    public List<Convenio> getConvenios() {
        return convenios;
    }

    /**
     * @param convenios the convenios to set
     */
    public void setConvenios(List<Convenio> convenios) {
        this.convenios = convenios;
    }

    /**
     * @return the convenio
     */
    public Convenio getConvenio() {
        return convenio;
    }

    /**
     * @param convenio the convenio to set
     */
    public void setConvenio(Convenio convenio) {
        this.convenio = convenio;
    }

    public Pesquisa getPesquisa() {
        return pesquisa;
    }

    public void setPesquisa(Pesquisa pesquisa) {
        this.pesquisa = pesquisa;
    }

    /**
     * @return the calculo
     */
    public Calculo getCalculo() {
        return calculo;
    }

    /**
     * @param calculo the calculo to set
     */
    public void setCalculo(Calculo calculo) {
        this.calculo = calculo;
    }

    /**
     * @return the porte
     */
    public Porte getPorte() {
        return porte;
    }

    /**
     * @param porte the porte to set
     */
    public void setPorte(Porte porte) {
        this.porte = porte;
    }
    
    

}
