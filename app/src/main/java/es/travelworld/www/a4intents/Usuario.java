package es.travelworld.www.a4intents;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String apellido;
    private String edades;

    private ArrayList<String> opcionesEdad;

    public ArrayList<String> getOpcionesEdad() {
        return opcionesEdad;
    }

    public void setOpcionesEdad(ArrayList<String> opcionesEdad) {
        this.opcionesEdad = opcionesEdad;
    }

    public Usuario (String nombre, String apellido, String edades){
    this.nombre = nombre;
    this.apellido = apellido;
    this.edades=edades;
}

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEdades() {
        return edades;
    }

    public void setEdades(String edades) {
        this.edades = edades;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", edades='" + edades + '\'' +
                '}';
    }
}
