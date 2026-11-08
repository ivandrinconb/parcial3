package co.edu.uniquindio.parcial3.parcial3.state;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;

public interface CerraduraState {
    void bloquear(Cerradura cerradura);
    void desbloquear(Cerradura cerradura, String pin);
    void reiniciar(Cerradura cerradura);
    boolean estaAbierta();
    String getNombre();
}
