package br.com.catolica.Main;

import br.com.catolica.Classes.*;
import br.com.catolica.Enums.CategoriaBebida;
import br.com.catolica.Enums.CategoriaPrato;
import br.com.catolica.Enums.TamanhoPorcao;
import java.util.Scanner;

public class Restaurante {
    private static Produto[] itens;
    private static Scanner scanner = new Scanner(System.in);
    private static Pessoa pessoa = new Pessoa("Kaue", "Atendente");
    public static void main(String[] args) {

        inicializarMenu();

        boolean sair = false;
        while (!sair) {
            System.out.println("\n- RestauranteIp -");
            System.out.println("1. Exibir Cardapio");
            System.out.println("2. Realizar Pedido");
            System.out.println("3. Sair");

            int opcao = 0;
            boolean opcaoValida = false;
            while (!opcaoValida) {
                System.out.print("Escolha uma opcao: ");
                if (scanner.hasNextInt()) {
                    opcao = scanner.nextInt();
                    if (opcao >= 1 && opcao <= 3) {
                        opcaoValida = true;
                    } else {
                        System.out.println("Opcao invalida, tente novamente!");
                    }
                } else {
                    System.out.println("Opcao invalida, por favor digite numeros.");
                    scanner.nextLine();
                }
            }
            if (opcao == 1) {
                exibirMenu();
            } else if (opcao == 2) {
                pessoa.apresentar();
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
        itens = new Produto[]{
                new Prato("Baguetes", 5.00, CategoriaPrato.Entrada, TamanhoPorcao.Pequeno),
                new Prato("Lasanha", 22.00, CategoriaPrato.Principal, TamanhoPorcao.Grande),
                new Prato("Petit Gateau", 35.00, CategoriaPrato.Sobremesa, TamanhoPorcao.Pequeno),
                new Bebida("Maracuja", 5.00, CategoriaBebida.Suco),
                new Bebida("Coca-Cola", 12.00, CategoriaBebida.Refri),
                new Bebida("Skol", 7.00, CategoriaBebida.Alcoolica)
        };
    }

    private static void exibirMenu() {
        System.out.println("\n- Cardapio do Restaurante -");
        for (int i = 0; i < itens.length; i++) {
            System.out.print((i + 1) + ". ");
            itens[i].exibirDetalhes();
        }
    }

    private static void realizarPedido() {
        scanner.nextLine();
        System.out.print("Digite seu nome para iniciar o pedido: ");
        String nomeCliente = scanner.nextLine();

        boolean continuar = true;
        String[] pedidos = new String[itens.length];
        int pedidoIndex = 0;
        double valorTotal = 0.0;

        int index = -1;
        while (continuar) {
            System.out.println("\nRealizando pedido...");
            exibirMenu();

            boolean escolhaValida = false;
            while (!escolhaValida) {
                System.out.print("Digite o numero do item que deseja pedir: ");

                if (scanner.hasNextInt()) {
                    index = scanner.nextInt();
                    scanner.nextLine();

                    if (index >= 1 && index <= itens.length) {
                        escolhaValida = true;
                    } else {
                        System.out.println("Numero invalido, por favor, escolha um numero do menu.");
                    }
                } else {
                    System.out.println("Entrada invalida, por favor, insira um numero.");
                    scanner.nextLine();
                }
            }

            Produto itemEscolhido = itens[index - 1];

            boolean entradaValida = false;
            int quantidade = 0;

            while (!entradaValida) {
                System.out.print("Quantas unidades voce deseja pedir de " + itemEscolhido.getNome() + "? ");

                if (scanner.hasNextInt()) {
                    quantidade = scanner.nextInt();
                    scanner.nextLine();

                    if (quantidade > 0) {
                        entradaValida = true;
                    } else {
                        System.out.println("Por favor, digite uma quantidade positiva.");
                    }
                } else {
                    System.out.println("Entrada invalida, por favor, digite um numero.");
                    scanner.nextLine();
                }
            }

            double valorPedido = itemEscolhido.getPreco() * quantidade;
            valorTotal += valorPedido;

            pedidos[pedidoIndex++] = itemEscolhido.getNome() + " (Quantidade: " + quantidade + ") - Preco: R$ " + valorPedido;
            pessoa.anotarPedido(itemEscolhido.getNome(), quantidade);

            boolean respostaValida = false;
            while (!respostaValida) {
                System.out.print("Deseja continuar fazendo o pedido: (S/N): ");
                String resposta = scanner.nextLine();

                if (resposta.equalsIgnoreCase("S")) {
                    System.out.println("Continuando o pedido...");
                    respostaValida = true;
                } else if (resposta.equalsIgnoreCase("N")) {
                    continuar = false;
                    respostaValida = true;
                    System.out.println("Pedido encerrado.");
                } else {
                    System.out.println("Entrada invalida, por favor, digite apenas 'S' ou 'N'.");
                }
            }
        }

        System.out.println("\n--- Resumo do Pedido de " + nomeCliente + " ");
        for (String pedido : pedidos) {
            if (pedido != null) {
                System.out.println(pedido);
            }
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
            System.out.print("Opcao: ");

            String entrada = scanner.nextLine();

            if (entrada.equals("1")) {
                porcentagem = 10;
            } else if (entrada.equals("2")) {
                porcentagem = 15;
            } else if (entrada.equals("3")) {
                porcentagem = 20;
            } else {
                System.out.println("Entrada invalida, tente novamente.");
            }
        }

        System.out.println("Porcentagem de gorjeta escolhida: " + porcentagem + "%");

        GorjetaGarcom gorjetaGarcom = new GorjetaGarcom(porcentagem);
        double gorjeta = gorjetaGarcom.calcularGorjeta(valorTotal);

        System.out.printf("Gorjeta para o garcom: R$ %.2f\n", gorjeta);
        double valorFinal = valorTotal + gorjeta;
        System.out.printf("Valor Total com Gorjeta: R$ %.2f\n", valorFinal);
        Pagamento pagamento = new Pagamento(valorFinal);
        pagamento.realizarPagamento(valorFinal);
    }
}