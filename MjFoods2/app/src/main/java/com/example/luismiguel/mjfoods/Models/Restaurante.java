package com.example.luismiguel.mjfoods.Models;

import java.util.List;

/**
 * Clase para el elemento restaurante empezamos con los metodos basicos ver 0.0.1 probables cambios para obtener una ñlista de platiyos
 */

public class Restaurante {

    private int id;
    private String name;
    private List<Plato> platos;

    Restaurante() {

    }

    public Restaurante(int id, String name, List<Plato> platos) {
        this.id = id;
        this.name = name;
        this.platos = platos;
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

    public List<Plato> getPlatos() {
        return platos;
    }

    public void setPlatos(List<Plato> platos) {
        this.platos = platos;
    }
}
