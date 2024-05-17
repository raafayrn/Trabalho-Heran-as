abstract class Progressao {
    public abstract void reiniciar();
    public abstract int proximo();
}

class ProgressaoAritmetica extends Progressao {
    private int primeiro;
    private int razao;
    private int atual;

    public ProgressaoAritmetica(int primeiro, int razao) {
        this.primeiro = primeiro;
        this.razao = razao;
        reiniciar();
    }

    @Override
    public void reiniciar() {
        this.atual = primeiro;
    }

    @Override
    public int proximo() {
        int valor = atual;
        atual += razao;
        return valor;
    }
}

class ProgressaoGeometrica extends Progressao {
    private int primeiro;
    private int razao;
    private int atual;

    public ProgressaoGeometrica(int primeiro, int razao) {
        this.primeiro = primeiro;
        this.razao = razao;
        reiniciar();
    }

    @Override
    public void reiniciar() {
        this.atual = primeiro;
    }

    @Override
    public int proximo() {
        int valor = atual;
        atual *= razao;
        return valor;
    }
}

class ProgressaoFibonacci extends Progressao {
    private int atual;
    private int proximoValor;

    public ProgressaoFibonacci() {
        reiniciar();
    }

    @Override
    public void reiniciar() {
        this.atual = 0;
        this.proximoValor = 1;
    }

    @Override
    public int proximo() {
        int valor = atual;
        atual = proximoValor;
        proximoValor += valor;
        return valor;
    }
}

// Exemplo de uso:
public class Main {
    public static void main(String[] args) {
        ProgressaoAritmetica pa = new ProgressaoAritmetica(1, 2);
        ProgressaoGeometrica pg = new ProgressaoGeometrica(1, 2);
        ProgressaoFibonacci pf = new ProgressaoFibonacci();

        for (int i = 0; i < 5; i++) {
            System.out.println(pa.proximo() + " " + pg.proximo() + " " + pf.proximo());
        }
    }
}
