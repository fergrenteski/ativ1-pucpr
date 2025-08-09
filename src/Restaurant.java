import controllers.Menu;
import controllers.Options;
import entities.Order;
import entities.Product;

import java.util.Scanner;

public class Restaurant {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Menu menu = new Menu();
        Options options = new Options();

        // Criando cardápio
        menu.addAllProduct(
                new Product(1, "Spaghetti", 46.90),
                new Product(2, "Pizza", 79.90),
                new Product(3, "Alcatra", 60.90),
                new Product(4, "Picanha", 99.90),
                new Product(5, "Mignon ao molho", 75.00),
                new Product(6, "Salmão ao molho de Maracujá", 112.90)
        );

        while (true) {
            options.exibirOptions();
            int opcao = sc.nextInt();

            switch (opcao) {
                case 1: // Fazer pedido
                    sc.nextLine(); // limpar buffer
                    Order order = new Order();

                    System.out.print("Digite o seu nome: ");
                    String nomeCliente = sc.nextLine();
                    order.setUserName(nomeCliente);

                    menu.exibirMenu();

                    while (true) {
                        System.out.print("Digite o número do item (0 para finalizar): ");
                        int codigo = sc.nextInt();

                        if (codigo == 0) break;

                        Product produto = menu.getProductById(codigo);
                        if (produto != null) {
                            order.addProduct(produto);
                            System.out.println(produto.getName() + " adicionado ao pedido.");
                        } else {
                            System.out.println("Produto não encontrado.");
                        }

                        menu.exibirMenu();
                    }

                    // Exibe o resumo
                    order.printOrder();

                    if(!order.getProducts().isEmpty()) {
                        // Receber pagamento e calcular troco
                        System.out.print("Digite o valor recebido: R$ ");
                        double recebido = sc.nextDouble();
                        double troco = recebido - order.getTotal();
                        System.out.printf("Troco: R$ %.2f\n", troco);

                        System.out.println("--------------");
                        break;
                    }

                case 2: // Sair
                    System.out.println("Encerrando o programa...");
                    sc.close();
                    return;

                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}