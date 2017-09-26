package com.example.luismiguel.mjfoods.Models;

import com.example.luismiguel.mjfoods.App.MyAplication;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Created by LuisMiguel on 13/09/2017.
 */

public class Plato extends RealmObject {

    //Revision------------------------------------------------------------------
    @PrimaryKey
    private int realmid;
    @Required
    private int id;
    @Required
    private String name;
    @Required
    private String categoria;

    public Plato() {
    }

    public Plato(int id, String name, String categoria) {
        realmid = MyAplication.PlatoRealmID.incrementAndGet();
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

    public int getRealmid() {
        return realmid;
    }
}
