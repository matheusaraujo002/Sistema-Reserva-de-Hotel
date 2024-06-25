public class Quarto {
    // Atributos
    private int numero;
    private String tipo;
    private boolean disponivel;

    // Construtor
    public Quarto(int numero, String tipo) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponivel = true;
    }

    // Getters
    public int getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    // Métodos para reservar e liberar o quarto
    public void reservar() {
        this.disponivel = false;
    }

    public void liberar() {
        this.disponivel = true;
    }

    // Sobrescrita do método toString para formatar a exibição do quarto
    @Override
    public String toString() {
        return "Quarto " + numero + ", Tipo: " + tipo + ", Disponibilidade: " + (disponivel ? "Disponível" : "Ocupado"); //operador ternário
    }
}
