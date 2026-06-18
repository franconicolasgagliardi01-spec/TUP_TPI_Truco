public class CartaEspaniola extends Carta{
    private int numero;
    private PaloEspaniol palo;

    public CartaEspaniola(int peso, int numero, PaloEspaniol palo) {
        super(peso);
        setNumero(numero);
        this.palo = palo;
    }

    public enum PaloEspaniol{
        ESPADA,
        ORO,
        BASTO,
        COPA;
    }

    public void setNumero(int numero) {
        if (numero > 0 && numero <= 12){
            this.numero = numero;
        }
    }

    @Override
    public String toString() {
        return  numero + " de " + palo;
    }
    
    
    
}
