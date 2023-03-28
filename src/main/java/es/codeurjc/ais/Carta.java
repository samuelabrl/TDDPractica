package es.codeurjc.ais;

public class Carta {

    private final String nombre;
    private final int ataque;
    private final int defensa;
    private final Posicion posicion;
    private final Efecto[] efectos;

    public Carta(String nombre, int ataque, int defensa, Posicion posicion) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
        this.efectos = null;
    }

    public Carta(String nombre, int ataque, int defensa, Posicion posicion, Efecto[] efectos) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
        this.efectos = efectos;
    }

    public int getDefensa() {
        return this.defensa;
    }

    public int getAtaque() {
        return this.ataque;
    }

    public String getNombre() {
        return this.nombre;
    }

    public Posicion getPosicion() {
        return this.posicion;
    }

    public Efecto[] getEfectos() {
        return this.efectos;
    }

    public boolean esInmortal() {
        if (this.efectos != null) {
            for (int j = 0; j < this.efectos.length; j++) {
                if (this.efectos[j] == Efecto.INMORTAL) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean toqueMortal() {
        if (this.efectos != null) {
            for (int j = 0; j < this.efectos.length; j++) {
                if (this.efectos[j] == Efecto.TOQUE_MORTAL) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean presion() {
        if (this.efectos != null) {
            for (int j = 0; j < this.efectos.length; j++) {
                if (this.efectos[j] == Efecto.PRESION) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Carta " + getNombre() + " (" + getAtaque() + "/" + getDefensa() + "/" +
                "Posición: " + posicion.toString() + "/Efectos: " + ((efectos == null) ? "N/A" : stringEfectos()) + ")";
    }

    private String stringEfectos() {
        String cadenaEfectos = "";
        for (int i = 1; i < efectos.length; i++) {
            cadenaEfectos += efectos[i-1].toString() + ", ";
        }
        cadenaEfectos +=efectos[efectos.length-1].toString();
        return cadenaEfectos;

    }
}
