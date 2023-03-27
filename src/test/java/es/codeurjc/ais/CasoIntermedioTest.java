package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoIntermedioTest {

    @Test
    public void caso8() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.Ataque, Efecto.Inmortal);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efecto: Inmortal) vs Carta dos (1500/1500/Posición: Ataque/Efecto: N/A) -> " +
                "Empate. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

}
