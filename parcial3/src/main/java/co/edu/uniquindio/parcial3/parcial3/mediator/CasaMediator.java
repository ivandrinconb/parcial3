package co.edu.uniquindio.parcial3.parcial3.mediator;

import co.edu.uniquindio.parcial3.parcial3.modelo.SensorMovimiento;

public interface CasaMediator {
    void movimientoDetectado(SensorMovimiento sensor);

    void movimientoFinalizado(SensorMovimiento sensor);

}
