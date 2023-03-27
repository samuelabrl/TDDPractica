package es.codeurjc.ais;

import java.util.Optional;

public class Combate {

  private Combate() {
  }

  public static String combatir(Carta atacante, Carta defensor) throws IllegalPositionException {
      if (atacante.getPosicion() == Posicion.Defensa) {
          throw new IllegalPositionException("La carta atacante no puede estar en una posición de Defensa");
      }
      int puntosAtaque = atacante.getAtaque();
      int puntosDefensor = (defensor.getPosicion() == Posicion.Defensa) ? defensor.getDefensa() : defensor.getAtaque();
      boolean atacanteInmortal = atacante.getEfecto() == Efecto.Inmortal;

      StringBuilder resultado = new StringBuilder();
      resultado.append(String.format("%s vs %s -> ", atacante, defensor));
      Carta ganador = ((puntosAtaque > puntosDefensor) ? atacante : (puntosAtaque == puntosDefensor) ? null : defensor);
      Carta perdedor = ((ganador == null) ? null : (atacante == ganador) ? defensor : atacante);

      if (ganador != null) { // No es empate
          resultado.append(String.format("Gana Carta %s. ", ganador.getNombre()));
          int perdidaVida = Math.abs(puntosAtaque - puntosDefensor);
          if (defensor.getPosicion() == Posicion.Ataque) {
              resultado.append((ganador == atacante) ? "Defensor " : "Atacante ").append(String.format("pierde %d puntos.", perdidaVida)).
                      append((atacanteInmortal && perdedor == atacante) ? "" : String.format(" Carta %s destruido/a.", perdedor.getNombre()));
          }
          else {
              resultado.append((ganador == defensor) ? String.format("Atacante pierde %d puntos", perdidaVida) :
                      String.format("Carta %s destruido/a", defensor.getNombre()));
          }
      }
      else { // Es empate
          resultado.append("Empate.").append((defensor.getPosicion() == Posicion.Ataque && !atacanteInmortal) ? " Ambas cartas destruidas." :
                  (atacanteInmortal) ? String.format(" Carta %s destruido/a.", defensor.getNombre()) : "");
      }
      return resultado.toString();
  }

}

//RESULTADO =
//Gana X - Empate
//? X pierde puntos
//? Carta X destruida - ?Ambas Cartas Destruidas

/*  Optional<Carta> ganador2 = Optional.ofNullable((puntosAtaque > puntosDefensor) ? atacante :
                                                    (puntosAtaque == puntosDefensor) ? null : defensor);
      resultado.append(ganador2.map(carta -> {return "Gana carta" + carta.getNombre();}).orElseGet(() -> {return "Empate";}));
 */
