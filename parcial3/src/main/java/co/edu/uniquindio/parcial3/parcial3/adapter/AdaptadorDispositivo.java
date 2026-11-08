package co.edu.uniquindio.parcial3.parcial3.adapter;

import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoInteligente;

public class AdaptadorDispositivo implements DispositivoInteligente {
    private DispositivoLegacy dispositivoLegacy;

    public AdaptadorDispositivo(DispositivoLegacy dispositivoLegacy) {
        this.dispositivoLegacy = dispositivoLegacy;
    }

    @Override
    public void encender() {
        dispositivoLegacy.conectarSistema(); // Traduce encender() al método antiguo
    }

    @Override
    public void apagar() {
        dispositivoLegacy.desconectarSistema(); // Traduce apagar() al método antiguo
    }

    @Override
    public String obtenerEstado() {
        return dispositivoLegacy.verEstado(); // Traduce obtenerEstado() al método antiguo
    }
}