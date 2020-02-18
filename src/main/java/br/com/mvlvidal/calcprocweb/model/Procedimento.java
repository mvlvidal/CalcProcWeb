package br.com.mvlvidal.calcprocweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "procedimento")
public class Procedimento extends AbstractModel {

    @Column(name = "codigo")
    private Long codigo;

    @Column(name = "descricao")
    private String descricao;

    @Column(name = "ch")
    private float ch;

    @Column(name = "co")
    private float co;

    @Column(name = "aux")
    private int aux;

    @Column(name = "porteAnest")
    private int porteAnestesico;

    @Column(name = "percentPorte")
    private float percentPorte;

    @Column(name = "porteMedic", length = 3)
    private String porteMedico;

    @Column(name = "qtdFilme")
    private float qtdFilme;

    @Column(name = "classificacao")
    private String classificacao;

    @JoinColumn(name = "idTabela")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private TabelaProcedimentos tabela;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getCh() {
        return ch;
    }

    public void setCh(float ch) {
        this.ch = ch;
    }

    public float getCo() {
        return co;
    }

    public void setCo(float co) {
        this.co = co;
    }

    public int getAux() {
        return aux;
    }

    public void setAux(int aux) {
        this.aux = aux;
    }

    public int getPorteAnestesico() {
        return porteAnestesico;
    }

    public void setPorteAnestesico(int porteAnestesico) {
        this.porteAnestesico = porteAnestesico;
    }

    public float getPercentPorte() {
        return percentPorte;
    }

    public void setPercentPorte(float percentPorte) {
        this.percentPorte = percentPorte;
    }

    public String getPorteMedico() {
        return porteMedico;
    }

    public void setPorteMedico(String porteMedico) {
        this.porteMedico = porteMedico;
    }

    public float getQtdFilme() {
        return qtdFilme;
    }

    public void setQtdFilme(float qtdFilme) {
        this.qtdFilme = qtdFilme;
    }

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public TabelaProcedimentos getTabela() {
        return tabela;
    }

    public void setTabela(TabelaProcedimentos tabela) {
        this.tabela = tabela;
    }

}
