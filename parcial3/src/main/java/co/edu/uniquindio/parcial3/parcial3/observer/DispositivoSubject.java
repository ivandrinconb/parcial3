package co.edu.uniquindio.parcial3.parcial3.observer;

public interface DispositivoSubject {
    void agregarObserver(DispositivoObserver observer);
    void eliminarObserver(DispositivoObserver observer);
    void notificarObservers(EventoDispositivo evento);
}
