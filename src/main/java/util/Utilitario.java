package util;

public class Utilitario {
  // Clase utilitaria que nos genera numeros para jugadores

  /**
   * Genera numeros aleatorios entre dos rangos
   * @param minimo Numero entero minimo
   * @param maximo Numero enterio maximo
   * @return Retorna entero para uso en multiples metodos
   */
  public static int generaNumeroAleatorio(int minimo, int maximo){
    int num = (int) Math.floor(Math.random() * (maximo - minimo + 1) + minimo);
    return num;
  }
}
