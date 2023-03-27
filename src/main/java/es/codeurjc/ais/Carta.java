package es.codeurjc.ais;

public class Carta {

    private final String nombre;
    private final int ataque;
    private final int defensa;
    private final Posicion posicion;
    private final Efecto efecto;

    public Carta(String nombre, int ataque, int defensa, Posicion posicion) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
        this.efecto = null;
    }

    public Carta(String nombre, int ataque, int defensa, Posicion posicion, Efecto efecto) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
        this.efecto = efecto;
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

    public Efecto getEfecto() {
        return this.efecto;
    }

    public boolean esInmortal() {
        return this.efecto == Efecto.INMORTAL;
    }

    public boolean toqueMortal() {
        return this.efecto == Efecto.TOQUE_MORTAL;
    }

    public boolean presion() {
        return this.efecto == Efecto.PRESION;
    }

    @Override
    public String toString(){
        return "Carta "+ getNombre() + " (" + getAtaque() + "/" + getDefensa() + "/" +
                "Posición: " + posicion.toString() + "/Efecto: " + ((efecto == null) ? "N/A" : efecto.toString()) + ")";
    }
}
