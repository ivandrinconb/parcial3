package co.edu.uniquindio.parcial3.parcial3.Command;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class CommandHistorial {
    private List<Command> comandosEjecutados = new ArrayList<>();


    private List<Command> comandosDeshechos = new ArrayList<>();

    // Texto de todo lo que ha pasado, para mostrar en la pantalla
    private List<String> registro = new ArrayList<>();


    public void ejecutar(Command comando) {
        comando.ejecutar();
        comandosEjecutados.add(comando);
        comandosDeshechos.clear();
        registro.add("Ejecutado: " + comando.getDescripcion());
    }

    public void deshacer() {
        if (comandosEjecutados.isEmpty()) {
            return;
        }
        int ultimo = comandosEjecutados.size() - 1;
        Command comando = comandosEjecutados.remove(ultimo);
        comando.deshacer();
        comandosDeshechos.add(comando);
        registro.add("Deshecho: " + comando.getDescripcion());
    }

    public void rehacer() {
        if (comandosDeshechos.isEmpty()) {
            return;
        }
        int ultimo = comandosDeshechos.size() - 1;
        Command comando = comandosDeshechos.remove(ultimo);
        comando.ejecutar();
        comandosEjecutados.add(comando);
        registro.add("Rehecho: " + comando.getDescripcion());
    }

    public boolean puedeDeshacer() {
        return !comandosEjecutados.isEmpty();
    }

    public boolean puedeRehacer() {
        return !comandosDeshechos.isEmpty();
    }

    public List<String> getRegistro() {
        return registro;
    }
}
