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
}
