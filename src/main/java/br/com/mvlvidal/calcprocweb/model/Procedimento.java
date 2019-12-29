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
    
    @Column(name="percentPorte")
    private float percentPorte;
    
    @Column(name="porteMedic", length = 3)
    private String pMedico;
    
    @Column(name="qtdFilme")
    private float qtdFilme;
 
    @Column(name="classificacao")
    private String classificacao;

    @JoinColumn(name = "idTabela")
    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.EAGER)
    private TabelaProcedimentos tabela;

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

    public float getPercentPorte() {
        return percentPorte;
    }

    public void setPercentPorte(float percentPorte) {
        this.percentPorte = percentPorte;
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

    public String getClassificacao() {
        return classificacao;
    }

    public void setClassificacao(String classificacao) {
        this.classificacao = classificacao;
    }

    public TabelaProcedimentos getTabela() {
        return tabela;
    }

    public void setTabela(TabelaProcedimentos tabela) {
        this.tabela = tabela;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.id);
        hash = 37 * hash + Objects.hashCode(this.codigo);
        hash = 37 * hash + Objects.hashCode(this.descricao);
        hash = 37 * hash + Float.floatToIntBits(this.ch);
        hash = 37 * hash + Float.floatToIntBits(this.co);
        hash = 37 * hash + this.aux;
        hash = 37 * hash + this.pAnestesico;
        hash = 37 * hash + Float.floatToIntBits(this.percentPorte);
        hash = 37 * hash + Objects.hashCode(this.pMedico);
        hash = 37 * hash + Float.floatToIntBits(this.qtdFilme);
        hash = 37 * hash + Objects.hashCode(this.classificacao);
        hash = 37 * hash + Objects.hashCode(this.tabela);
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
        final Procedimento other = (Procedimento) obj;
        if (Float.floatToIntBits(this.ch) != Float.floatToIntBits(other.ch)) {
            return false;
        }
        if (Float.floatToIntBits(this.co) != Float.floatToIntBits(other.co)) {
            return false;
        }
        if (this.aux != other.aux) {
            return false;
        }
        if (this.pAnestesico != other.pAnestesico) {
            return false;
        }
        if (Float.floatToIntBits(this.percentPorte) != Float.floatToIntBits(other.percentPorte)) {
            return false;
        }
        if (Float.floatToIntBits(this.qtdFilme) != Float.floatToIntBits(other.qtdFilme)) {
            return false;
        }
        if (!Objects.equals(this.descricao, other.descricao)) {
            return false;
        }
        if (!Objects.equals(this.pMedico, other.pMedico)) {
            return false;
        }
        if (!Objects.equals(this.classificacao, other.classificacao)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        if (!Objects.equals(this.codigo, other.codigo)) {
            return false;
        }
        if (!Objects.equals(this.tabela, other.tabela)) {
            return false;
        }
        return true;
    }
    
    
}
