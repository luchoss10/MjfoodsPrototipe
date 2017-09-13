package com.example.luismiguel.mjfoods.Models;

/**
 * Created by LuisMiguel on 13/09/2017.
 */

public class Plato {

    private int id;
    private String name;
    private String categoria;

    public Plato() {
    }

    public Plato(int id, String name, String categoria) {
        this.id = id;
        this.name = name;
        this.categoria = categoria;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
