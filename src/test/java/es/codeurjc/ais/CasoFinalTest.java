package es.codeurjc.ais;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CasoFinalTest {
    @Test
    void caso18() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1800, 2900, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION});
        Carta dos = new Carta("dos", 2000, 1500, Posicion.ATAQUE);

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (1800/2900/Posición: Ataque/Efectos: Inmortal, Presión) vs Carta dos (2000/1500/Posición: Ataque/Efectos: N/A) -> " +
                "Gana Carta dos. Atacante pierde 100 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

    @Test
    void caso19() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1900, 2000, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (1900/2000/Posición: Ataque/Efectos: Presión) vs Carta dos (3000/1000/Posición: Defensa/Efectos: Toque mortal) -> " +
                "Gana Carta uno. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso20() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1900, 2000, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.INMORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (1900/2000/Posición: Ataque/Efectos: Presión) vs Carta dos (3000/1000/Posición: Defensa/Efectos: Toque mortal, Inmortal) -> " +
                "Gana Carta uno.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso21() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1900, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.INMORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (1900/1800/Posición: Ataque/Efectos: Presión) vs Carta dos (3000/1000/Posición: Defensa/Efectos: Toque mortal, Inmortal) -> " +
                "Gana Carta uno. Carta uno destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }

   @Test
    void caso22() throws IllegalPositionException {
        Carta uno = new Carta("uno", 1900, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.PRESION, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (1900/1800/Posición: Ataque/Efectos: Presión, Inmortal) vs Carta dos (3000/1000/Posición: Defensa/Efectos: Toque mortal) -> " +
                "Gana Carta uno. Carta dos destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso23() throws IllegalPositionException {
        Carta uno = new Carta("uno", 600, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (600/1800/Posición: Ataque/Efectos: Toque mortal, Inmortal) vs Carta dos (3000/1000/Posición: Ataque/Efectos: Inmortal) -> " +
                "Gana Carta dos. Atacante pierde 2400 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso24() throws IllegalPositionException {
        Carta uno = new Carta("uno", 600, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (600/1800/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (3000/1000/Posición: Ataque/Efectos: Inmortal) -> " +
                "Gana Carta dos. Atacante pierde 2400 puntos. Carta uno destruido/a.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso25() throws IllegalPositionException {
        Carta uno = new Carta("uno", 6000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (6000/1800/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (3000/1000/Posición: Ataque/Efectos: Inmortal) -> " +
                "Gana Carta uno. Defensor pierde 3000 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso26() throws IllegalPositionException {
        Carta uno = new Carta("uno", 6000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (6000/1800/Posición: Ataque/Efectos: Toque mortal) vs Carta dos (3000/1000/Posición: Ataque/Efectos: Inmortal, Presión) -> " +
                "Gana Carta uno. Defensor pierde 1500 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso27() throws IllegalPositionException {
        Carta uno = new Carta("uno", 6000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.PRESION, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION, Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (6000/1800/Posición: Ataque/Efectos: Toque mortal, Presión, Inmortal) vs Carta dos (3000/1000/Posición: Ataque/Efectos: Inmortal, Presión, Toque mortal) -> " +
                "Gana Carta uno. Defensor pierde 1500 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso28() throws IllegalPositionException {
        Carta uno = new Carta("uno", 3000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.PRESION, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 6000, 1000, Posicion.ATAQUE, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION, Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (3000/1800/Posición: Ataque/Efectos: Toque mortal, Presión, Inmortal) vs Carta dos (6000/1000/Posición: Ataque/Efectos: Inmortal, Presión, Toque mortal) -> " +
                "Gana Carta dos. Atacante pierde 1500 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso29() throws IllegalPositionException {
        Carta uno = new Carta("uno", 6000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.PRESION, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 3000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION, Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (6000/1800/Posición: Ataque/Efectos: Toque mortal, Presión, Inmortal) vs Carta dos (3000/1000/Posición: Defensa/Efectos: Inmortal, Presión, Toque mortal) -> " +
                "Gana Carta uno. Defensor pierde 1500 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }
    @Test
    void caso30() throws IllegalPositionException {
        Carta uno = new Carta("uno", 3000, 1800, Posicion.ATAQUE, new Efecto[]{Efecto.TOQUE_MORTAL, Efecto.PRESION, Efecto.INMORTAL});
        Carta dos = new Carta("dos", 6000, 1000, Posicion.DEFENSA, new Efecto[]{Efecto.INMORTAL, Efecto.PRESION, Efecto.TOQUE_MORTAL});

        String resultado = Combate.combatir(uno, dos);
        String resultadoEsperado = "Carta uno (3000/1800/Posición: Ataque/Efectos: Toque mortal, Presión, Inmortal) vs Carta dos (6000/1000/Posición: Defensa/Efectos: Inmortal, Presión, Toque mortal) -> " +
                "Gana Carta dos. Atacante pierde 1500 puntos.";

        assertEquals(resultadoEsperado, resultado);
    }

}
