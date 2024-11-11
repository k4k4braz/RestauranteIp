package br.com.catolica.Classes;

import br.com.catolica.Interfaces.Pedido;

public abstract class Produto implements Pedido {
    protected String nome;
    protected double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    @Override
    public void adicionarItem(Produto item) {
        System.out.println("Adicionando item: " + item.getNome());
    }
}