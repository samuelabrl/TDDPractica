package es.codeurjc.ais;

import java.util.Optional;

public class Combate {

  private Combate() {
  }

  public static String combatir(Carta atacante, Carta defensor) {
      boolean destruido = false;
      boolean perdidaPuntos = false;
      int puntosAtaque = atacante.getAtaque();
      int puntosDefensor = defensor.getAtaque();
      if (defensor.getPosicion() == Posicion.Defensa) {
          puntosDefensor = defensor.getDefensa();
      }

      StringBuilder resultado = new StringBuilder();
      resultado.append(atacante).append(" vs ").append(defensor).append(" -> ");
      Carta ganador = ((puntosAtaque > puntosDefensor) ? atacante : (puntosAtaque == puntosDefensor) ? null : defensor);
      Carta perdedor = ((ganador == null) ? null : (atacante == ganador) ? defensor : atacante);

      if (ganador == null) {
          resultado.append("Empate");
      }
      else {
          resultado.append("Gana carta ").append(ganador.getNombre());
      }

      return resultado.toString() + ((perdidaPuntos) ? "Hola" : "") + ((destruido) ? "Hola" : "\n");
  }

}

/*  Optional<Carta> ganador2 = Optional.ofNullable((puntosAtaque > puntosDefensor) ? atacante :
                                                    (puntosAtaque == puntosDefensor) ? null : defensor);
      resultado.append(ganador2.map(carta -> {return "Gana carta" + carta.getNombre();}).orElseGet(() -> {return "Empate";}));
 */
