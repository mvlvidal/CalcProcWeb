package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="tabela")
public class Tabela implements Serializable {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="nome")
    private String nome;

    @OneToMany(mappedBy = "tabela", targetEntity = Porte.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Porte> portes;
    
    @OneToMany(mappedBy = "tabela",targetEntity = Procedimento.class, cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Procedimento> procedimentos;
    
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

    public List<Porte> getPortes() {
        return portes;
    }

    public void setPortes(List<Porte> portes) {
        this.portes = portes;
    }
    
    @Override
    public String toString(){
        return this.nome;
    }
    
}
