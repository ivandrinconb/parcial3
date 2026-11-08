package co.edu.uniquindio.parcial3.parcial3.modelo;
import java.util.ArrayList;
import java.util.List;


public class CasaInteligente {
    private List<Dispositivo> dispositivos = new ArrayList<>();
    private List<Habitacion> habitaciones = new ArrayList<>();

    public List<Dispositivo> getDispositivos() { return dispositivos; }
    public List<Habitacion> getHabitaciones() { return habitaciones; }

    public void agregarDispositivo(Dispositivo dispositivo) {
        dispositivos.add(dispositivo);
    }

    public void eliminarDispositivo(Dispositivo dispositivo) {
        dispositivos.remove(dispositivo);
    }

    public Dispositivo buscarPorNombre(String nombre) {
        for (Dispositivo d : dispositivos) {
            if (d.getNombre().equals(nombre)) {
                return d;
            }
        }
        return null;
    }

    public List<Dispositivo> buscarPorTipo(TipoDispositivo tipo) {
        List<Dispositivo> resultado = new ArrayList<>();
        for (Dispositivo d : dispositivos) {
            if (d.getTipo() == tipo) {
                resultado.add(d);
            }
        }
        return resultado;
    }

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void eliminarHabitacion(Habitacion habitacion) {
        habitaciones.remove(habitacion);
    }
}
