package br.com.catolica.Main;

import br.com.catolica.Classes.*;
import br.com.catolica.Enums.CategoriaBebida;
import br.com.catolica.Enums.CategoriaPrato;
import br.com.catolica.Enums.TamanhoPorcao;

import java.util.ArrayList;
import java.util.Scanner;

public class Restaurante {
    private static ArrayList<Produto> itens = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        inicializarMenu();

        boolean sair = false;
        while (!sair) {
            System.out.println("\n- RestauranteIp -");
            System.out.println("1. Exibir Cardapio");
            System.out.println("2. Realizar Pedido");
            System.out.println("3. Sair");
            System.out.print("Escolha uma opcao: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            if (opcao == 1) {
                exibirMenu();
            } else if (opcao == 2) {
                realizarPedido();
            } else if (opcao == 3) {
                sair = true;
                System.out.println("Saindo do sistema...");
            } else {
                System.out.println("Opcao invalida, tente novamente.");
            }
        }
    }

    private static void inicializarMenu() {
        itens.add(new Prato("Salada", 12.50, CategoriaPrato.Entrada, TamanhoPorcao.Pequeno));
        itens.add(new Prato("Lasanha", 22.00, CategoriaPrato.Principal, TamanhoPorcao.Grande));
        itens.add(new Prato("Torta de Chocolate", 35.00, CategoriaPrato.Sobremesa, TamanhoPorcao.Pequeno));
        itens.add(new Bebida("Suco de Maracuja", 5.00, CategoriaBebida.Suco));
        itens.add(new Bebida("Refrigerante", 12.00, CategoriaBebida.Refri));
        itens.add(new Bebida("Cerveja", 7.00, CategoriaBebida.Alcoolica));
    }

    private static void exibirMenu() {
        System.out.println("\n- Cardapio do Restaurante -");
        for (int i = 0; i < itens.size(); i++) {
            System.out.print((i + 1) + ". ");
            itens.get(i).exibirDetalhes();
        }
    }

    private static void realizarPedido() {
        System.out.print("Digite seu nome para iniciar o pedido: ");
        String nomeCliente = scanner.nextLine();

        boolean continuar = true;
        ArrayList<String> pedidos = new ArrayList<>();
        double valorTotal = 0.0;

        while (continuar) {
            System.out.println("\nRealizando pedido...");
            exibirMenu();
            System.out.print("Digite o numero do item que deseja pedir: ");
            int index = scanner.nextInt() - 1;
            scanner.nextLine();

            if (index >= 0 && index < itens.size()) {
                Produto itemEscolhido = itens.get(index);

                System.out.print("Quantas unidades voce deseja pedir de " + itemEscolhido.getNome() + "? ");
                int quantidade = scanner.nextInt();
                scanner.nextLine();

                double valorPedido = itemEscolhido.getPreco() * quantidade;
                valorTotal += valorPedido;

                pedidos.add(itemEscolhido.getNome() + " (Quantidade: " + quantidade + ") - Preco: R$ " + valorPedido);
            } else {
                System.out.println("Item invalido.");
            }

            System.out.print("Deseja continuar fazendo o pedido? (S/N): ");
            String resposta = scanner.nextLine();
            if (resposta.equalsIgnoreCase("N")) {
                continuar = false;
            }
        }

        System.out.println("\n--- Resumo do Pedido de " + nomeCliente + " ");
        for (String pedido : pedidos) {
            System.out.println(pedido);
        }
        System.out.printf("Valor Total: R$ %.2f\n", valorTotal);
        escolherGorjeta(valorTotal);
    }

    private static void escolherGorjeta(double valorTotal) {
        double porcentagem = -1;

        while (porcentagem == -1) {
            System.out.println("\nEscolha a porcentagem de gorjeta para o garcom:");
            System.out.println("1. 10%");
            System.out.println("2. 15%");
            System.out.println("3. 20%");
            System.out.print("Opção: ");
            int opcaoGorjeta = scanner.nextInt();
            scanner.nextLine();

            if (opcaoGorjeta == 1) {
                porcentagem = 10;
            } else if (opcaoGorjeta == 2) {
                porcentagem = 15;
            } else if (opcaoGorjeta == 3) {
                porcentagem = 20;
            } else {
                System.out.println("Opcao invalida, tente novamente.");
            }
        }

        GorjetaGarcom gorjetaGarcom = new GorjetaGarcom(porcentagem);
        double gorjeta = gorjetaGarcom.calcularGorjeta(valorTotal);

        System.out.printf("Gorjeta para o garcom: R$ %.2f\n", gorjeta);
        double valorFinal = valorTotal + gorjeta;
        System.out.printf("Valor Total com Gorjeta: R$ %.2f\n", valorFinal);
    }
}