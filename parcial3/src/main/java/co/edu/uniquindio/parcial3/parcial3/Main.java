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
                System.out.println("[EVENTO OBSERVADO]: " + evento.getMensaje());
            }
        });

        // 5. Disparamos acciones que el Observer capturará automáticamente
        luz.encender();
        luz.setBrillo(50);

        // 6. Probamos el Patrón Strategy con el Termostato creando la instancia con sus parámetros completos
        System.out.println("\n=== PRUEBA DE PATRÓN STRATEGY ===");

        // Creamos una estrategia inicial por defecto (ej. EcoStrategy)
        co.edu.uniquindio.parcial3.parcial3.strategy.TermostatoStrategy estrategiaInicial =
                new co.edu.uniquindio.parcial3.parcial3.strategy.EcoStrategy(20.0);

        // Instanciamos el termostato pasando nombre, temp actual, temp preferida y la estrategia
        Termostato termostato = new Termostato("Termostato Pasillo", 22.0, 24.0, estrategiaInicial);

        // Probamos encenderlo y ver su estado
        termostato.encender();
        System.out.println("Estado inicial con Eco: " + termostato.getDescripcionEstado());

        // Cambiamos dinámicamente a la estrategia Confort en tiempo de ejecución
        termostato.setStrategy(new co.edu.uniquindio.parcial3.parcial3.strategy.ConfortStartegy());
        System.out.println("Estado cambiado a Confort: " + termostato.getDescripcionEstado());
    }
}