package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoIntermedioTest {

    @Test
    void caso8() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 2850, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/2850/Posición: Ataque/Efectos: Inmortal) vs Carta dos (2000/1500/Posición: Ataque/Efectos: N/A) -> " +
                "Empate. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso9() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2850, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2850/Posición: Ataque/Efectos: Inmortal) vs Carta dos (2000/1500/Posición: Ataque/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 200 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso10() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2100, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2100/2850/Posición: Ataque/Efectos: N/A) vs Carta dos (2000/1500/Posición: Ataque/Efectos: Inmortal) -> " +
                "Gana Carta uno. Defensor pierde 100 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso11() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2850, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA, new Efecto[]{Efecto.INMORTAL});

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1800/2850/Posición: Ataque/Efectos: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efectos: Inmortal) -> " +
                "Gana Carta uno.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso12() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1000, 2850, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1000/2850/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (2000/1500/Posición: Defensa/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 500 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso13() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 1000, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 2000, 1500, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL});

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/1000/Posición: Ataque/Efectos: N/A) vs Carta dos (2000/1500/Posición: Defensa/Efectos: Toque mortal) -> " +
                "Gana Carta uno. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso14() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 0, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL});

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1000/1000/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (0/1000/Posición: Defensa/Efectos: Toque mortal) -> " +
                "Empate. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso15() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1500, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1500/1000/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (2000/1500/Posición: Ataque/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 500 puntos. Ambas cartas destruidas.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso16() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1000, 0, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION});
        Carta dos = new Carta("dos", 0, 3000, Posicion.DEFENSA);

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (1000/0/Posición: Ataque/Efectos: Presión) vs Carta dos (0/3000/Posición: Defensa/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 1000 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso17() throws IllegalPositionException {
        Carta uno = new Carta("uno", 2000, 0, Posicion.ATAQUE);
        Carta dos = new Carta("dos", 1500, 0, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION});

        String resultado= Combate.combatir(uno, dos); //arg1: atacante, arg2: defenso
        String resultadoEsperado = "Carta uno (2000/0/Posición: Ataque/Efectos: N/A) vs Carta dos (1500/0/Posición: Ataque/Efectos: Presión) -> " +
                "Gana Carta uno. Defensor pierde 250 puntos. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

}
