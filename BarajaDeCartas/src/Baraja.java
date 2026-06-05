import java.util.ArrayList;

public class Baraja<T> {
    private ArrayList<T> cartas;

    public Baraja(){
        this.cartas = new ArrayList<>();
    }

    public void barajar(){

    } //Mescla las cartas

    public T obtenerSiguiente(){
        return null;
    } //Devuelve la siguiente carta disponible

    public int cantidadDisponible(){
        return cartas.size();
    } //Devuelve la cantidad de cartas

    public ArrayList<T> repartir(int cantidad){
        return null;
    } //Devuelve una lista con cierta cantidad de cartas

    public void mostrarRepartidas(){

    } //Muestra las cartas repartidas

    public void mostrarDisponibles(){

    } //Muestra las cartas que no han sido repartidas

    public void agregarCarta(){

    } //Agrega una carta al mazo

    public void quitarCarta(){

    } //Quita una carta del mazo




}
