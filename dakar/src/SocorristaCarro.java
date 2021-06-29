public class SocorristaCarro implements Socorrista<Carro>{
    @Override
    public void socorrer(Carro carro) {
        System.out.println("Socorrendo carro " + carro.getPlaca());
    }
}
