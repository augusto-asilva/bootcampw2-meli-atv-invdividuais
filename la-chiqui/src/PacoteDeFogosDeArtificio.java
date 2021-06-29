import java.util.List;

public class PacoteDeFogosDeArtificio {
    List<FogoDeArtificio> listaDeFogos;

    public PacoteDeFogosDeArtificio(List<FogoDeArtificio> listaDeFogos) {
        this.listaDeFogos = listaDeFogos;
    }

    public List<FogoDeArtificio> getListaDeFogos() {
        return this.listaDeFogos;
    }

    public void explodirPacoteEmSequencia() {
        for (FogoDeArtificio fogo: this.listaDeFogos) {
            fogo.explodir();
        }
    }
}
