package es.ieslavereda.myapplication;

public class Usuario {
    private String nombre;
    private String apellidos;

    public Usuario(String nombre, String apellidos) {
        this.nombre = nombre;
        this.apellidos = apellidos;
    }

    @Override
    public String toString() {
        return apellidos + ", " + nombre;
    }
}
