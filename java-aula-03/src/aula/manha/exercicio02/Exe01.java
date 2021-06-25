package aula.manha.exercicio02;

public class Exe01 {
    public static void main(String[] args) {
        Integer[] array = {52, 10, 85, 1324, 01, 13, 62, 30, 12, 127};
        int temp = 0;

        for (int i = 0; i < array.length ; i++) {
            for (int j = i + 1; j <  array.length; j++) {
                if (array[i] > array[j]){
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }

        System.out.println("Ordem crescente: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");

        for (int i = 0; i < array.length ; i++) {
            for (int j = i + 1; j <  array.length; j++) {
                temp = array[i];
                array[i] = array[j];
                array[j] = temp;
            }
        }

        System.out.println("Ordem decrescente: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println("");
    }
}
