public class FuncionarioPJ extends Funcionario{
    double valorDaHora;
    public FuncionarioPJ(String nome, int jornada, double valorDaHora) {
        super(nome, jornada);
        this.valorDaHora = valorDaHora;
    }

    public void pagarSalario() {
        double salarioAPagar = this.valorDaHora * this.getJornada();
        System.out.printf("Salario a pagar com base em jornada de %d horas eh de R$%.2f", getJornada(), salarioAPagar);
    }
}
