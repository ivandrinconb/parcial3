package co.edu.uniquindio.parcial3.parcial3.decorator;

import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoInteligente;

public class DispositivoConAhorro extends DispositivoDecorador {

    public DispositivoConAhorro(DispositivoInteligente dispositivo) {
        super(dispositivo);
    }

    @Override
    public void encender() {
        super.encender();
        activarModoAhorro();
    }

    private void activarModoAhorro() {
        System.out.println("  -> [EcoFeature]: Modo ahorro de energía activado automáticamente.");
    }

    @Override
    public String obtenerEstado() {
        return super.obtenerEstado() + " (Con Ahorro de Energía)";
    }
}