import java.math.BigDecimal;
import java.util.List;

public class Corrida {
    double distancia;
    BigDecimal premioEmDolares;
    String nome;
    int quantidadeDeVeiculos;
    List<Veiculo> listaDeVeiculos;
    SocorristaCarro socorristaCarro = new SocorristaCarro();
    SocorristaMoto socorristaMoto = new SocorristaMoto();

    public Corrida(double distancia, BigDecimal premioEmDolares, String nome, int quantidadeDeVeiculos, List<Veiculo> listaDeVeiculos) {
        this.distancia = distancia;
        this.premioEmDolares = premioEmDolares;
        this.nome = nome;
        this.quantidadeDeVeiculos = quantidadeDeVeiculos;
        this.listaDeVeiculos = listaDeVeiculos;
    }

    public void registrarCarro(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.listaDeVeiculos.add(new Carro(velocidade, aceleracao, anguloDeGiro, placa));
    }

    public void registrarMoto(double velocidade, double aceleracao, double anguloDeGiro, String placa) {
        this.listaDeVeiculos.add(new Moto(velocidade, aceleracao, anguloDeGiro, placa));
    }

    public void removerVeiculo(Veiculo veiculo) {
        this.listaDeVeiculos.remove(veiculo);
    }

    public void removerVeiculoPorPlaca(String placa) {
        listaDeVeiculos.remove(pegarVeiculoPorPlaca(placa));
    }

    public Veiculo pegarVencedor() {
        int indexTemp = 0;
        double pontuacaoTemp = 0;
        int contador = 0;

        for (Veiculo veiculo : this.listaDeVeiculos) {
            double pontuacaoVeiculo = calcularPontuacao(veiculo.getVelocide(), veiculo.getAceleracao(), veiculo.getAnguloDeGiro(),
                    veiculo.getPeso(), veiculo.getRodas());

            if (pontuacaoVeiculo > pontuacaoTemp) {
                pontuacaoTemp = pontuacaoVeiculo;
                indexTemp = contador;
            }

            contador++;
        }

        return this.listaDeVeiculos.get(indexTemp);
    }

    public void socorrerCarro(String placa) {
        socorristaCarro.socorrer((Carro) pegarVeiculoPorPlaca(placa));
    }

    public void socorrerMoto(String placa) {
        socorristaMoto.socorrer((Moto) pegarVeiculoPorPlaca(placa));
    }

    private Veiculo pegarVeiculoPorPlaca(String placa) {
        Veiculo aRetornar = null;
        for (Veiculo veiculo : this.listaDeVeiculos)
            if (veiculo.placa.equals(placa)) {
                aRetornar = veiculo;
            }
        return aRetornar;
    }

    private double calcularPontuacao(double velocidade, double aceleracao, double anguloDeGiro, double peso, int rodas) {
        return (velocidade * aceleracao) / (anguloDeGiro * (peso - (rodas * 100)));
    }
}
