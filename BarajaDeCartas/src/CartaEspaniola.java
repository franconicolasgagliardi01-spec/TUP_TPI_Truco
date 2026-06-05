public class CartaEspaniola {

    private int numero;
    private PaloEspaniol palo;

    public CartaEspaniola(int numero, PaloEspaniol palo) {
        setNumero(numero);
        this.palo = palo;
    }

    public enum PaloEspaniol{
        ESPADA,
        ORO,
        Basto,
        COPA;
    }

    public void setNumero(int numero) {
        if (numero > 0 && numero <= 12){
            this.numero = numero;
        }
    }
}
