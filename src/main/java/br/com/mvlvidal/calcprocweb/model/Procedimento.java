package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
    
    @Column(name="tipoProc")
    @Enumerated(EnumType.STRING)
    private TipoProcedimento tipoProc;
    
    @Column(name="classificacao")
    @Enumerated(EnumType.STRING)
    private Classificacao classificacao;

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

    public TipoProcedimento getTipoProc() {
        return tipoProc;
    }

    public void setTipoProc(TipoProcedimento tipoProc) {
        this.tipoProc = tipoProc;
    }

    public Classificacao getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(Classificacao classificacao) {
        this.classificacao = classificacao;
    }
     
    
}
