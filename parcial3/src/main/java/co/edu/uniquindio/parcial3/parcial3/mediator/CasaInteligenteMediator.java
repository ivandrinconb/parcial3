package co.edu.uniquindio.parcial3.parcial3.mediator;

import co.edu.uniquindio.parcial3.parcial3.modelo.Luz;
import co.edu.uniquindio.parcial3.parcial3.modelo.SensorMovimiento;

import java.util.ArrayList;
import java.util.List;

public class CasaInteligenteMediator implements CasaMediator {

    private List<Luz> lucesRegistradas;

    public CasaInteligenteMediator() {
        this.lucesRegistradas = new ArrayList<>();
    }

    public void agregarLuz(Luz luz) {

        if (!lucesRegistradas.contains(luz)) {
            lucesRegistradas.add(luz);
        }

    }

    public void eliminarLuz(Luz luz) {
        lucesRegistradas.remove(luz);
    }

    @Override
    public void movimientoDetectado(SensorMovimiento sensor) {

        for (Luz luz : lucesRegistradas) {
            luz.encender();
        }

    }

    @Override
    public void movimientoFinalizado(SensorMovimiento sensor) {

        for (Luz luz : lucesRegistradas) {
            luz.apagar();
        }

    }
}
