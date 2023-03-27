package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoIntermedioTest {

    @Test
    void caso8() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.ATAQUE, Efecto.INMORTAL);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: ATAQUE/Efecto: INMORTAL) vs Carta dos (2000/1500/Posición: ATAQUE/Efecto: N/A) -> " +
                "Empate. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso9() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2850, Posicion.ATAQUE, Efecto.INMORTAL);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2850/Posición: ATAQUE/Efecto: INMORTAL) vs Carta dos (2000/1500/Posición: ATAQUE/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 200 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso10() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2100, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE, Efecto.INMORTAL);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2100/2850/Posición: ATAQUE/Efecto: N/A) vs Carta dos (2000/1500/Posición: ATAQUE/Efecto: INMORTAL) -> " +
                "Gana Carta uno. Defensor pierde 100 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso11() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA, Efecto.INMORTAL);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2850/Posición: ATAQUE/Efecto: N/A) vs Carta dos (2000/1500/Posición: DEFENSA/Efecto: INMORTAL) -> " +
                "Gana Carta uno.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso12() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1000, 2850, Posicion.ATAQUE, Efecto.TOQUE_MORTAL);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1000/2850/Posición: ATAQUE/Efecto: Toque mortal) vs Carta dos (2000/1500/Posición: DEFENSA/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 500 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

}
