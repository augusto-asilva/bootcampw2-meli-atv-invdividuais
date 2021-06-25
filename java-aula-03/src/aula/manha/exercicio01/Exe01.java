package aula.manha.exercicio01;

import java.util.Scanner;

public class Exe01 {
    public static void main(String[] args) {
        int n;

        System.out.println("Selecione quantos numeros pares voce quer ver: ");
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.print(i * 2 + " ");
        }
    }
}
