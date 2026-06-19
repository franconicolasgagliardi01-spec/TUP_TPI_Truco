import java.util.ArrayList;

public class Jugador <T extends Carta> {
    private boolean ganador = false;
    private int puntos;
    private String nombre;
    private ArrayList <T> cartasRepartidas = new ArrayList<>();

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setCartasRepartidas(ArrayList<T> cartasRepartidas) {
        this.cartasRepartidas = cartasRepartidas;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
}
