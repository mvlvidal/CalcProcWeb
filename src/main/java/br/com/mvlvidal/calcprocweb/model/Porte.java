package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
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

@Entity
@Table(name="porte")
public class Porte implements Serializable {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nome")
    private String nome;
    
    @JoinColumn(name = "idTabela")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)       
    private Tabela tabela;

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

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }
    
    
}
