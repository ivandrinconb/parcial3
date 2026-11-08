package co.edu.uniquindio.parcial3.parcial3.state;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;
import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;

public class BloqueoTemporalState implements CerraduraState {
    @Override
    public void bloquear(Cerradura cerradura) {
        cerradura.publicarEvento(TipoEvento.ACCESO_DENEGADO,
                cerradura.getNombre() + " está en bloqueo temporal");
    }

    @Override
    public void desbloquear(Cerradura cerradura, String pin) {
        // Ni siquiera se mira el PIN: en este estado se rechaza todo
        cerradura.publicarEvento(TipoEvento.ACCESO_DENEGADO,
                cerradura.getNombre() + " está en bloqueo temporal, intenta más tarde");
    }

    @Override
    public void reiniciar(Cerradura cerradura) {
        cerradura.reiniciarIntentos();
        cerradura.setEstado(new BloqueadaState());
        cerradura.publicarEvento(TipoEvento.CAMBIO_ESTADO,
                cerradura.getNombre() + ": bloqueo temporal terminado");
    }

    @Override
    public boolean estaAbierta() { return false; }

    @Override
    public String getNombre() { return "Bloqueo temporal"; }
}
