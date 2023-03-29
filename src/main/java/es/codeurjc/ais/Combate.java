package es.codeurjc.ais;

public class Combate {

    private Combate() {
    }

    public static String combatir(Carta atacante, Carta defensor) throws IllegalPositionException {
        if (atacante.getPosicion() == Posicion.DEFENSA) {
            throw new IllegalPositionException("La carta atacante no puede estar en una posición de Defensa");
        }
        int puntosAtaque = atacante.getAtaque();
        int puntosDefensor = (defensor.getPosicion() == Posicion.DEFENSA) ? defensor.getDefensa() : defensor.getAtaque();

        StringBuilder resultado = new StringBuilder();
        resultado.append(String.format("%s vs %s -> ", atacante, defensor));
        Carta ganador = ((puntosAtaque > puntosDefensor) ? atacante : (puntosAtaque == puntosDefensor) ? null : defensor);
        Carta perdedor = ((ganador == null) ? null : (atacante == ganador) ? defensor : atacante);

        if (ganador != null) { // No es empate
            resultado.append(String.format("Gana Carta %s.", ganador.getNombre()));
            int perdidaVida = Math.abs(puntosAtaque - puntosDefensor);
            if (defensor.getPosicion() == Posicion.ATAQUE) {
                resultado.append((ganador == atacante) ? " Defensor " : " Atacante ").append(String.format("pierde %d puntos.", (perdedor.presion()) ? perdidaVida / 2 : perdidaVida)).
                        append((perdedor.esInmortal()) ? "" : (atacante.toqueMortal() && defensor.getDefensa() < 2000 && !ganador.esInmortal()) ? " Ambas cartas destruidas." :
                                String.format(" Carta %s destruido/a.", perdedor.getNombre()));
            } else {
                resultado.append((ganador == defensor) ? String.format(" Atacante pierde %d puntos.", (perdedor.presion()) ? perdidaVida / 2 : perdidaVida) : "");
                resultado.append((ganador == atacante && !perdedor.esInmortal() && !atacante.esInmortal() && defensor.toqueMortal() && atacante.getDefensa() < 2000) ? " Ambas cartas destruidas." :
                        (ganador == atacante && !perdedor.esInmortal() || atacante.toqueMortal() && defensor.getDefensa() < 2000 && !defensor.esInmortal())
                        ? String.format(" Carta %s destruido/a.", defensor.getNombre()) :
                        (defensor.toqueMortal() && atacante.getDefensa() < 2000 && !atacante.esInmortal())
                        ? String.format(" Carta %s destruido/a.", atacante.getNombre())
                        :"");
            }
        } else { // Es empate
            resultado.append("Empate.");
            if(atacante.esInmortal() && defensor.esInmortal()) {
                resultado.append("");
            }else if ((defensor.getPosicion() == Posicion.ATAQUE && !atacante.esInmortal()) || (atacante.toqueMortal() && defensor.toqueMortal() && defensor.getDefensa() < 2000 && atacante.getDefensa() < 2000)) {
                resultado.append(" Ambas cartas destruidas.");
            } else if (atacante.esInmortal()) {
                resultado.append(String.format(" Carta %s destruido/a.", defensor.getNombre()));
            }
        }
        return resultado.toString();
    }

}
/*  Optional<Carta> ganador2 = Optional.ofNullable((puntosAtaque > puntosDefensor) ? atacante :
                                                    (puntosAtaque == puntosDefensor) ? null : defensor); */

