package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoIntermedioTest {

    @Test
    public void caso8() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.Ataque, Efecto.Inmortal);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: Inmortal) vs Carta dos (2000/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Empate. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso9() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2850, Posicion.Ataque, Efecto.Inmortal);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2850/Posición: Ataque/Efecto: Inmortal) vs Carta dos (2000/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Gana Carta dos. Atacante pierde 200 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso10() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2100, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque, Efecto.Inmortal);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2100/2850/Posición: Ataque/Efecto: N/A) vs Carta dos (2000/1500/Posición: Ataque/Efecto: Inmortal) -> " +
                "Gana Carta dos. Defensor pierde 100 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

}
