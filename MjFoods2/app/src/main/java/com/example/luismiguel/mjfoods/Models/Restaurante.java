package com.example.luismiguel.mjfoods.Models;

/**
 * Clase para el elemento restaurante empezamos con los metodos basicos ver 0.0.1 probables cambios para obtener una ñlista de platiyos
 */

public class Restaurante {

    private int id;
    private String name;

    Restaurante() {

    }

    public Restaurante(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
