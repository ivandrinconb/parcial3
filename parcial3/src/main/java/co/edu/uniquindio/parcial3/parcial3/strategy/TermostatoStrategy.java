package co.edu.uniquindio.parcial3.parcial3.strategy;

public interface TermostatoStrategy {

    double calcularObjetivo(double temperaturaPreferida, double temperaturaActual);

    String getNombre();
}
