import java.math.BigDecimal;

public class Funcionario {
    private String nome;
    private int jornada;

    public Funcionario(String nome, int jornada) {
        this.nome = nome;
        this.jornada = jornada;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getJornada() {
        return jornada;
    }

    public void setJornada(int jornada) {
        this.jornada = jornada;
    }
}
