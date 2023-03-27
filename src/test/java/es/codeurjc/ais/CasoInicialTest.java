package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CasoInicialTest {

    @Test
    public void caso1() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (1500/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Gana Carta uno. Defensor pierde 500 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso2() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1200, 1000, Posicion.Ataque);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1200/1000/Posición: Ataque/Efecto: N/A) vs Carta dos (1500/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 300 puntos. Carta uno destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso3() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 0, Posicion.Ataque);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/0/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Empate. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso4() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1501, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Defensa);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1501/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efecto: N/A) -> " +
                "Gana Carta uno. Carta dos destruido/a";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso5() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 0, 3000, Posicion.Defensa);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (0/3000/Posición: Defensa/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 1000 puntos";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso6() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Defensa);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1500/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efecto: N/A) -> " +
                "Empate.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso7() {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.Defensa);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Defensa);

        Throwable excepcion = assertThrows(IllegalPositionException.class, () -> {
            String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        });
        assertEquals("La carta atacante no puede estar en una posición de Defensa", excepcion.getMessage());
    }

    @Test
    public void caso7Sin2Assert() {
        Carta uno = new Carta("uno", 1500, 2850, Posicion.Defensa);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Defensa);

        try {
            String resultado = Combate.combatir(uno, dos);
        }
        catch (IllegalPositionException exception) {
            assertEquals("La carta atacante no puede estar en una posición de Defensa", exception.getMessage());
        }
    }

}

