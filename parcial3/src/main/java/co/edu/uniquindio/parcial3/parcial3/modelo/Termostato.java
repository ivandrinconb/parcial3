package co.edu.uniquindio.parcial3.parcial3.modelo;

import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;
import co.edu.uniquindio.parcial3.parcial3.strategy.TermostatoStrategy;


public class Termostato extends Dispositivo {

    private boolean encendido;
    private double temperaturaActual;
    private double temperaturaPreferida;
    private double temperaturaObjetivo;
    private TermostatoStrategy strategy;

    
    public Termostato(String nombre, double temperaturaActual,
                      double temperaturaPreferida, TermostatoStrategy strategy) {
        super(nombre, TipoDispositivo.TERMOSTATO);
        this.encendido = false;
        this.temperaturaActual = temperaturaActual;
        this.temperaturaPreferida = temperaturaPreferida;
        this.strategy = strategy;
        recalcularObjetivo();
    }

    public boolean isEncendido() { return encendido; }
    public double getTemperaturaActual() { return temperaturaActual; }
    public double getTemperaturaPreferida() { return temperaturaPreferida; }
    public double getTemperaturaObjetivo() { return temperaturaObjetivo; }
    public TermostatoStrategy getStrategy() { return strategy; }

    public void encender() {
        encendido = true;
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + " encendido");
    }

    @Override
    public void apagar() {
        encendido = false;
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + " apagado");
    }

    // Aquí se cambia el algoritmo en caliente
    public void setStrategy(TermostatoStrategy strategy) {
        this.strategy = strategy;
        recalcularObjetivo();
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + ": modo " + strategy.getNombre()
                + ", objetivo " + temperaturaObjetivo + "°C");
    }

    public void setTemperaturaPreferida(double temperaturaPreferida) {
        this.temperaturaPreferida = temperaturaPreferida;
        recalcularObjetivo();
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + ": temperatura preferida "
                + temperaturaPreferida + "°C, objetivo " + temperaturaObjetivo + "°C");
    }

    public void setTemperaturaActual(double temperaturaActual) {
        this.temperaturaActual = temperaturaActual;
        recalcularObjetivo();
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + ": temperatura actual "
                + temperaturaActual + "°C, objetivo " + temperaturaObjetivo + "°C");
    }

    // El termostato no sabe cómo se calcula: se lo pregunta a su estrategia
    private void recalcularObjetivo() {
        temperaturaObjetivo = strategy.calcularObjetivo(temperaturaPreferida, temperaturaActual);
    }

    @Override
    public String getDescripcionEstado() {
        String modo = strategy.getNombre();
        if (encendido) {
            return "Encendido, modo " + modo + ", actual " + temperaturaActual
                    + "°C, objetivo " + temperaturaObjetivo + "°C";
        }
        return "Apagado, modo " + modo;
    }
}
