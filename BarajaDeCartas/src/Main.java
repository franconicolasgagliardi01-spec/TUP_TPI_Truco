import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        System.out.println("=================================================");
        System.out.println("     TP BARAJA DE CARTAS ESPAÑOLAS - UTN FRM     ");
        System.out.println("=================================================\n");

        // 1. Instanciar la baraja genérica especificando que es de CartaEspaniola
        Baraja<CartaEspaniola> mazo = new Baraja<>();

        // 2. Inicializar el mazo con las 40 cartas reglamentarias (excluyendo 8 y 9)
        for (CartaEspaniola.PaloEspaniol palo : CartaEspaniola.PaloEspaniol.values()) {
            for (int num = 1; num <= 12; num++) {
                if (num != 8 && num != 9) {
                    mazo.agregarCarta(new CartaEspaniola(num, palo));
                }
            }
        }

        // 3. Mostrar estado inicial del mazo
        System.out.println("--- ESTADO INICIAL DEL MAZO ---");
        System.out.println("Cantidad de cartas disponibles: " + mazo.cantidadDisponible());
        mazo.mostrarDisponibles();
        System.out.println();

        // 4. Probar el método mostrarRepartidas cuando todavía está vacío
        System.out.println("--- COMPROBACIÓN DE CARTAS REPARTIDAS AL INICIO ---");
        mazo.mostrarRepartidas();
        System.out.println();

        // 5. Barajar (Mezclar las cartas)
        System.out.println("--- BARAJAR EL MAZO ---");
        System.out.println("Mezclando cartas de forma aleatoria...");
        mazo.barajar();
        System.out.println("Mazo mezclado con éxito.\n");

        // 6. Mostrar el mazo mezclado para verificar el cambio de orden
        System.out.println("--- MAZO MEZCLADO (DISPONIBLES) ---");
        mazo.mostrarDisponibles();
        System.out.println();

        // 7. Repartir una mano de cartas (Por ejemplo, 5 cartas)
        int cartasARepartir = 5;
        System.out.println("--- REPARTIENDO " + cartasARepartir + " CARTAS ---");
        ArrayList<CartaEspaniola> manoJugador = mazo.repartir(cartasARepartir);

        if (manoJugador != null) {
            System.out.println("Cartas recibidas por el jugador en mano:");
            for (CartaEspaniola carta : manoJugador) {
                System.out.println("[ " + carta + " ]");
            }
        }
        System.out.println();

        // 8. Consultar cantidad disponible después del primer reparto
        System.out.println("--- CONTROL DE STOCK DEL MAZO ---");
        System.out.println("Cartas que quedan en el mazo: " + mazo.cantidadDisponible());
        System.out.println();

        // 9. Mostrar el estado de ambos montones (Disponibles vs Repartidas)
        System.out.println("--- REVISIÓN DE AMBOS MONTONES ---");
        mazo.mostrarRepartidas();
        System.out.println();
        System.out.println("Cantidad de cartas en el mazo: " + mazo.cantidadDisponible());
        System.out.println("----------------------------------");
        mazo.mostrarDisponibles();
        System.out.println();

        // 10. Forzar el caso de error intentando pedir más cartas de las que quedan
        // Quedan 35 cartas disponibles (40 - 5). Si pedimos 36, debería fallar.
        int excesoCartas = 36;
        System.out.println("--- PRUEBA DE CONTROL DE ERRORES (REPARTIR EN EXCESO) ---");
        System.out.println("Intentando repartir " + excesoCartas + " cartas...");
        ArrayList<CartaEspaniola> manoFallida = mazo.repartir(excesoCartas);

        if (manoFallida == null) {
            System.out.println("Resultado: El sistema manejó el error correctamente devolviendo null.");
        }
        System.out.println();

        // 11. Volver a barajar para verificar que las cartas repartidas regresen al mazo
        System.out.println("--- REINICIANDO Y VOLVIENDO A BARAJAR ---");
        System.out.println("Al barajar de nuevo, las " + cartasARepartir + " cartas repartidas deben volver al mazo.");
        mazo.barajar();
        System.out.println("Cantidad de cartas disponibles post-mezcla: " + mazo.cantidadDisponible());
        System.out.println("=================================================");
    }
}