package br.com.catolica.Classes;

import br.com.catolica.Enums.CategoriaPrato;
import br.com.catolica.Enums.TamanhoPorcao;

public class Prato extends Produto {
    private CategoriaPrato categoria;
    private TamanhoPorcao tamanhoPorcao;

    public Prato(String nome, double preco, CategoriaPrato categoria, TamanhoPorcao tamanhoPorcao) {
        super(nome, preco);
        this.categoria = categoria;
        this.tamanhoPorcao = tamanhoPorcao;
    }

    @Override
    public void exibirDetalhes() {
        System.out.println("Prato: " + nome + ", Preço: R$ " + preco + ", Categoria: " + categoria + ", Tamanho da porção: " + tamanhoPorcao);
    }

    @Override
    public void adicionarItem(Produto item) {
        super.adicionarItem(item);
    }
}