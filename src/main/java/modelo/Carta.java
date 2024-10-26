package modelo;

public class Carta {

  private int numero;
  private String palo;

  public static final String[] PALOS = {"ESPADAS", "OROS", "COPAS", "BASTOS"};
  public static final int LIMITE_CARTA_PALO = 12;

  public Carta(int numero, String palo) {
    super();
    this.numero = numero;
    this.palo = palo;
  }


  @Override
  public String toString() {
    return "{" +
      " numero='" + this.numero+ "'" +
      ", palo='" + this.palo + "'" +
      " }";
  }
  



}
