package co.edu.uniquindio.parcial3.parcial3.state;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;
import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;

public class BloqueadaState implements CerraduraState{
    @Override
    public void bloquear(Cerradura cerradura) {
        cerradura.publicarEvento(TipoEvento.CAMBIO_ESTADO,
                cerradura.getNombre() + " ya estaba bloqueada");
    }

    @Override
    public void desbloquear(Cerradura cerradura, String pin) {
        if (cerradura.validarPin(pin)) {
            cerradura.reiniciarIntentos();
            cerradura.setEstado(new DesbloqueadaState());
            cerradura.publicarEvento(TipoEvento.CAMBIO_ESTADO,
                    cerradura.getNombre() + " desbloqueada");
        } else {
            cerradura.sumarIntentoFallido();
            if (cerradura.getIntentosFallidos() >= cerradura.getMaxIntentos()) {
                cerradura.setEstado(new BloqueoTemporalState());
                cerradura.publicarEvento(TipoEvento.BLOQUEO_TEMPORAL,
                        cerradura.getNombre() + ": demasiados intentos, bloqueo temporal");
            } else {
                cerradura.publicarEvento(TipoEvento.ACCESO_DENEGADO,
                        cerradura.getNombre() + ": PIN incorrecto (intento "
                                + cerradura.getIntentosFallidos() + " de "
                                + cerradura.getMaxIntentos() + ")");
            }
        }
    }

    @Override
    public void reiniciar(Cerradura cerradura) {
        // No hay nada que reiniciar en este estado
    }

    @Override
    public boolean estaAbierta() { return false; }

    @Override
    public String getNombre() { return "Bloqueada"; }
}
