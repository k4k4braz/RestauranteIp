package br.com.catolica.Classes;

import br.com.catolica.Interfaces.Pg;

public class Pagamento implements Pg {
        @Override
        public void realizarPagamento(double valorTotal) {
            System.out.printf("Pagamento em dinheiro realizado. Total: R$ %.2f\n", valorTotal);
        }
}
