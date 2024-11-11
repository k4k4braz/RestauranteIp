package br.com.catolica.Interfaces;

import br.com.catolica.Classes.Produto;

public interface Pedido {
        void adicionarItem(Produto item);
        void exibirDetalhes();
}
