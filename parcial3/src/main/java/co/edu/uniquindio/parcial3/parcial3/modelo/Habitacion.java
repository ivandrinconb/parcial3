package co.edu.uniquindio.parcial3.parcial3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Habitacion {
    private String nombre;
    private List<Dispositivo> dispositivos = new ArrayList<>();

    public Habitacion(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() { return nombre; }
    public List<Dispositivo> getDispositivos() { return dispositivos; }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void eliminarDispositivo(Dispositivo dispositivo) {
        dispositivos.remove(dispositivo);
    }

    @Override
    public String toString() {
        return nombre + " (" + dispositivos.size() + " dispositivos)";
    }
}
