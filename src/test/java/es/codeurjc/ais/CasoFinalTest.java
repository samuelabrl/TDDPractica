package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoFinalTest {
    @Test
    void caso18() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2900, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.INMORTAL, Efecto.PRESION});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado = Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2900/Posición: Ataque/Efectos: Toque mortal, Inmortal, Presión) vs Carta dos (2000/1500/Posición: Ataque/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 200 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
}
