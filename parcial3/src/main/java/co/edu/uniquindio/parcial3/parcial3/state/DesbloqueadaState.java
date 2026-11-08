package co.edu.uniquindio.parcial3.parcial3.state;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;
import co.edu.uniquindio.parcial3.parcial3.observer.DispositivoSubject;
import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;

public class DesbloqueadaState implements CerraduraState {
    @Override
    public void bloquear(Cerradura cerradura) {
        cerradura.setEstado(new BloqueadaState());
        cerradura.publicarEvento(TipoEvento.CAMBIO_ESTADO,
                cerradura.getNombre() + " bloqueada");
    }

    @Override
    public void desbloquear(Cerradura cerradura, String pin) {
        cerradura.publicarEvento(TipoEvento.CAMBIO_ESTADO,
                cerradura.getNombre() + " ya estaba desbloqueada");
    }

    @Override
    public void reiniciar(Cerradura cerradura) {
        // No hay nada que reiniciar en este estado
    }

    @Override
    public boolean estaAbierta() { return true; }

    @Override
    public String getNombre() { return "Desbloqueada"; }
}
