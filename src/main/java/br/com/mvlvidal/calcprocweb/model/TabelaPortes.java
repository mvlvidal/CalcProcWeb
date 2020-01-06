/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.mvlvidal.calcprocweb.model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author mvlvidal
 */
@Entity
@Table(name = "tabelaPortes")
public class TabelaPortes extends AbstractModel {

    @Column(name = "nome")
    private String nome;
    
    @Column(name = "ativo")
    private boolean ativo;

    @OneToMany(mappedBy = "tabelaPortesHm", cascade = CascadeType.MERGE, targetEntity = Convenio.class, fetch = FetchType.LAZY)
    private List<Convenio> conveniosHm;

    @OneToMany(mappedBy = "tabelaPortesSadt", cascade = CascadeType.MERGE, targetEntity = Convenio.class, fetch = FetchType.LAZY)
    private List<Convenio> conveniosSadt;
    
    @OneToMany(mappedBy = "tabelaPortes", cascade = CascadeType.MERGE, targetEntity = Porte.class, fetch = FetchType.LAZY)
    private List<Porte> portes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }    
    
    public List<Convenio> getConveniosHm() {
        return conveniosHm;
    }

    public void setConveniosHm(List<Convenio> conveniosHm) {
        this.conveniosHm = conveniosHm;
    }

    public List<Convenio> getConveniosSadt() {
        return conveniosSadt;
    }

    public void setConveniosSadt(List<Convenio> conveniosSadt) {
        this.conveniosSadt = conveniosSadt;
    }

    public List<Porte> getPortes() {
        return portes;
    }

    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }

}
