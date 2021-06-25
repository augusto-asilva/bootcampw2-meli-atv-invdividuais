package aula.manha.exercicio01;

import java.util.Scanner;

public class Exe04 {
    public static void main(String[] args) {
        int n = 0,
            i = 1,
            j = 2;

        System.out.println("Selecione quantos numeros primos voce quer ver: ");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();

        while (i <= n) {
            boolean ehPrimo = Exe03.Aux.verificaPrimo(j);
            if (ehPrimo) {
                System.out.print(j + " ");
                i++;
            }
            j++;
        }
    }
}
