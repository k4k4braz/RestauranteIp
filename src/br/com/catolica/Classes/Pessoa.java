package br.com.catolica.Classes;

public abstract class Pessoa {
    protected String nome;

    public Pessoa(String nome) {
        this.nome = nome;
    }

    public abstract void mostrarInfo();
}

