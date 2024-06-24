import java.util.InputMismatchException;
import java.util.Scanner;

public class MenuAdmin extends MenuConfigs {

    public MenuAdmin(Scanner scanner, Hotel hotel, String usuario) {
        super(scanner, hotel, usuario);
    }

    @Override
    public void exibir() {
        boolean executando = true;

        System.out.println(ciano + "Olá " + usuario + "! Seja bem-vindo(a) ao nosso painel de Administrador. 😎" + reset);
        System.out.println(div);
        while (executando) {
            System.out.println(vermelho + "\n◆" + reset + "  Menu de Admin  " + vermelho + "◆");
            System.out.println(" ");
            System.out.println(ciano + "1." + reset + " Listar todos os quartos");
            System.out.println(ciano + "2." + reset + " Adicionar quarto");
            System.out.println(ciano + "3." + reset + " Excluir quarto");
            System.out.println(ciano + "4." + reset + " Liberar quarto");
            System.out.println(ciano + "5." + reset + " Logout");
            System.out.println("\n" + div);
            System.out.print(terminal + " Digite o número da opção desejada: ");
            int opcao;
            try {
                opcao = scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println(vermelho + "⚠ Opção inválida. Por favor, insira somente uma opção numérica." + reset);
                System.out.println("\n" + div);
                scanner.next();
                continue;
            }

            switch (opcao) {
                case 1:
                    System.out.println(div);
                    System.out.println("🧾 Lista de todos os quartos do nosso hotel:");
                    System.out.println(" ");
                    hotel.listarQuartos();
                    System.out.println(div);
                    break;
                case 2:
                    System.out.println(div);
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o número do quarto: ");
                    int numero = scanner.nextInt();
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o tipo do quarto (Simples, Duplo, Suite): ");
                    String tipo = scanner.next();
                    hotel.adicionarQuarto(new Quarto(numero, tipo));
                    System.out.println(div);
                    break;
                case 3:
                    System.out.println(div);
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o número do quarto a ser excluído: ");
                    int numeroExclusao = scanner.nextInt();
                    hotel.excluirQuarto(numeroExclusao);
                    System.out.println(div);
                    break;
                case 4:
                    System.out.println(div);
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o número do quarto a ser liberado: ");
                    int numeroLiberar = scanner.nextInt();
                    hotel.liberarQuarto(numeroLiberar);
                    System.out.println(div);
                    break;
                case 5:
                    executando = false;
                    System.out.println(div);
                    System.out.println("🚶‍♂️ Você saiu da sua conta.");
                    System.out.println(div);
                    break;
                default:
                    System.out.println(div);
                    System.out.println(vermelho + "⚠ Opção inválida! Digite algum número válido de opção." + reset);
                    System.out.println(div);
            }
        }
    }
}
