package co.edu.uniquindio.parcial3.parcial3.factory;

public class Luz implements DispositivoInteligente {
    private boolean encendido = false;

    @Override
    public void encender() {
        encendido = true;
    }

    @Override
    public void apagar() {
        encendido = false;
    }

    @Override
    public String obtenerEstado() {
        return encendido ? "Encendida" : "Apagada";
    }
}