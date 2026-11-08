package co.edu.uniquindio.parcial3.parcial3.factory;

public class Termostato implements DispositivoInteligente {
    private int temperatura = 22;

    @Override
    public void encender() {
        System.out.println("Termostato activado.");
    }

    @Override
    public void apagar() {
        System.out.println("Termostato en standby.");
    }

    @Override
    public String obtenerEstado() {
        return temperatura + "°C";
    }
}