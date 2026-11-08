package co.edu.uniquindio.parcial3.parcial3.Command;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;

public class ReiniciarCerraduraCommand implements Command {
    private Cerradura cerradura;

    public ReiniciarCerraduraCommand(Cerradura cerradura) {
        this.cerradura = cerradura;
    }

    @Override
    public void ejecutar() {
        cerradura.reiniciar();
    }

    @Override
    public void deshacer() {

    }

    @Override
    public String getDescripcion() {
        return "Reiniciar " + cerradura.getNombre();
    }
}
