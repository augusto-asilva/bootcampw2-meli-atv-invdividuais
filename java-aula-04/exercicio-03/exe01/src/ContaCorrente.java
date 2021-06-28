import java.math.BigDecimal;

public class ContaCorrente {

    private BigDecimal saldo;
    private int idCorrentitsta;

    public ContaCorrente(){}

    public ContaCorrente(BigDecimal saldo, int idCorrentitsta) {
        this.saldo = saldo;
        this.idCorrentitsta = idCorrentitsta;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public int getIdCorrentitsta() {
        return idCorrentitsta;
    }

    public void setIdCorrentitsta(int idCorrentitsta) {
        this.idCorrentitsta = idCorrentitsta;
    }

    public ContaCorrente(ContaCorrente outro) {
        this.saldo = outro.saldo;
        this.idCorrentitsta = outro.idCorrentitsta;
    }

    public void depositar(BigDecimal aDepositar) {
        if (aDepositar.intValue() > 0) {
            this.saldo = this.saldo.add(aDepositar);
        }
    }

    public void saque(BigDecimal aSacar) {
        BigDecimal totalDisponivel = this.saldo.subtract(aSacar);
        if (aSacar.intValue() > 0 && totalDisponivel.intValue() > 0) {
            this.saldo = this.saldo.subtract(aSacar);
        }
    }

    public void devolucao(ContaCorrente contaDestino, BigDecimal aDevolver) {
        if (aDevolver.intValue() > 0) {
            contaDestino.saldo = contaDestino.saldo.add(aDevolver);
        }
    }

    public void transferencia(ContaCorrente contaDestino, BigDecimal aTransferir) {
        if (aTransferir.intValue() > 0) {
            contaDestino.saldo = contaDestino.saldo.add(aTransferir);
        }
    }
}
