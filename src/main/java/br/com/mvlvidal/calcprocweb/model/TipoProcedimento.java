package br.com.mvlvidal.calcprocweb.model;

public enum TipoProcedimento {
    AMB("AMB"),
    CBHPM("CBHPM");

    private String nome;

    private TipoProcedimento(String nome){
        this.nome = nome;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
