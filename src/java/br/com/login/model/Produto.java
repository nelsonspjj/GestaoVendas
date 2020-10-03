package br.com.login.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

//Anotação que informa que a classe mapeada é persistente
@Entity
//Informando nome e esquema da tabela mapeada
@Table(name = "PRODUTO")
public class Produto implements Serializable {
    
    //Definição da chave primária
    @Id
    
    //Definição do mecanismo de definição da chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    
    //Informa o nome da coluna mapeada para o atributo
    @Column(name = "produtoid")
    private Long id;
    
    @Column(name = "nome")
    private String nome;
    
    @Column(name = "preco")
    private double preco;
    
    @Column(name = "observacao")
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
