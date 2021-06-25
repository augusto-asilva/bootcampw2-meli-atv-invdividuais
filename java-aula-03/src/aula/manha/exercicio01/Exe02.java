package aula.manha.exercicio01;

import java.util.Scanner;

public class Exe02 {

    public static void main(String[] args) {
        int n, m;

        Scanner scan = new Scanner(System.in);

        System.out.println("Digite um numero para achar seus multiplos: ");
        m = scan.nextInt();

        System.out.println("Digite quantos numeros voce quer verificar: ");
        n = scan.nextInt();

        for (int i = 2; i <= n + 1 ; i++) {
            System.out.print(i * m + " ");
        }
    }
}
