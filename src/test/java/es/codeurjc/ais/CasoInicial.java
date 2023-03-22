package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


public class CasoInicial {

    @Test
    public void caso1() {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.Ataque);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque) vs Carta dos (1500/1500/Posición: Ataque) -> " +
                "Gana Carta uno. Defensor pierde 500 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso2() {
        Carta uno = new Carta("uno", 1200, 1000, Posicion.Ataque);
        Carta dos = new Carta("dos", 1500, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1200/1000/Posición: Ataque) vs Carta dos (1500/1500/Posición: Ataque) -> " +
                "Gana Carta dos. Atacante pierde 300 puntos. Carta uno destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    public void caso3() {
        Carta uno = new Carta("uno", 2000, 0, Posicion.Ataque);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.Ataque);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/0/Posición: Ataque) vs Carta dos (2000/1500/Posición: Ataque) -> " +
                "Empate. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }
}

