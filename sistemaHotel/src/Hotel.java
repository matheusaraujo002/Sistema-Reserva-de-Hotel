import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Quarto> quartos;

    String reset = "\u001B[0m";
    String verde = "\u001B[32m";
    String vermelho = "\u001B[31m";

    public Hotel() {
        quartos = new ArrayList<>();
    }

    public void listarQuartos() {
        int contDisponivel = 0;
        int contOcupado = 0;
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel()) {
                System.out.println(verde+ quarto +reset);
                contDisponivel++;
            } else {
                System.out.println(vermelho+ quarto +reset);
                contOcupado++;
            }
        }
        System.out.println(verde+ "\nQuartos Disponíveis: " +contDisponivel + reset + "  -  " +vermelho+ "Quartos Ocupados: " +contOcupado + reset);
    }

    public List<Quarto> buscarQuartosDisponiveis(String tipo) {
        List<Quarto> disponiveis = new ArrayList<>();
        for (Quarto quarto : quartos) {
            if (quarto.isDisponivel() && quarto.getTipo().equalsIgnoreCase(tipo)) {
                disponiveis.add(quarto);
            }
        }
        return disponiveis;
    }

    public void reservarQuarto(int numero) {
        boolean quartoEncontrado = false;

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quartoEncontrado = true;
                if (quarto.isDisponivel()) {
                    quarto.reservar();
                    System.out.println(verde + "✅ Quarto " + numero + " reservado com sucesso." + reset);
                    return;
                } else {
                    System.out.println(vermelho + "⚠ O quarto " + numero + " já está reservado." + reset);
                    return;
                }
            }
        }

        if (!quartoEncontrado) {
            System.out.println(vermelho + "⚠ O quarto inserido não existe." + reset);
        }
    }

    //Admin

    public void adicionarQuarto(Quarto quarto) {
        for (Quarto q : quartos) {
            if (q.getNumero() == quarto.getNumero()) {
                System.out.println(vermelho+ "⚠ Já existe um quarto com o número " + quarto.getNumero() + "." +reset);
                return;
            }
        }
        quartos.add(quarto);
        System.out.println(verde+ "✅ Quarto adicionado com sucesso." +reset);
    }

    public void liberarQuarto(int numero) {
        boolean quartoEncontrado = false;

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quartoEncontrado = true;
                if (!quarto.isDisponivel()) {
                    quarto.liberar();
                    System.out.println(verde + "✅ Quarto " + numero + " liberado com sucesso." + reset);
                    return;
                } else {
                    System.out.println(vermelho + "⚠ O quarto " + numero + " já está disponível." + reset);
                    return;
                }
            }
        }

        if (!quartoEncontrado) {
            System.out.println(vermelho + "⚠ O quarto inserido não existe." + reset);
        }
    }

    public void excluirQuarto(int numero) {
        Quarto quartoAExcluir = null;

        for (Quarto quarto : quartos) {
            if (quarto.getNumero() == numero) {
                quartoAExcluir = quarto;
                break;
            }
        }

        if (quartoAExcluir != null) {
            quartos.remove(quartoAExcluir);
            System.out.println(verde + "✅ Quarto " + numero + " excluído com sucesso." + reset);
        } else {
            System.out.println(vermelho + "⚠ O quarto inserido não existe." + reset);
        }
    }
}
