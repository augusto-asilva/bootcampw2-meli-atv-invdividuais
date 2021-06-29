import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GuardaRoupa {
    private Map<Integer, List<Vestuario>> dicionario = new HashMap<>();
    private int contador = 1;

    public GuardaRoupa() {
    }

    public Integer guardarVestuarios(List<Vestuario> vestuarios) {
        Integer id = this.contador;
        this.dicionario.put(id, vestuarios);
        contador++;
        return id;
    }

    public void mostrarVestuarios(){
        this.dicionario.entrySet().stream()
                .forEach(entry -> System.out.println("Chave: "+ entry.getKey() + ", vestuarios: " + entry.getValue()));
    }

    public List<Vestuario> devolverVestuarios(Integer id) {
        List<Vestuario> vestuarios = this.dicionario.get(id);
        this.dicionario.remove(id);
        return vestuarios;
    }
}
