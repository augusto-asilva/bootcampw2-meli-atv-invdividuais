public class Convidado {
    private String nome;
    private TipoDeConvidado tipoDeConvidado;
    private String comemoracao;

    public Convidado(String nome, TipoDeConvidado tipoDeConvidado) {
        this.nome = nome;
        this.tipoDeConvidado = tipoDeConvidado;
        if (tipoDeConvidado == TipoDeConvidado.MELI) {
            this.comemoracao = "Viva la Chiqui!!";
        }
    }

    public void gritar() {
        System.out.println(this.nome + " grita: " + this.comemoracao);
    }

    public TipoDeConvidado getTipoDeConvidado() {
        return this.tipoDeConvidado;
    }
}
