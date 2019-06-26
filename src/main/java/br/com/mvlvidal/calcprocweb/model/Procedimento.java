package br.com.mvlvidal.calcprocweb.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="procedimento")
public class Procedimento implements Serializable {
  
    Long id;
    
    Long codigo;
    
    String descricao;
    
    float ch;
    
    float co;
    
    int aux;
    
    int pAnestesic;
    
    Tabela tabela;
    
}
