package es.codeurjc.ais;

public class Carta {

    private final String nombre;
    private final int ataque;
    private final int defensa;
    private final Posicion posicion;

    public Carta(String nombre, int ataque, int defensa, Posicion posicion) {
        this.nombre = nombre;
        this.ataque = ataque;
        this.defensa = defensa;
        this.posicion = posicion;
    }

    public int getDefensa() {
        return defensa;
    }

    public int getAtaque() {
        return ataque;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString(){
        return "Carta "+ getNombre() + " (" + getAtaque() + "/" + getDefensa() + "/"+ "Posición: "+ posicion.toString() + ")";
    }
}
