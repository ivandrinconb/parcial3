package co.edu.uniquindio.parcial3.parcial3.strategy;

public class EcoStrategy implements TermostatoStrategy{
    private double margen;


    public EcoStrategy(double margen) {
        this.margen = margen;
    }

    @Override
    public double calcularObjetivo(double temperaturaPreferida, double temperaturaActual) {
        double limite = temperaturaPreferida + margen;
        if (temperaturaActual <= limite) {
            return temperaturaActual;
        }
        return limite;
    }

    @Override
    public String getNombre() { return "Eco"; }
}
