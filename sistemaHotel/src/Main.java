import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Hotel hotel = new Hotel();
        String reset = "\u001B[0m";
        String vermelho = "\u001B[31m";
        String ciano = "\u001B[36m";
        String div = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
        String terminal = ciano + "❯❯❯" + reset;

        // Armazenando alguns quartos ao hotel
        System.out.println(div);
        System.out.println("🖊 Adicionando quartos pré-definidos:\n");
        hotel.adicionarQuarto(new Quarto(101, "Simples"));
        hotel.adicionarQuarto(new Quarto(102, "Simples"));
        hotel.adicionarQuarto(new Quarto(201, "Duplo"));
        hotel.adicionarQuarto(new Quarto(202, "Duplo"));
        hotel.adicionarQuarto(new Quarto(301, "Suite"));
        hotel.adicionarQuarto(new Quarto(302, "Suite"));

        System.out.println(div);
        while (true) {
            System.out.println(ciano + "Bem-Vindo ao Sistema de Reserva de Hotel!" + reset + "👋");
            System.out.println(vermelho + "⚠ Se deseja sair do Sistema, digite: Sair\n");
            System.out.print(terminal + " Digite seu nome: ");
            String usuario = scanner.next();
            System.out.println(div);

            if (usuario.equalsIgnoreCase("Sair")) {
                System.out.println("🛑 Sistema fechado com sucesso! Até mais. 👋");
                System.out.println(div);
                break;
            }

            MenuConfigs menu;
            if (usuario.equalsIgnoreCase("Admin")) {
                menu = new MenuAdmin(scanner, hotel, usuario);
            } else {
                menu = new MenuUsuario(scanner, hotel, usuario);
            }

            menu.exibir();
        }
    }
}