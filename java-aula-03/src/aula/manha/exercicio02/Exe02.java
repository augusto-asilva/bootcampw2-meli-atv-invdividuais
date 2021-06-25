package aula.manha.exercicio02;

public class Exe02 {
    public static void main(String[] args) {
        double valorEmpresaX = 1.13;
        double valorEmpresaY = 18.4;

        int ano = 2021;

        boolean xPassouY = false;

        System.out.printf("Empresa X - 01/01/%d - Valor da empresa: %.2f\n", ano, valorEmpresaX);
        System.out.printf("Empresa Y - 01/01/%d - Valor da empresa: %.2f\n", ano, valorEmpresaY);
        while(!xPassouY){
            valorEmpresaX = valorEmpresaX + (valorEmpresaX * 1.48);
            valorEmpresaY = valorEmpresaY + (valorEmpresaY * 0.32);

            ano++;

            System.out.println("");
            System.out.printf("Empresa X - 01/01/%d - Valor da empresa: %.2f\n", ano, valorEmpresaX);
            System.out.printf("Empresa Y - 01/01/%d - Valor da empresa: %.2f\n", ano, valorEmpresaY);

            if (valorEmpresaX > valorEmpresaY) {
                xPassouY = true;
            }
        }
    }
}
