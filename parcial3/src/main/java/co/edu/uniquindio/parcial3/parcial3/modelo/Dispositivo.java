package co.edu.uniquindio.parcial3.parcial3.modelo;

import co.edu.uniquindio.parcial3.parcial3.observer.DispositivoObserver;
import co.edu.uniquindio.parcial3.parcial3.observer.DispositivoSubject;
import co.edu.uniquindio.parcial3.parcial3.observer.EventoDispositivo;
import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;

import java.util.ArrayList;
import java.util.List;

public abstract class Dispositivo implements DispositivoSubject {
    private String nombre;
    private TipoDispositivo tipo;
    private List<DispositivoObserver> observers = new ArrayList<>();

    public Dispositivo(String nombre, TipoDispositivo tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public String getNombre() { return nombre; }
    public TipoDispositivo getTipo() { return tipo; }

    // Cada dispositivo dice cómo está en este momento
    public abstract String getDescripcionEstado();

    // Operación común: cada dispositivo la hace a su manera (la usará Composite)
    public abstract void apagar();

    // ----- Observer (Subject) -----

    @Override
    public void agregarObserver(DispositivoObserver observer) {
        observers.add(observer);
    }

    @Override
    public void eliminarObserver(DispositivoObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notificarObservers(EventoDispositivo evento) {
        for (DispositivoObserver observer : observers) {
            observer.actualizar(evento);
        }
    }

    // Método para que las subclases avisen un cambio más fácil
    protected void lanzarEvento(TipoEvento tipo, String mensaje) {
        EventoDispositivo evento = new EventoDispositivo(this, tipo, mensaje);
        notificarObservers(evento);
    }

    @Override
    public String toString() {
        return nombre + " [" + getDescripcionEstado() + "]";
    }
}
