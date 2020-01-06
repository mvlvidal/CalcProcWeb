package br.com.mvlvidal.calcprocweb.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="porte")
public class Porte extends AbstractModel{

    @Column(name="nome")
    private String nome;
    
    @Column(name="preco")
    private float preco;
    
    @JoinColumn(name = "idTabelaPortes")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)       
    private TabelaPortes tabelaPortes;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public TabelaPortes getTabelaPortes() {
        return tabelaPortes;
    }

    public void setTabelaPortes(TabelaPortes tabelaPortes) {
        this.tabelaPortes = tabelaPortes;
    }
}
