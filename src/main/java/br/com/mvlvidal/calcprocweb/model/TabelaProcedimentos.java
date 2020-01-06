package br.com.mvlvidal.calcprocweb.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tabelaProcedimentos")
public class TabelaProcedimentos extends AbstractModel {

    @Column(name = "nome", length = 40)
    private String nome;

    @Column(name = "tipoTab")
    private String tipoTab;

    @OneToMany(mappedBy = "tabela", targetEntity = Procedimento.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Procedimento> procedimentos;
    
    @OneToMany(mappedBy = "tabHm", targetEntity = Convenio.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Convenio> conveniosTabHm;
    
    @OneToMany(mappedBy = "tabSadt", targetEntity = Convenio.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Convenio> conveniosTabSadt;
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTipoTab() {
        return tipoTab;
    }

    public void setTipoTab(String tipoTab) {
        this.tipoTab = tipoTab;
    }

    public List<Procedimento> getProcedimentos() {
        return procedimentos;
    }

    public void setProcedimentos(List<Procedimento> procedimentos) {
        this.procedimentos = procedimentos;
    }

    public List<Convenio> getConveniosTabHm() {
        return conveniosTabHm;
    }

    public void setConveniosTabHm(List<Convenio> conveniosTabHm) {
        this.conveniosTabHm = conveniosTabHm;
    }

    public List<Convenio> getConveniosTabSadt() {
        return conveniosTabSadt;
    }

    public void setConveniosTabSadt(List<Convenio> conveniosTabSadt) {
        this.conveniosTabSadt = conveniosTabSadt;
    }
    
    
}
