import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Convidado> convidados = new ArrayList<>();
        List<PacoteDeFogosDeArtificio> fogosDeArtificios = new ArrayList<>();

        System.out.println("Preparando fogos de artificios da festa La Chiqui...");

        List<FogoDeArtificio> listaFogos01 = new ArrayList<>();
        listaFogos01.add(new FogoDeArtificio("Amarela", "Estrela"));
        listaFogos01.add(new FogoDeArtificio("Azul", "Ciruclo"));
        PacoteDeFogosDeArtificio pacote01 = new PacoteDeFogosDeArtificio(listaFogos01);

        List<FogoDeArtificio> listaFogos02 = new ArrayList<>();
        listaFogos02.add(new FogoDeArtificio("Verde", "Hexagono"));
        PacoteDeFogosDeArtificio pacote02 = new PacoteDeFogosDeArtificio(listaFogos02);

        fogosDeArtificios.add(pacote01);
        fogosDeArtificios.add(pacote02);

        System.out.println("Fogos de artificios preparados!");

        System.out.println("Festa La Chiqui começou!");

        convidados.add(new Convidado("Augusto", TipoDeConvidado.MELI));
        convidados.add(new Convidado("Iago", TipoDeConvidado.MELI));
        convidados.add(new Convidado("Lucas", TipoDeConvidado.MELI));

        System.out.println("Convidados MELI chegaram!");

        convidados.add(new Convidado("Kenyo", TipoDeConvidado.STANDARD));
        convidados.add(new Convidado("Yuri", TipoDeConvidado.STANDARD));
        convidados.add(new Convidado("Pedro", TipoDeConvidado.STANDARD));

        System.out.println("Convidados Standard chegaram!");

        System.out.println("Chegou o momento de assoprar as velas...");

        for (Convidado convidado : convidados) {
            if (convidado.getTipoDeConvidado() == TipoDeConvidado.MELI) {
                convidado.gritar();
            }
        }

        for (PacoteDeFogosDeArtificio pacote : fogosDeArtificios) {
            pacote.explodirPacoteEmSequencia();
        }

    }
}
