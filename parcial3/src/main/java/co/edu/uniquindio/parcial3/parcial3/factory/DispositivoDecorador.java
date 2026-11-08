package co.edu.uniquindio.parcial3.parcial3.factory;

public abstract class DispositivoDecorador implements DispositivoInteligente {
    protected DispositivoInteligente dispositivoWrappeado;

    public DispositivoDecorador(DispositivoInteligente dispositivo) {
        this.dispositivoWrappeado = dispositivo;
    }

    @Override
    public void encender() {
        dispositivoWrappeado.encender();
    }

    @Override
    public void apagar() {
        dispositivoWrappeado.apagar();
    }

    @Override
    public String obtenerEstado() {
        return dispositivoWrappeado.obtenerEstado();
    }
}