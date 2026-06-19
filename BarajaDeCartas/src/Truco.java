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

  public void partida() {
      crearBarajaTruco();
      Scanner sc = new Scanner(System.in);
      while (true) {
          System.out.println("--------------------¡Bienvenido al truco argentino!--------------------");
          System.out.println("Ingrese nombre jugador 1: ");
          String nombre1 = sc.nextLine();
          System.out.println("Ingrese nombre jugador 2: ");
          String nombre2 = sc.nextLine();
          Jugador<CartaEspaniola> jugador1 = new Jugador<>(nombre1);
          Jugador<CartaEspaniola> jugador2 = new Jugador<>(nombre2);
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

              jugador1.setManosGanadas(0);
              jugador2.setManosGanadas(0);
              // Limpia los estados de ganador de la ronda anterior para iniciar la primera mano desde cero
              jugador1.setGanador(false);
              jugador2.setGanador(false);

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
                  if (jugador1.getManosGanadas() == 2) {
                      break;
                  } else if (jugador2.getManosGanadas() == 2) {
                      break;
                  }
              }

              // Evalúa qué jugador tiene más manos ganadas al final de la ronda para darle el punto usando la variable maxPuntos
              if (jugador1.getManosGanadas() > jugador2.getManosGanadas()) {
                  jugador1.sumarPuntos(1, maxPuntos);
                  System.out.println("");
                  System.out.println("-------- " + jugador1.getNombre() + " gano la ronda --------");
                  System.out.println("");
                  
              } else if (jugador2.getManosGanadas() > jugador1.getManosGanadas()) {
                  jugador2.sumarPuntos(1, maxPuntos);
                  System.out.println("");
                  System.out.println("-------- " + jugador2.getNombre() + " gano la ronda --------");
                  System.out.println("");
              }
          }
          ganador(jugador1,jugador2,maxPuntos);
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

    private <T extends Carta> void jugarMano(Jugador<T> primerJugador, Jugador<T> segundoJugador) {
        Scanner sc = new Scanner(System.in);
        // Turno del primer jugador, muestra sus cartas y le pide elegir una para tirar
        System.out.println("Turno de: " + primerJugador.getNombre());
        mostrarMano((ArrayList<CartaEspaniola>) primerJugador.getCartasRepartidas());
        System.out.print("Seleccione la carta a tirar: ");
        int indice1 = Integer.parseInt(sc.nextLine());
        // Remueve la carta seleccionada de la mano del primer jugador y la guarda en una variable
        T carta1 = primerJugador.getCartasRepartidas().remove(indice1);
        // Muestra que carta tiro el jugador1
        System.out.println( primerJugador.getNombre() + " tiro un " + carta1);
        System.out.println("");
        
        // Turno del segundo jugador, muestra sus cartas y le pide elegir una para responder
        System.out.println("Turno de: " + segundoJugador.getNombre());
        mostrarMano((ArrayList<CartaEspaniola>) segundoJugador.getCartasRepartidas());
        System.out.print("Seleccione la carta a tirar: ");
        int indice2 = Integer.parseInt(sc.nextLine());
        // Remueve la carta seleccionada de la mano del segundo jugador y la guarda en otra variable
        T carta2 = segundoJugador.getCartasRepartidas().remove(indice2);
        // Muestra que carta tiro el jugador1
        System.out.println( segundoJugador.getNombre() + " tiro un " + carta2);
        System.out.println("");
        
        // Compara la jerarquía de las cartas usando el compareTo de la clase abstracta Carta
        int comparacion = carta1.compareTo(carta2);

        if (comparacion > 0) {
            // Si gana el primer jugador, se le da el turno de la próxima mano y suma una mano ganada en la ronda
            primerJugador.setGanador(true);
            segundoJugador.setGanador(false);
            primerJugador.ganarMano();
        } else if (comparacion < 0) {
            // Si gana el segundo jugador, se le da el turno de la próxima mano y suma una mano ganada en la ronda
            primerJugador.setGanador(false);
            segundoJugador.setGanador(true);
            segundoJugador.ganarMano();
        } else {
            // En caso de empardar (empate), vuelve a tirar el mismo jugador que inició la mano y ambos suman una mano ganada
            primerJugador.setGanador(true);
            segundoJugador.setGanador(false);
            primerJugador.ganarMano();
            segundoJugador.ganarMano();
        }
    }
    
  private void mostrarMano(ArrayList<CartaEspaniola> cartasJugador) {
      for (CartaEspaniola a : cartasJugador) {
          System.out.println("[" + cartasJugador.indexOf(a) +  "] "+ a);
      }
//muestra mazo de cada jugador, recibe cartas de cada jugador
  }

    private <T extends Carta> void ganador (Jugador<?> primerJugador , Jugador<?> segundoJugador , int puntosMaximos) {
      if (primerJugador.getPuntos() >= puntosMaximos) {
          System.out.println("");
          System.out.println("--------- GANO " + primerJugador.getNombre() + " ---------");
          System.out.println("");
      }
  
      if (segundoJugador.getPuntos() >= puntosMaximos) {
          System.out.println("");
          System.out.println("--------- GANO " + segundoJugador.getNombre() + " ---------");
          System.out.println("");
      }
    //anuncia jugador ganador, compara al jugador con maxPuntos
  }
}
