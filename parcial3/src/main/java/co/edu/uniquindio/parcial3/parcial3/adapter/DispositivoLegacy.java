package co.edu.uniquindio.parcial3.parcial3.adapter;

public class DispositivoLegacy {
    public void conectarSistema() {
        System.out.println("  -> [Legacy]: Sistema antiguo conectado.");
    }

    public void desconectarSistema() {
        System.out.println("  -> [Legacy]: Sistema antiguo desconectado.");
    }

    public String verEstado() {
        return "En línea (Modo Legacy)";
    }
}
