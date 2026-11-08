package co.edu.uniquindio.parcial3.parcial3.Command;

public interface Command {
    void ejecutar();
    void deshacer();
    String getDescripcion();
}
