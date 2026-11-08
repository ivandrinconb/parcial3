package co.edu.uniquindio.parcial3.parcial3.factory;

public class DispositivoFactory {
    public static DispositivoInteligente crearDispositivo(String tipo) {
        if (tipo == null) {
            return null;
        }
        return switch (tipo.toLowerCase()) {
            case "luz" -> new Luz();
            case "termostato" -> new Termostato();
            default -> throw new IllegalArgumentException("Dispositivo desconocido: " + tipo);
        };
    }
}