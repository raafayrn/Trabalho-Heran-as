abstract class Retangulo {
    protected int largura;
    protected int altura;
    protected String texto;

    public Retangulo(int largura, int altura, String texto) {
        this.largura = largura;
        this.altura = altura;
        this.texto = texto;
    }

    public abstract void desenhar();
}

class RetanguloSimples extends Retangulo {
    public RetanguloSimples(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("+" + "-".repeat(largura - 2) + "+");
        for (int i = 0; i < altura - 2; i++) {
            System.out.println("|" + " ".repeat(largura - 2) + "|");
        }
        System.out.println("+" + "-".repeat(largura - 2) + "+");
    }
}

class RetanguloAsciiArt extends Retangulo {
    public RetanguloAsciiArt(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("╔" + "═".repeat(largura - 2) + "╗");
        for (int i = 0; i < altura - 2; i++) {
            System.out.println("║" + " ".repeat(largura - 2) + "║");
        }
        System.out.println("╚" + "═".repeat(largura - 2) + "╝");
    }
}

class RetanguloColorido extends Retangulo {
    public RetanguloColorido(int largura, int altura, String texto) {
        super(largura, altura, texto);
    }

    @Override
    public void desenhar() {
        System.out.println("\033[1;31m" + "+" + "-".repeat(largura - 2) + "+\033[0m");
        for (int i = 0; i < altura - 2; i++) {
            System.out.println("\033[1;31m" + "|" + " ".repeat(largura - 2) + "|\033[0m");
        }
        System.out.println("\033[1;31m" + "+" + "-".repeat(largura - 2) + "+\033[0m");
    }
}

// Exemplo de uso:
public class Main {
    public static void main(String[] args) {
        Retangulo retSimples = new RetanguloSimples(10, 5, "Texto");
        Retangulo retAscii = new RetanguloAsciiArt(10, 5, "Texto");
        Retangulo retColorido = new RetanguloColorido(10, 5, "Texto");

        retSimples.desenhar();
        retAscii.desenhar();
        retColorido.desenhar();
    }
}
