public abstract class Carta implements Comparable<Carta>{
    private final int peso; //Variable que nos va a decir el peso o importancia de la carta para compararla con otras

    public Carta(int peso) {
        this.peso = peso;
    }

    @Override
    public int compareTo(Carta c){ //Funcion que compara las cartas, retorna 1 si es mayor, -1 si es menor y 0 si es igual
        if (this.peso > c.peso){
            return 1;
        } else if (this.peso < c.peso) {
            return -1;
        }
        return 0;
    }

}
