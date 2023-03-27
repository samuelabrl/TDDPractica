package es.codeurjc.ais;

public enum Posicion {
    ATAQUE("Ataque"),
    DEFENSA("Defensa");

    private final String nombre;

    // Constructor para setear el string
    Posicion(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
