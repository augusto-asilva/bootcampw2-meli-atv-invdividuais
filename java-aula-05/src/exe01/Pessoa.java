package exe01;

public class Pessoa implements Precede<Pessoa>{
    private String nome, cpf;

    public Pessoa(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    @Override
    public int precedeA(Pessoa pessoa) {
        return this.nome.compareTo(pessoa.nome);
    }

    @Override
    public String toString() {
        return "Pessoa: " + this.nome;
    }
}
