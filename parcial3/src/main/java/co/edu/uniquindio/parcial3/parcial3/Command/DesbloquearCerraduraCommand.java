package co.edu.uniquindio.parcial3.parcial3.Command;

import co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura;

public class DesbloquearCerraduraCommand implements Command {
    private Cerradura cerradura;
    private String pin;

    public DesbloquearCerraduraCommand(
            Cerradura cerradura,
            String pin) {

        this.cerradura = cerradura;
        this.pin = pin;
    }

    @Override
    public void ejecutar() {
        cerradura.desbloquear(pin);
    }

    @Override
    public void deshacer() {

    }

    @Override
    public String getDescripcion() {
        return "Desbloquear " + cerradura.getNombre();
    }
}
