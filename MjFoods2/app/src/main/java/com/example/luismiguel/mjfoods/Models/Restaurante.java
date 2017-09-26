package com.example.luismiguel.mjfoods.Models;

import com.example.luismiguel.mjfoods.App.MyAplication;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;
import io.realm.annotations.Required;

/**
 * Clase para el elemento restaurante empezamos con los metodos basicos ver 0.0.1 probables cambios para obtener una ñlista de platiyos
 */

//Extiende de Realm object para poder hacer la persistencia de datos
public class Restaurante extends RealmObject {

    //Revision --------------------------------------------------------------------------------
    @PrimaryKey
    private int realmid;
    @Required
    private int id;
    @Required
    private String name;

    private RealmList<Plato> platos;

    Restaurante() {
    }

    public Restaurante(int id, String name) {
        realmid = MyAplication.RestauranteRealmID.incrementAndGet();
        this.id = id;
        this.name = name;
        this.platos = new RealmList<Plato>();
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

    public int getRealmid() {
        return realmid;
    }

}
