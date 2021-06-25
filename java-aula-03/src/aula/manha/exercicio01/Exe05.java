package aula.manha.exercicio01;

import java.util.ArrayList;
import java.util.Scanner;

public class Exe05 {
    public static void main(String[] args) {
        int n = 0, m = 0, d = 0, i = 0, j = 0;

        Scanner scan= new Scanner(System.in);

        boolean dValido = false;
        while(!dValido) {
            System.out.println("Digite um numero que voce queira pesquisar em outros numeros: ");
            d = scan.nextInt();
            if(d > 0 && d <= 9) {
                dValido = true;
            } else {
                System.out.println("O numero digitado tem que ser maior que 0 e menor ou igual a 9");
            }
        }

        boolean mValido = false;
        while(!mValido) {
            System.out.println("Digite quantas vezes ele deve aparecer no numero: ");
            m = scan.nextInt();

            if (m > 0 && m <= 10) {
                mValido = true;
            } else {
                System.out.println("O numero digitado tem que ser maior que 0 e menor ou igual a 10");
            }
        }


        boolean nValido = false;
        while (!nValido) {
            System.out.println("Digite agora quantos numeros voce quer que aparece com a regra criada: ");
            n = scan.nextInt();

            if (n > 0 && n <= 10) {
                nValido = true;
            } else {
                System.out.println("O numero digitado tem que ser maior que 0 e menor ou igual a 10");
            }
        }

        ArrayList<Integer> nums = new ArrayList<Integer>();

        while (i < n) {
            if (Aux.containsDigit(j, d, m)) {
                nums.add(j);
                i++;
            }
            j++;
        }

        for (int num: nums) {
            if (num == nums.get(nums.size() - 1)) {
                System.out.print(num + ".");
            } else {
                System.out.print(num + ", ");
            }

        }

    }

    private static class Aux {
        public static boolean containsDigit(int number, int digit, int times) {

            int i = 0;
            ArrayList<Boolean> checks = new ArrayList<Boolean>();

            while(number != 0) {
                int curr_digit = number % 10;
                if (curr_digit == digit) {
                    checks.add(true);
                }
                number = number / 10;
            }

            if (checks.size() == times) {
                return true;
            } else {
                return false;
            }
        }
    }
}
