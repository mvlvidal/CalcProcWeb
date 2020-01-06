/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.model;

import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mvlvidal
 */
@Entity
@Table(name = "convenio")
public class Convenio extends AbstractModel{

    @Column(name = "nome")
    private String nome;

    @Column(name = "ucoSadt")
    private Float ucoSadt;

    @Column(name = "ucoHm")
    private Float ucoHm;

    @Column(name = "valorChHm")
    private Float valorChHm;

    @Column(name = "valorChSadt")
    private Float valorChSadt;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTabelaHm")
    private TabelaProcedimentos tabHm;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTabelaSadt")
    private TabelaProcedimentos tabSadt;

    @Column(name = "percPorteHm")
    private Float percPorteHm;

    @Column(name = "percPorteSadt")
    private Float percPorteSadt;

    @Column(name = "valorFilme")
    private Float valorFilme;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTabelaPortesHm")
    private TabelaPortes tabelaPortesHm;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "idTabelaPortesSadt")
    private TabelaPortes tabelaPortesSadt;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Float getUcoSadt() {
        return ucoSadt;
    }

    public void setUcoSadt(Float ucoSadt) {
        this.ucoSadt = ucoSadt;
    }

    public Float getUcoHm() {
        return ucoHm;
    }

    public void setUcoHm(Float ucoHm) {
        this.ucoHm = ucoHm;
    }

    public Float getValorChHm() {
        return valorChHm;
    }

    public void setValorChHm(Float valorChHm) {
        this.valorChHm = valorChHm;
    }

    public Float getValorChSadt() {
        return valorChSadt;
    }

    public void setValorChSadt(Float valorChSadt) {
        this.valorChSadt = valorChSadt;
    }

    public TabelaProcedimentos getTabHm() {
        return tabHm;
    }

    public void setTabHm(TabelaProcedimentos tabHm) {
        this.tabHm = tabHm;
    }

    public TabelaProcedimentos getTabSadt() {
        return tabSadt;
    }

    public void setTabSadt(TabelaProcedimentos tabSadt) {
        this.tabSadt = tabSadt;
    }

    public Float getPercPorteHm() {
        return percPorteHm;
    }

    public void setPercPorteHm(Float percPorteHm) {
        this.percPorteHm = percPorteHm;
    }

    public Float getPercPorteSadt() {
        return percPorteSadt;
    }

    public void setPercPorteSadt(Float percPorteSadt) {
        this.percPorteSadt = percPorteSadt;
    }

    public Float getValorFilme() {
        return valorFilme;
    }

    public void setValorFilme(Float valorFilme) {
        this.valorFilme = valorFilme;
    }

    public TabelaPortes getTabelaPortesHm() {
        return tabelaPortesHm;
    }

    public void setTabelaPortesHm(TabelaPortes tabelaPortesHm) {
        this.tabelaPortesHm = tabelaPortesHm;
    }

    public TabelaPortes getTabelaPortesSadt() {
        return tabelaPortesSadt;
    }

    public void setTabelaPortesSadt(TabelaPortes tabelaPortesSadt) {
        this.tabelaPortesSadt = tabelaPortesSadt;
    }
}
