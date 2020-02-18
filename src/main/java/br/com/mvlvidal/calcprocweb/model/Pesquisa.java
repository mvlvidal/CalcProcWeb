package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;

public class Pesquisa implements Serializable{

    private Long id;
    private String nome;
    private String descricao;
    private TabelaPortes tabelaPortes;
    private String tipo;
    private TabelaProcedimentos tabelaProcedimentos;

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

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the tabelaProcedimentos
     */
    public TabelaProcedimentos getTabelaProcedimentos() {
        return tabelaProcedimentos;
    }

    /**
     * @param tabelaProcedimentos the tabelaProcedimentos to set
     */
    public void setTabelaProcedimentos(TabelaProcedimentos tabelaProcedimentos) {
        this.tabelaProcedimentos = tabelaProcedimentos;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    
    
}
