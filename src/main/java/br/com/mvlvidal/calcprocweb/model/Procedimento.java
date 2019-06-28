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
@Table(name="procedimento")
public class Procedimento implements Serializable {
  
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name="codigo")
    private Long codigo;
    
    @Column(name="descricao")
    private String descricao;
    
    @Column(name="ch")
    private float ch;
    
    @Column(name="co")
    private float co;
    
    @Column(name="aux")
    private int aux;
    
    @Column(name="porteAnest")
    private int pAnestesico;
    
    @Column(name="porteMedic", length = 3)
    private String pMedico;
    
    @Column(name="qtdFilme")
    private float qtdFilme;
    
    @JoinColumn(name = "idTabela")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)        
    private Tabela tabela;

    
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public int getpAnestesico() {
        return pAnestesico;
    }

    public void setpAnestesico(int pAnestesico) {
        this.pAnestesico = pAnestesico;
    }

    public String getpMedico() {
        return pMedico;
    }

    public void setpMedico(String pMedico) {
        this.pMedico = pMedico;
    }

    public float getQtdFilme() {
        return qtdFilme;
    }

    public void setQtdFilme(float qtdFilme) {
        this.qtdFilme = qtdFilme;
    }

    public Tabela getTabela() {
        return tabela;
    }

    public void setTabela(Tabela tabela) {
        this.tabela = tabela;
    }
    
    
}
