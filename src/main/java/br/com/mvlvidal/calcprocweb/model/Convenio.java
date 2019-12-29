/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author mvlvidal
 */

@Entity
@Table(name = "convenio")
public class Convenio implements Serializable{
    
    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
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
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 11 * hash + Objects.hashCode(this.id);
        hash = 11 * hash + Objects.hashCode(this.nome);
        hash = 11 * hash + Objects.hashCode(this.ucoSadt);
        hash = 11 * hash + Objects.hashCode(this.ucoHm);
        hash = 11 * hash + Objects.hashCode(this.valorChHm);
        hash = 11 * hash + Objects.hashCode(this.valorChSadt);
        hash = 11 * hash + Objects.hashCode(this.tabHm);
        hash = 11 * hash + Objects.hashCode(this.tabSadt);
        hash = 11 * hash + Objects.hashCode(this.percPorteHm);
        hash = 11 * hash + Objects.hashCode(this.percPorteSadt);
        hash = 11 * hash + Objects.hashCode(this.valorFilme);
        hash = 11 * hash + Objects.hashCode(this.tabelaPortesHm);
        hash = 11 * hash + Objects.hashCode(this.tabelaPortesSadt);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Convenio other = (Convenio) obj;
        if (!Objects.equals(this.nome, other.nome)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.ucoSadt, other.ucoSadt)) {
            return false;
        }
        if (!Objects.equals(this.ucoHm, other.ucoHm)) {
            return false;
        }
        if (!Objects.equals(this.valorChHm, other.valorChHm)) {
            return false;
        }
        if (!Objects.equals(this.valorChSadt, other.valorChSadt)) {
            return false;
        }
        if (!Objects.equals(this.tabHm, other.tabHm)) {
            return false;
        }
        if (!Objects.equals(this.tabSadt, other.tabSadt)) {
            return false;
        }
        if (!Objects.equals(this.percPorteHm, other.percPorteHm)) {
            return false;
        }
        if (!Objects.equals(this.percPorteSadt, other.percPorteSadt)) {
            return false;
        }
        if (!Objects.equals(this.valorFilme, other.valorFilme)) {
            return false;
        }
        if (!Objects.equals(this.tabelaPortesHm, other.tabelaPortesHm)) {
            return false;
        }
        if (!Objects.equals(this.tabelaPortesSadt, other.tabelaPortesSadt)) {
            return false;
        }
        return true;
    }
          
}
