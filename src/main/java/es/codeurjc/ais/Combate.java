package es.codeurjc.ais;

import java.util.Optional;

public class Combate {

  private Combate() {
  }

  public static String combatir(Carta atacante, Carta defensor) {
      int puntosAtaque = atacante.getAtaque();
      int puntosDefensor = defensor.getAtaque();
      if (defensor.getPosicion() == Posicion.Defensa) {
          puntosDefensor = defensor.getDefensa();
      }

      String resultado = atacante + " vs " + defensor;
      Carta ganador = ((puntosAtaque > puntosDefensor) ? atacante : defensor);

      return "";
  }

}

