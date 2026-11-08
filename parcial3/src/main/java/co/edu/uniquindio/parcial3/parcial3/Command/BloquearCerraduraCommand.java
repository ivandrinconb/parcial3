package co.edu.uniquindio.parcial3.parcial3.Command;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;

public class BloquearCerraduraCommand implements Command {
    private Cerradura cerradura;

    public BloquearCerraduraCommand(Cerradura cerradura) {
        this.cerradura = cerradura;
    }

    @Override
    public void ejecutar() {
        cerradura.bloquear();
    }

    @Override
    public void deshacer() {
        // No hace nada: volver a abrir exigiría el PIN, y no lo guardamos
    }

    @Override
    public String getDescripcion() {
        return "Bloquear " + cerradura.getNombre();
    }
}
