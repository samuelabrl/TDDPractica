package es.codeurjc.ais;

public class Combate {

    static Carta ganador, perdedor;
    static String posicionamiento, resultado;
    static boolean empate;

    public static String combatir(Carta carta1, Carta carta2) {
        resultado(carta1,carta2);
        if (!empate) {
            resultado = "Gana Carta " + ganador.getNombre() +
                    ". "+ posicionamiento +" pierde " + (ganador.getAtaque() - perdedor.getAtaque()) +
                    " puntos. Carta " + perdedor.getNombre() + " destruido/a.";
        }
        else{
            resultado = "Empate. Ambas cartas destruidas.";
        }
        return  carta1 + " vs " + carta2 + " -> " + resultado;
    }

    private static void resultado(Carta carta1, Carta carta2) {
        if (carta1.getAtaque() > carta2.getAtaque()) {
            ganador = carta1;
            perdedor = carta2;
            posicionamiento = "Defensor";
        }
        else if (carta1.getAtaque() < carta2.getAtaque()){
            ganador = carta2;
            perdedor = carta1;
            posicionamiento = "Atacante";
        }
        else {
            empate = true;
        }
    }

}

