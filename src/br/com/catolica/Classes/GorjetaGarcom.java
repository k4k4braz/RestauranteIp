package br.com.catolica.Classes;

import br.com.catolica.Interfaces.Gorjeta;

public class GorjetaGarcom implements Gorjeta {
    private double porcentagem;

    public GorjetaGarcom(double porcentagem) {
        this.porcentagem = porcentagem;
    }

    @Override
    public double calcularGorjeta(double valorPedido) {
        return valorPedido * (porcentagem / 100);
    }
}
