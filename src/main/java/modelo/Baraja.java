package modelo;
import java.time.format.SignStyle;

import util.Utilitario;

public class Baraja {

  private Carta cartas[];
  private int siguienteCarta;

  public static final int NUM_CARTAS = 40;

  public Baraja(){
    this.cartas = new Carta[NUM_CARTAS];
    this.siguienteCarta = 0;
  }

  // Creamos la baraja (mazo)
  private void crearBaraja(){
    String[] palos = Carta.PALOS;
    // Recorrer los palos
    for (int i = 0; i < palos.length; i++) {
      // Recorrer los numeros
      for (int j = 0; j < Carta.LIMITE_CARTA_PALO; j++) {
        // Las posiciones 8 y 9 no van
        if(!(j == 7 || j == 8)){
          if( j >= 9 ){
            cartas[((i*(Carta.LIMITE_CARTA_PALO - 2)) + (j -2))] = new Carta((j + 1), palos[i]);
          } else {
            cartas[((i*(Carta.LIMITE_CARTA_PALO - 2)) + (j))] = new Carta((j + 1), palos[i]);
          }
        }
      }
    }
  }

  // Barajar todas las cartas
  public void barajar(){
    int posAleatoria;
    Carta c;

    // Recorremos las cartas
    for (int i = 0; i < cartas.length; i++) {
      posAleatoria = Utilitario.generaNumeroAleatorio(0, NUM_CARTAS-1);
      c = cartas[i];
      cartas[i] = cartas[posAleatoria];
      cartas[posAleatoria] = c;
    }
    // Reinicia la posicion
    this.siguienteCarta = 0;
  }

  public Carta siguienteCarta(){
    Carta c = null;
    if(siguienteCarta == NUM_CARTAS){
      System.out.println("YA NO HAY MAS CARTAS. BARAJA DE NUEVO");
    } else {
      c = cartas[siguienteCarta++];
    }
    return c;
  }

  public Carta[] darCartas(int numCartas){
    if(numCartas > NUM_CARTAS){
      System.out.println("NO SE PUEDEN DAR MAS CARTAS DE LAS QUE HAY.");
    } else if (NUM_CARTAS - siguienteCarta < numCartas) {
      System.out.println("NO HAY SUFICIENTES CARTAS QUE MOSTRAR");
    } else {
      Carta[] cartasDar = new Carta[numCartas];
      for (int i = 0; i < cartasDar.length; i++) {
        cartasDar[i] = siguienteCarta();
      }
      return cartasDar;
    }
    return null;
  }

  // Muestra las cartas que ya han salido
  public void cartasMonton(){
    if((NUM_CARTAS - siguienteCarta) == NUM_CARTAS){
      System.out.println("NO SE HA SACADO NINGUNA CARTA.");
    } else {
      // Recorre de 0 hasta siguiente carta
      for (int i = 0; i < siguienteCarta; i++) {
        System.out.println(cartas[i]);
      }
    }
  }

  // Muestra las cartas que aun no han salido
  public void mostrarBaraja(){
    if((NUM_CARTAS - siguienteCarta) ==0){
      System.out.println("No hay cartas que mostrar");
    } else {
      for (int i = siguienteCarta; i < cartas.length; i++) {
        System.out.println(cartas[i]);
      }
    }
  }

}
