package exe01;

public class Main {
    public static void main(String[] args) {
        Pessoa[] pessoas = {
                new Pessoa("Danilo", "12345678910"),
                new Pessoa("Augusto", "12345678910"),
                new Pessoa("Camila", "12345678910"),
                new Pessoa("Bruna", "12345678910")
        };

        SortUtil.sort(pessoas);

        for (Pessoa pessoa: pessoas) {
            System.out.println(pessoa);
        }

        Celular[] celulares = {
               new Celular("8612345789", ""),
                new Celular("99987654321", ""),
                new Celular("62135792468", ""),
        };

        SortUtil.sort(celulares);

        for (Celular celular: celulares) {
            System.out.println(celular);
        }
    }
}
