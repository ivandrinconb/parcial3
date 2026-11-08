package co.edu.uniquindio.parcial3.parcial3.modelo;

import co.edu.uniquindio.parcial3.parcial3.observer.TipoEvento;
import co.edu.uniquindio.parcial3.parcial3.mediator.CasaMediator;

public class SensorMovimiento extends Dispositivo {

    private boolean movimientoDetectado;
    private CasaMediator mediator;

    public SensorMovimiento(String nombre) {
        super(nombre, TipoDispositivo.SENSORMOVIMIENTO);
        this.movimientoDetectado = false;
    }

    public boolean isMovimientoDetectado() { return movimientoDetectado; }
    public void setMediator(CasaMediator mediator) {
        this.mediator = mediator;
    }

    public void detectarMovimiento() {
        movimientoDetectado = true;
        lanzarEvento(
                TipoEvento.MOVIMIENTO_DETECTADO,
                getNombre() + ": movimiento detectado"
        );
        if (mediator != null) {
            mediator.movimientoDetectado(this);
        }
    }

    public void limpiarMovimiento() {
        movimientoDetectado = false;

        lanzarEvento(
                TipoEvento.MOVIMIENTO_TERMINADO,
                getNombre() + ": sin movimiento"
        );

        if (mediator != null) {
            mediator.movimientoFinalizado(this);
        }
    }

    // Para un sensor, "apagar" significa limpiar el movimiento
    @Override
    public void apagar() {
        limpiarMovimiento();
    }

    @Override
    public String getDescripcionEstado() {
        if (movimientoDetectado) {
            return "Movimiento detectado";
        }
        return "Sin movimiento";
    }
}
