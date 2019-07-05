package br.com.mvlvidal.calcprocweb.model;

public enum Classificacao {
    HM("HM"),
    SADT("SADT");
    
    private String nome;

    private Classificacao(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
        
}
