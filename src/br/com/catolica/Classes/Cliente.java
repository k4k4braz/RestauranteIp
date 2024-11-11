package br.com.catolica.Classes;

import java.util.ArrayList;

public class Cliente {
    private String nome;
    private ArrayList<Produto> pedidos;

    public Cliente(String nome) {
        this.nome = nome;
        this.pedidos = new ArrayList<>();
    }
}
