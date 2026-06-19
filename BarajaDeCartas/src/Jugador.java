import java.util.ArrayList;

public class Jugador <T extends Carta> {
    private boolean ganador = false;
    private int puntos;
    private String nombre;
    private ArrayList <T> cartasRepartidas = new ArrayList<>();
    private int manosGanadas;


    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPuntos() {
        return puntos;
    }

    public ArrayList<T> getCartasRepartidas() {
        return cartasRepartidas;
    }

    public void setCartasRepartidas(ArrayList<T> cartasRepartidas) {
        this.cartasRepartidas = cartasRepartidas;
    }

    public int getManosGanadas() {
        return this.manosGanadas;
    }

    public void setManosGanadas(int manosGanadas) {
        this.manosGanadas = manosGanadas;
    }

    public void ganarMano() {
        this.manosGanadas++;
    }

    public boolean isGanador() {
        return ganador;
    }

    public void setGanador(boolean ganador) {
        this.ganador = ganador;
    }
}
