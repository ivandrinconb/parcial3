package co.edu.uniquindio.parcial3.parcial3.modelo;

import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;

public class Luz extends Dispositivo{
    private boolean encendida;
    private int brillo;

    public Luz(String nombre) {
        super(nombre, TipoDispositivo.LUZ);
        this.encendida = false;
        this.brillo = 100;
    }

    public boolean isEncendida() { return encendida; }
    public int getBrillo() { return brillo; }

    public void encender() {
        encendida = true;
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + " encendida");
    }

    @Override
    public void apagar() {
        encendida = false;
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + " apagada");
    }

    public void setBrillo(int brillo) {
        if (brillo < 0) brillo = 0;
        if (brillo > 100) brillo = 100;
        this.brillo = brillo;
        lanzarEvento(TipoEvento.CAMBIO_ESTADO, getNombre() + " brillo al " + brillo + "%");
    }

    @Override
    public String getDescripcionEstado() {
        if (encendida) {
            return "Encendida, brillo " + brillo + "%";
        }
        return "Apagada";
    }
}
