public class Veiculo {
    double velocide, aceleracao, anguloDeGiro, peso;
    int rodas;
    String placa;

    public Veiculo(double velocide, double aceleracao, double anguloDeGiro, double peso, int rodas, String placa) {
        this.velocide = velocide;
        this.aceleracao = aceleracao;
        this.anguloDeGiro = anguloDeGiro;
        this.peso = peso;
        this.rodas = rodas;
        this.placa = placa;
    }

    public double getVelocide() {
        return velocide;
    }

    public double getAceleracao() {
        return aceleracao;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public double getPeso() {
        return peso;
    }

    public int getRodas() {
        return rodas;
    }

    public String getPlaca() {
        return placa;
    }
}
