package es.codeurjc.ais;

public enum Efecto {
    INMORTAL("Inmortal"),
    TOQUE_MORTAL("Toque mortal"),
    PRESION("Presión");

    private final String nombre;

    // Constructor para setear el string
    Efecto(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return this.nombre;
    }
}
