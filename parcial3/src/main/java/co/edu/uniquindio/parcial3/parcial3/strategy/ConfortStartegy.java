package co.edu.uniquindio.parcial3.parcial3.strategy;

public class ConfortStartegy implements TermostatoStrategy{
    @Override
    public double calcularObjetivo(double temperaturaPreferida, double temperaturaActual) {
        return temperaturaPreferida;
    }

    @Override
    public String getNombre() { return "Confort"; }
}
