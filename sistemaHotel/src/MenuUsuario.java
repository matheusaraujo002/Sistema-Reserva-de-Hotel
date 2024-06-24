import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class MenuUsuario extends MenuConfigs {

    public MenuUsuario(Scanner scanner, Hotel hotel, String usuario) {
        super(scanner, hotel, usuario);
    }

    @Override
    public void exibir() {
        boolean executando = true;

        System.out.println(ciano + "Olá " + usuario + "! Seja bem-vindo(a) ao nosso menu de reservas. 😃" + reset);
        System.out.println(div);
        while (executando) {
            System.out.println(roxo + "\n◆" + reset + "  Menu do Sistema  " + roxo + "◆");
            System.out.println(" ");
            System.out.println(ciano + "1." + reset + " Listar todos os quartos");
            System.out.println(ciano + "2." + reset + " Filtrar quartos disponíveis");
            System.out.println(ciano + "3." + reset + " Reservar quarto");
            System.out.println(ciano + "4." + reset + " Logout");
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
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o tipo de quarto que deseja filtrar (" + ciano + "Simples" + reset + ", " + ciano + "Duplo " + reset + ", " + ciano + "Suite" + reset + "): ");
                    String tipo = scanner.next();
                    System.out.println(div);
                    List<Quarto> disponiveis = hotel.buscarQuartosDisponiveis(tipo);
                    if (tipo.equalsIgnoreCase("simples") || tipo.equalsIgnoreCase("duplo") || tipo.equalsIgnoreCase("suite")) {
                        if (disponiveis.isEmpty()) {
                            System.out.println(vermelho + "⚠ Infelizmente todos os nossos quartos do tipo " + ciano + tipo + vermelho + " estão ocupados." + reset);
                            System.out.println(div);
                        } else {
                            System.out.println("🧾 Lista de quartos disponíveis do tipo " + ciano + tipo + reset + ":");
                            System.out.println(" ");
                            for (Quarto quarto : disponiveis) {
                                System.out.println("Número: " + ciano + quarto.getNumero() + reset + ", Tipo: " + ciano + quarto.getTipo() + reset);
                            }
                            System.out.println(div);
                        }
                    } else {
                        System.out.println(vermelho + "⚠ Opção inválida. Informe somente Simples, Duplo ou Suite." + reset);
                        System.out.println(div);
                    }
                    break;
                case 3:
                    System.out.println(div);
                    System.out.print(ciano + "❯❯❯" + reset + " Informe o número do quarto que deseja reservar: ");
                    int numeroReserva = scanner.nextInt();
                    hotel.reservarQuarto(numeroReserva);
                    System.out.println(div);
                    break;
                case 4:
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
