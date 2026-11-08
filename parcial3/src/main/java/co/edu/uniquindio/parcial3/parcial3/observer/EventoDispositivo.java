package co.edu.uniquindio.parcial3.parcial3.observer;

import co.edu.uniquindio.parcial3.parcial3.modelo.Dispositivo;

import java.time.LocalDateTime;

public class EventoDispositivo {
    private Dispositivo origen;
    private TipoEvento tipo;
    private String mensaje;
    private LocalDateTime fecha;

    public EventoDispositivo(Dispositivo origen, TipoEvento tipo, String mensaje) {
        this.origen = origen;
        this.tipo = tipo;
        this.mensaje = mensaje;
        this.fecha = LocalDateTime.now();
    }

    public Dispositivo getOrigen() { return origen; }
    public TipoEvento getTipo() { return tipo; }
    public String getMensaje() { return mensaje; }
    public LocalDateTime getFecha() { return fecha; }
}
