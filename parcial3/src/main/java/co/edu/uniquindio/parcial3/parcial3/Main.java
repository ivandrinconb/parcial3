package co.edu.uniquindio.parcial3.parcial3;

import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoConAhorro;
import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoFactory;
import co.edu.uniquindio.parcial3.parcial3.factory.DispositivoInteligente;
import co.edu.uniquindio.parcial3.parcial3.adapter.AdaptadorDispositivo;
import co.edu.uniquindio.parcial3.parcial3.adapter.DispositivoLegacy;

public class Main {
    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE PATRONES DE DISEÑO ===");

        // 1. Factory Method
        System.out.println("\n--- [Factory Method] ---");
        DispositivoInteligente luz = DispositivoFactory.crearDispositivo("luz");
        luz.encender();
        System.out.println("Estado: " + luz.obtenerEstado());

        // 2. Decorator
        System.out.println("\n--- [Decorator] ---");
        DispositivoInteligente luzConAhorro = new DispositivoConAhorro(luz);
        luzConAhorro.encender();
        System.out.println("Estado: " + luzConAhorro.obtenerEstado());

        // 3. Adapter
        System.out.println("\n--- [Adapter] ---");
        DispositivoLegacy aparatoViejo = new DispositivoLegacy();
        DispositivoInteligente aparatoAdaptado = new AdaptadorDispositivo(aparatoViejo);

        aparatoAdaptado.encender();
        System.out.println("Estado: " + aparatoAdaptado.obtenerEstado());
    }
}