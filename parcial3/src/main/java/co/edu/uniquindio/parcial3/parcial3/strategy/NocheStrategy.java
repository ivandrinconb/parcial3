package co.edu.uniquindio.parcial3.parcial3.strategy;

public class NocheStrategy implements TermostatoStrategy{
    private double descenso;


    public NocheStrategy(double descenso) {
        this.descenso = descenso;
    }

    @Override
    public double calcularObjetivo(double temperaturaPreferida, double temperaturaActual) {
        return temperaturaPreferida - descenso;
    }

    @Override
    public String getNombre() { return "Noche"; }
}
