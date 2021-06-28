public class FuncionarioCLT extends Funcionario{
    private CargoFuncionarioCLT cargo;
    public FuncionarioCLT(String nome, int jornada, CargoFuncionarioCLT cargo) {
        super(nome, jornada);
        this.cargo = cargo;
    }

    public void pagarSalario() {
        double salarioBase = 0;
        double salarioAPagar;
        double bonificacao;

        switch (this.cargo){
            case TECNICO:
                bonificacao = 0.05;
                salarioBase = 3200;
                salarioAPagar = salarioBase + (salarioBase * bonificacao);
                System.out.printf("O salario base eh de R$%.2f com bonficacao de %.2f%.\n Valor total a pagar R$%.2f",
                        salarioBase, bonificacao, salarioAPagar);
                break;
            case ANALISTAS:
                bonificacao = 0.08;
                salarioBase = 4000;
                salarioAPagar = salarioBase + (salarioBase * bonificacao);
                System.out.printf("O salario base eh de R$%.2f com bonficacao de %.2f%.\n Valor total a pagar R$%.2f",
                        salarioBase, bonificacao, salarioAPagar);
                break;
            case GERENTES:
                bonificacao = 0.125;
                salarioBase = 6000;
                salarioAPagar = salarioBase + (salarioBase * bonificacao);
                System.out.printf("O salario base eh de R$%.2f com bonficacao de %.2f%.\n Valor total a pagar R$%.2f",
                        salarioBase, bonificacao, salarioAPagar);
                break;
            case DIRETORES:
                bonificacao = 0.00;
                salarioBase = 15000;
                double lucro = 100000;
                double participacao = 0.03;
                salarioAPagar = salarioBase + (salarioBase * bonificacao) + (lucro * participacao);
                System.out.printf("O salario base eh de R$%.2f sem bonficacao, mas com participacao de %0.2f% dos lucros.\n Valor total a pagar R$%.2f",
                        salarioBase, participacao, salarioAPagar);
                break;
            default:
                System.out.println("Cargo nao identificado!");
        }
    }

}
