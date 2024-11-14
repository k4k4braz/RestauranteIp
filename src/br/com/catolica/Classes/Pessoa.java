package br.com.catolica.Classes;

public class Pessoa {
    public String nome;
    public String atendente;

    public Pessoa(String nome, String atendente) {
        this.nome = nome;
        this.atendente = atendente;
    }

    public void apresentar() {
        System.out.println("Ola, sou " + nome + ", estou aqui para fazer o seu pedido.");
    }

    public void anotarPedido(String pedido, int quantidade) {
        System.out.println("Anotando pedido: " + pedido + " - Quantidade: " + quantidade);
    }
}