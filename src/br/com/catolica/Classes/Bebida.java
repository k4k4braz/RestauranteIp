package br.com.catolica.Classes;


import br.com.catolica.Enums.CategoriaBebida;

public class Bebida extends Produto {
    public CategoriaBebida categoria;

    public Bebida(String nome, double preco, CategoriaBebida categoria) {
        super(nome, preco);
        this.categoria = categoria;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Bebida: " + nome + ", Preço: " + preco + ", Categoria: " + categoria);
    }

    @Override
    public void adicionarItem(Produto item) {
        super.adicionarItem(item);
    }
}