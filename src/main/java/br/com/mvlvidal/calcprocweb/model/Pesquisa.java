package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;

public class Pesquisa implements Serializable{

    private Long id;
    private String nome;
    private TabelaPortes tabelaPortes;

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

    public TabelaPortes getTabelaPortes() {
        return tabelaPortes;
    }

    public void setTabelaPortes(TabelaPortes tabelaPortes) {
        this.tabelaPortes = tabelaPortes;
    }
    
    
    
}
