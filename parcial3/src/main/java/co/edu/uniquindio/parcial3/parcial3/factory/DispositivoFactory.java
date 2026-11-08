package co.edu.uniquindio.parcial3.parcial3.factory;

import co.edu.uniquindio.parcial3.parcial3.modelo.Dispositivo;

public class DispositivoFactory {
    public static Dispositivo crearDispositivo(String tipo, String nombre) {
        switch (tipo.toLowerCase()) {
            case "luz":
                return new co.edu.uniquindio.parcial3.parcial3.modelo.Luz(nombre);
            case "sensor":
                return new co.edu.uniquindio.parcial3.parcial3.modelo.SensorMovimiento(nombre);
            case "cerradura":
                return new co.edu.uniquindio.parcial3.parcial3.modelo.Cerradura(nombre, "1234", 3);
            case "termostato":
                return new co.edu.uniquindio.parcial3.parcial3.modelo.Termostato(nombre, 22.0, 21.0, null);
            default:
                throw new IllegalArgumentException("Tipo de dispositivo no soportado: " + tipo);
        }
    }
}