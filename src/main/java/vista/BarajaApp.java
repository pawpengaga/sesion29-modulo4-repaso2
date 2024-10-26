package vista;

import modelo.Baraja;
import modelo.Carta;

public class BarajaApp {
  public static void main(String[] args) {
    // Creamos la baraja
    Baraja b = new Baraja();

    // Mostrar las cartas disponibles (40)
    System.out.println("Hay " + b.cartasDisponibles() + " cartas disponibles.");

    // Sacar una carta
    b.siguienteCarta();

    // Sacar 2 cartas
    b.darCartas(2);
    System.out.println("Hay " + b.cartasDisponibles() + " cartas disponibles.");

    System.out.println("CARTAS SACADAS A ESTE MOMENTO");
    b.cartasMonton();

    // Barajar cartas
    b.barajar();

    // Pedir cartas
    Carta[] c = b.darCartas(5);
    System.out.println("CARTAS SACADAS DESPUES DE BARAJAR");
    for (int i = 0; i < c.length; i++) {
      System.out.println(c[i]);
    }
  }
}
