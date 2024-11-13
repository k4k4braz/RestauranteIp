package br.com.catolica.Classes;

import br.com.catolica.Interfaces.Pg;

import java.util.Scanner;

public class Pagamento implements Pg{
    public double valorFinal;

    public Pagamento(double valorFinal) {
        this.valorFinal = valorFinal;
    }

    @Override
    public void realizarPagamento(double valorFinal) {
        System.out.printf("\nRealizando o pagamento em dinheiro...\n");
        System.out.printf("Pagamento realizado com sucesso.\n");
    }
}