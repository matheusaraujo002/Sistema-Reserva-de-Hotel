import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class MenuConfigs {
    protected Scanner scanner;
    protected Hotel hotel;
    protected String usuario;
    protected String reset = "\u001B[0m";
    protected String vermelho = "\u001B[31m";
    protected String verde = "\u001B[32m";
    protected String ciano = "\u001B[36m";
    protected String roxo = "\u001B[35m";
    protected String div = "━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━";
    protected String terminal = ciano + "❯❯❯" + reset;

    public MenuConfigs(Scanner scanner, Hotel hotel, String usuario) {
        this.scanner = scanner;
        this.hotel = hotel;
        this.usuario = usuario;
    }

    public abstract void exibir();
}
