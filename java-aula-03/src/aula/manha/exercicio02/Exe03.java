package aula.manha.exercicio02;

import java.util.Scanner;

public class Exe03 {
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Bem vindo(a) ao supermercado de 3 itens apenas");
        System.out.println("");
        double total = 0;
        Produto[] produtos = new Produto[3];

        for (int i = 0; i < produtos.length; i++) {
            String nome;
            double preco;
            int quantidade;
            System.out.println("Adicione o item "+ (i + 1)+":");
            System.out.println("Nome: ");
            nome = scan.nextLine();
            System.out.println("Preço: ");
            preco = scan.nextDouble();
            System.out.println("Quantidade: ");
            quantidade = scan.nextInt();
            scan.nextLine();
            System.out.println("");

            total += (preco * quantidade);

            produtos[i] = new Produto(nome, preco, quantidade);
        }

        System.out.println("Obrigado pela compra, segue o resumo abaixo...");

        for (int i = 0; i < produtos.length; i++) {
            System.out.println("Produto " + (i + 1));
            System.out.println(produtos[i].getNome());
            System.out.println("Preço");
            System.out.printf("R$%.2f\n", produtos[i].getPreco());
            System.out.printf("Quantidade: %d\n\n",  produtos[i].getQuantidade());
        }

        System.out.printf("Valor Total: R$%.2f", total);
    }

    public static class Produto {
        private String nome;
        private double preco;
        private int quantidade;
        public Produto(String nome, double preco, int quantidade){
            this.nome = nome;
            this.preco = preco;
            this.quantidade = quantidade;
        };

        public String getNome() {
            return nome;
        }

        public double getPreco() {
            return preco;
        }

        public int getQuantidade() {
            return quantidade;
        }
    }
}
