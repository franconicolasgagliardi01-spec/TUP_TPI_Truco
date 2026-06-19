import java.util.ArrayList;
import java.util.Scanner;

public class Truco {
    private Baraja<CartaEspaniola> baraja = new Baraja<>();

    public void crearBarajaTruco() { // Funcion que se encarga de crear la baraja
        for (CartaEspaniola.PaloEspaniol palo : CartaEspaniola.PaloEspaniol.values()) { // Con values() vario en funcion de los palos
            for (int i = 1; i <= 12; i++) { // Vario de 1 al 12
                if (i == 8 || i == 9) continue; // Salteo 8 y 9

                int peso = obtenerPeso(i, palo); // Obtengo el peso de la carta
                baraja.agregarCarta(new CartaEspaniola(peso, i, palo)); // La agrego a la baraja
            }
        }
    }

    private static int obtenerPeso(int numero, CartaEspaniola.PaloEspaniol palo) { // Funcion encargada de asignar los pesos en base a las reglas del truco
        switch (numero) {
            case 1:
                if (palo == CartaEspaniola.PaloEspaniol.ESPADA) return 14; // 1 de espada
                if (palo == CartaEspaniola.PaloEspaniol.BASTO) return 13; // 1 de basto
                return 8; // Resto de 1
            case 2:
                return 9; // Los 2
            case 3:
                return 10; // Los 3
            case 4:
                return 1; // Los 4
            case 5:
                return 2; // Los 5
            case 6:
                return 3; // Los 6
            case 7:
                if (palo == CartaEspaniola.PaloEspaniol.ESPADA) return 12; // 7 de espada
                if (palo == CartaEspaniola.PaloEspaniol.ORO) return 11; // 7 de oro
                return 4; // Resto de 7
            case 10:
                return 5; // Los 10
            case 11:
                return 6; // Los 11
            case 12:
                return 7; // Los 12
            default:
                return 0; // Por si falla
        }
    }

  public void jugar() {
      Scanner sc = new Scanner(System.in);
      while (true) {
          System.out.println("--------------------¡Bienvenido al truco argentino!--------------------");
          System.out.println("Ingrese nombre jugador 1: ");
          String nombre1 = sc.nextLine();
          System.out.println("Ingrese nombre jugador 2: ");
          String nombre2 = sc.nextLine();
          Jugador jugador1 = new Jugador(nombre1);
          Jugador jugador2 = new Jugador(nombre2);
          int maxPuntos;


          do {
              System.out.println("Ingrese la cantidad total de puntos para ganar la partida: ");
               maxPuntos =Integer.parseInt(sc.nextLine());
          } while (maxPuntos <= 0);

          while (jugador1.getPuntos() < maxPuntos && jugador2.getPuntos() < maxPuntos) {
              System.out.println("Mezclando...");
              baraja.barajar();
              System.out.println("Repartiendo...");
              jugador1.setCartasRepartidas(baraja.repartir(3));
              jugador2.setCartasRepartidas(baraja.repartir(3));
              int manosGanadasJugador1 = 0;
              int manosGanadasJugador2 = 0;

              for (int manos = 0; manos <= 2; manos++) {
                  if (jugador1.isGanador() == false && jugador2.isGanador() == false) {
                      //primer mano, empieza jugador1
                      jugarMano(jugador1, jugador2);
                  } else if (jugador1.isGanador() == true && jugador2.isGanador() == false) {
                      //comienza jugador1
                      jugarMano(jugador1, jugador2);
                  } else if (jugador1.isGanador() == false && jugador2.isGanador() == true) {
                      //comienza jugador2
                      jugarMano(jugador2, jugador1);
                  }
              }
          }
          ganador();
          String opcion;
          do {
              System.out.println("¿Desea volver a jugar? S/N");
              opcion = sc.nextLine();
          }
          while (! opcion.equalsIgnoreCase("S") && ! opcion.equalsIgnoreCase("N"));

          if (opcion.equalsIgnoreCase("N")) {
              break;
          }
      }

  }

  private void jugarMano(Jugador<?> primerJugador, Jugador<?> segundoJugador) {
        //primerJugador comienza la mano
  }

  private void mostrarMano(ArrayList<CartaEspaniola> cartasJugador) {
        //muestra mazo de cada jugador, recibe cartas de cada jugador
  }

  private int envido(ArrayList<CartaEspaniola> cartasJugador1, ArrayList<CartaEspaniola> cartasJugador2) {
        return 0; // recibe cartas de los dos jugadores, devuelve 1 si gana jugador1 o 2 si gana jugador2
      //armar compareTo para lógica envido (sugerencia)
  }

  private void ganador () {
      //anuncia jugador ganador, compara al jugador con maxPuntos
  }

}
