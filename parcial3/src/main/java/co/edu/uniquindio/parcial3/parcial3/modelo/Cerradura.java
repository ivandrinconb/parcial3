package co.edu.uniquindio.parcial3.parcial3.modelo;

import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;
import co.edu.uniquindio.parcial3.parcial3.state.BloqueadaState;
import co.edu.uniquindio.parcial3.parcial3.state.CerraduraState;

public class Cerradura extends Dispositivo {

    private CerraduraState estado;
    private String pin;
    private int maxIntentos;
    private int intentosFallidos;

    // El nombre, el PIN y los intentos máximos los ingresa el usuario en la pantalla
    public Cerradura(String nombre, String pin, int maxIntentos) {
        super(nombre, TipoDispositivo.CERRADURA);
        this.pin = pin;
        this.maxIntentos = maxIntentos;
        this.intentosFallidos = 0;
        this.estado = new BloqueadaState();
    }

    // ----- Las acciones se delegan al estado actual -----

    public void bloquear() {
        estado.bloquear(this);
    }

    public void desbloquear(String pinIngresado) {
        estado.desbloquear(this, pinIngresado);
    }

    public void reiniciar() {
        estado.reiniciar(this);
    }

    // ----- Métodos que usan los estados -----

    public void setEstado(CerraduraState estado) {
        this.estado = estado;
    }

    public boolean validarPin(String pinIngresado) {
        return pin.equals(pinIngresado);
    }

    public void sumarIntentoFallido() {
        intentosFallidos++;
    }

    public void reiniciarIntentos() {
        intentosFallidos = 0;
    }

    public int getIntentosFallidos() { return intentosFallidos; }
    public int getMaxIntentos() { return maxIntentos; }

    public boolean estaAbierta() {
        return estado.estaAbierta();
    }

    // Los estados están en otro paquete y lanzarEvento es protected,
    // por eso la cerradura expone este método
    public void publicarEvento(TipoEvento tipo, String mensaje) {
        lanzarEvento(tipo, mensaje);
    }

    @Override
    public void apagar() {
        bloquear();
    }

    @Override
    public String getDescripcionEstado() {
        return estado.getNombre();
    }
}
