package aula.manha.exercicio01;

import java.util.Scanner;



public class Exe03 {
    public static void main(String[] args) {
        int n;

        System.out.println("Digite um numero para verificar se eh primo: ");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        boolean ehPrimo = Aux.verificaPrimo(n);

        if (ehPrimo) {
            System.out.println("O numero digitado eh primo");
        } else {
            System.out.println("O numero digitado nao eh primo");
        }

    }

    public static class Aux {
        public static boolean verificaPrimo(int num) {
            for (int i = 2; i <  num; i++) {
                if (num % i == 0) {
                    return false;
                }
            }

            return true;
        }
    }
}
