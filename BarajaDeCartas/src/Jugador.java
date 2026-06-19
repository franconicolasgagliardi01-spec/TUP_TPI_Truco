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

    public void sumarPuntos(int puntosASumar, int maxPuntos) {
        this.puntos += puntosASumar;

        // Si los puntos sumados superan el maxPuntos de la partida, los clava en el tope
        if (this.puntos > maxPuntos) {
            this.puntos = maxPuntos;
        }
    }
//suma puntos al jugador controlando que no se pase del limite maxPuntos establecido en la clase Truco

}
