package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CasoInicialTest {

    @Test
    void caso1() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (1500/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Gana Carta uno. Defensor pierde 500 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso2() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1200, 1000, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1200/1000/Posición: Ataque/Efecto: N/A) vs Carta dos (1500/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 300 puntos. Carta uno destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso3() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 0, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/0/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Empate. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso4() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1501, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1501/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efecto: N/A) -> " +
                "Gana Carta uno. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso5() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 0, 3000, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (0/3000/Posición: Defensa/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 1000 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso6() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1500/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efecto: N/A) -> " +
                "Empate.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso7() {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.DEFENSA);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        Throwable excepcion = assertThrows(IllegalPositionException.class, () -> {
            String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        });
        assertEquals("La carta atacante no puede estar en una posición de Defensa", excepcion.getMessage());
    }

    @Test
    void caso7Sin2Assert() {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.DEFENSA);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        try {
            String resultado = Combate.combatir(uno, dos);
        }
        catch (IllegalPositionException exception) {
            assertEquals("La carta atacante no puede estar en una posición de Defensa", exception.getMessage());
        }
    }

}

