import java.nio.charset.StandardCharsets;
import java.util.Random;

public class FogoDeArtificio {
    private String cor;
    private String formato;
    private String barulho;

    public FogoDeArtificio(String cor, String formato) {
        this.cor = cor;
        this.formato = formato;
        this.barulho = gerarSomDeExplosao();

    }

    public void explodir() {
        System.out.println("[Explosao] " + this.barulho);
    }

    private String gerarSomDeExplosao() {
        byte[] bArr = new byte[7];
        new Random().nextBytes(bArr);
        return new String(bArr, StandardCharsets.UTF_8);
    }

}
