import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Vestuario> vestuarios = new ArrayList<>();

        vestuarios.add(new Vestuario("Adidas", "Regata"));
        vestuarios.add(new Vestuario("Adidas", "Bermuda"));
        vestuarios.add(new Vestuario("Adidas", "Meia"));

        GuardaRoupa guardaRoupa = new GuardaRoupa();

        Integer idRoupas = guardaRoupa.guardarVestuarios(vestuarios);

        System.out.println("Roupas guardadas com ID: " + idRoupas);

        guardaRoupa.mostrarVestuarios();

        List<Vestuario> roupasDevolvidas = guardaRoupa.devolverVestuarios(idRoupas);

        System.out.println("Roupas devolvidas: " + roupasDevolvidas);

        guardaRoupa.mostrarVestuarios();
    }
}
