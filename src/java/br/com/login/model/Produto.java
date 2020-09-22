package br.com.login.model;

public class Produto {
    
    private Long id;
    private String nome;
    private double preco;
    private String observacao;

    
    public Produto() {
       
    }
    
    public Produto(String nome, double preco, String observacao) {
        this.nome = nome;
        this.preco = preco;
        this.observacao = observacao;
    }
    
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

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
    
    
}
