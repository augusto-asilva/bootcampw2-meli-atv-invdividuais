package exe01;

public class Celular implements Precede<Celular> {
    private String numero, holder;

    public Celular(String numero, String holder) {
        this.numero = numero;
        this.holder = holder;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    @Override
    public int precedeA(Celular celular) {
        return this.numero.compareTo(celular.numero);
    }

    @Override
    public String toString() {
        return "Celular: " + this.numero;
    }
}
