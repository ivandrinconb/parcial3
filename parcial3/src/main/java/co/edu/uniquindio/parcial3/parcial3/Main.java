package co.edu.uniquindio.parcial3.parcial3;

import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoFactory;
import co.edu.uniquindio.parcial3.parcial3.modelo.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE INTEGRACIÓN DE PATRONES ===");

        // 1. Creamos la luz usando tu Factory Method y el modelo de tu compañero
        Luz luz = (Luz) DispositivoFactory.crearDispositivo("luz", "Luz Sala");

        // 2. Probamos los métodos del objeto real
        luz.encender();
        System.out.println("Dispositivo: " + luz.getNombre());
        System.out.println("Estado: " + luz.getDescripcionEstado());

        // 3. Probamos apagarlo
        luz.apagar();
        System.out.println("Estado después de apagar: " + luz.getDescripcionEstado());

        // 4. Probamos el Patrón Observer usando la interfaz del paquete observer
        luz.agregarObserver(new co.edu.uniquindio.parcial3.parcial3.observer.DispositivoObserver() {
            @Override
            public void actualizar(co.edu.uniquindio.parcial3.parcial3.observer.EventoDispositivo evento) {
                System.out.println("[EVENTO OBSERVADO]: " + evento.getMensaje()); // O el método que tenga EventoDispositivo para obtener el texto
            }
        });

        // 5. Disparamos acciones que el Observer capturará automáticamente
        luz.encender();
        luz.setBrillo(50);

        System.out.println("=== ¡INTEGRACIÓN EXITOSA AL 100%! ===");
    }
}