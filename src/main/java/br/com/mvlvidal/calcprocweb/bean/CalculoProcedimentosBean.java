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
 * @author Marcus Vidal
 */
@ViewScoped
@ManagedBean(name = "calculoProcedimentosBean")
public class CalculoProcedimentosBean {

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

        zerarValores();
    }

    // ----------------------- MÉTODOS ------------------------------//
    public List<Convenio> carregaAutocompleteConvenio(String nome) {
        return convenioDao.listarPorNome(nome);
    }

    public void consultar() {

        if (pesquisa.getConvenio() != null && pesquisa.getCodigo() != null && pesquisa.getDescricao() != null && !pesquisa.getDescricao().isEmpty()) {
            procedimentos = procedimentoDao.listarPorCódigoDescricaoETabelas(pesquisa.getCodigo(), pesquisa.getDescricao(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
        } else {
            if (pesquisa.getConvenio() != null && pesquisa.getCodigo() != null) {
                procedimentos = procedimentoDao.listarPorCódigoETabelas(pesquisa.getCodigo(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
            } else {
                if (pesquisa.getConvenio() != null && pesquisa.getDescricao() != null && !pesquisa.getDescricao().isEmpty()) {
                    procedimentos = procedimentoDao.listarPorDescricaoETabelas(pesquisa.getDescricao(), pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
                } else {
                    if (pesquisa.getConvenio() != null) {
                        procedimentos = procedimentoDao.listarPorTabelas(pesquisa.getConvenio().getTabHm(), pesquisa.getConvenio().getTabSadt());
                    }
                }
            }
        }

    }

    public void calcularProcedimento(Procedimento p) {

        this.procedimento = p;

        this.convenio = pesquisa.getConvenio();

        TabelaProcedimentos tabProc = procedimento.getTabela();

        if (tabProc.getTipoTab().equals("CBHPM")) {
            calculoCbhpm();
        } else {
            calculoAmb();
        }

        List<Float> valoresAuxilio = calculo.getValoresAuxilio();
        
        for (Float v : valoresAuxilio) {
            calculo.setSubtotal(calculo.getSubtotal() + v);
        }
        
        calculo.setTotal(
                calculo.getValorCh() + 
                calculo.getValorCo() + 
                calculo.getValorFilme() + 
                calculo.getValorPorteAnestesico() + 
                calculo.getValorPorteMedico() + 
                calculo.getSubtotal());
    }

    public void calculoAmb() {

        System.out.println("AMB");

    }

    public void calculoCbhpm() {

        if (procedimento.getClassificacao().equals("HM")) {

            porte = porteDao.buscarPorTabelaENome(convenio.getTabelaPortesHm().getId(), procedimento.getPorteMedico());

            if (this.porte != null) {
                calculo.setValorPorteMedico((porte.getPreco() * procedimento.getPercentPorte()) * convenio.getPercPorteHm());
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "O Porte Médico do procedimento selecionado, não foi encontrado na tabela de portes."));
            }

            calculo.setValorCo(procedimento.getCo() * convenio.getUcoHm());

            calculo.setSubtotal(calculo.getValorCo() + calculo.getValorPorteMedico());

            calcularAuxilio();
            
            if(procedimento.getPorteAnestesico() > 0){
                calcularPorteAnestesico();
            }
            

        } else {
            if (procedimento.getClassificacao().equals("SADT")) {

                porte = porteDao.buscarPorTabelaENome(convenio.getTabelaPortesSadt().getId(), procedimento.getPorteMedico());

                if (porte != null) {
                    calculo.setValorPorteMedico((porte.getPreco() * procedimento.getPercentPorte()) * convenio.getPercPorteSadt());
                    calculo.setValorCo(procedimento.getCo() * convenio.getUcoSadt());
                } else {
                    FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Atenção!", "O Porte Médico do procedimento selecionado, não foi encontrado na tabela de portes."));
                }
                
                if(procedimento.getPorteAnestesico() > 0){
                    calcularPorteAnestesico();
                }
                
                calculo.setValorFilme(procedimento.getQtdFilme() * convenio.getValorFilme());

            }
        }

    }

    public void calcularAuxilio() {

        Integer aux = 0;

        if (calculo.getQtdAuxilio() > 0) {
            aux = calculo.getQtdAuxilio();
        } else {
            if (procedimento.getAux() > 0) {
                aux = procedimento.getAux();
            }
        }

        List<Float> valores = new ArrayList<>();

        for (int i = 1; i < aux + 1; i++) {
            if (i == 1) {
                valores.add(calculo.getValorPorteMedico() * 0.3f);
            } else {
                valores.add(calculo.getValorPorteMedico() * 0.2f);
            }
        }

        calculo.setValoresAuxilio(valores);

        calculo.setQtdAuxilio(0);

    }

    public void calcularPorteAnestesico() {

        Integer[] portesAnestesicosAmb = {0, 175, 250, 370, 500, 750, 1100, 1600, 1750}; //Valores em CH's
        String[] portesAnestesicosCbhpm = {"", "3A", "3C", "4C", "6B", "7C", "9B", "10C", "12A"};

        Integer portesAnestesicoAmb = 0;
        String portesAnestesicoCbhpm = "";
        
        TabelaProcedimentos tabela = procedimento.getTabela();

        if (tabela.getTipoTab().equals("AMB")) {

            portesAnestesicoAmb = portesAnestesicosAmb[procedimento.getPorteAnestesico()];

            if (procedimento.getClassificacao().equals("HM")) {

                calculo.setValorPorteAnestesico(convenio.getValorChHm() * portesAnestesicoAmb);

            } else {
                if (procedimento.getClassificacao().equals("SADT")) {

                    calculo.setValorPorteAnestesico(convenio.getValorChSadt() * portesAnestesicoAmb);

                }
            }

        } else {

            if (tabela.getTipoTab().equals("CBHPM")) {

                portesAnestesicoCbhpm = portesAnestesicosCbhpm[procedimento.getPorteAnestesico()];

                if (procedimento.getClassificacao().equals("HM")) {

                    porte = porteDao.buscarPorTabelaENome(convenio.getTabelaPortesHm().getId(), portesAnestesicoCbhpm);
                    
                    calculo.setValorPorteAnestesico(porte.getPreco() * convenio.getPercPorteHm());

                } else {

                    if (procedimento.getClassificacao().equals("SADT")) {

                        porte = porteDao.buscarPorTabelaENome(convenio.getTabelaPortesSadt().getId(), portesAnestesicoCbhpm);

                        calculo.setValorPorteAnestesico(porte.getPreco() * convenio.getPercPorteHm());

                    }

                }

            }

        }

    }

    public boolean validarPorteAnestesico() {
        return procedimento.getPorteAnestesico() < 6;
    }

    public void resetarVisualizacao() {

        this.procedimento = new Procedimento();
        this.convenio = new Convenio();

        zerarValores();
    }

    public void zerarValores() {

        calculo.setSubtotal(0.0f);
        calculo.setValoresAuxilio(new ArrayList<Float>());
        calculo.setTotal(0.0f);
        calculo.setValorCh(0.0f);
        calculo.setValorCo(0.0f);
        calculo.setValorFilme(0.0f);
        calculo.setValorPorteMedico(0.0f);
        calculo.setQtdAuxilio(0);
        calculo.setValorPorteAnestesico(0.0f);
        calculo.setSubtotal(0.0f);

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
