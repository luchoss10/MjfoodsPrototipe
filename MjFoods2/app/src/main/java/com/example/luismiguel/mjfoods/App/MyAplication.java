package com.example.luismiguel.mjfoods.App;

import android.app.Application;

import com.example.luismiguel.mjfoods.Models.Plato;
import com.example.luismiguel.mjfoods.Models.Restaurante;

import java.util.concurrent.atomic.AtomicInteger;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmObject;
import io.realm.RealmResults;

/**
 * Created by LuisMiguel on 25/09/2017.
 * Clase para la aplicacion de los parmqaateros inicales de Realm y su enumeracion y recuento para las objetos que contiene
 */

//Nuestra calse extiende de Aplication para ejecutarce de prinmera
public class MyAplication extends Application {

    //Creamos el metodo para hacer el incremento de Id que utilizara Realm en nuestro telefono
    //Revision---------------------------------------------------------------------------------------
    public static AtomicInteger RestauranteRealmID = new AtomicInteger();
    //Revision---------------------------------------------------------------------------------------
    public static AtomicInteger PlatoRealmID = new AtomicInteger();

    //Sobreescribimos el metodo onCreate para poder instanciar los procesos que necesitamos
    @Override
    public void onCreate() {
        super.onCreate();
        //Primero crearemos la configuracion predeterminada de Realm con el siguiente metodo
        setupRealmConfig();
        //Inciiamos una nueva instancia de Realm con la configuracion predeterminada que seleccionamos
        Realm realm = Realm.getDefaultInstance();
        //Establecemos los id para los objetos almacenados en Realm con el metodo getIdByTable
        RestauranteRealmID = getIdByTable(realm, Restaurante.class);
        PlatoRealmID = getIdByTable(realm, Plato.class);
        //Cerramos nuestra instancia de Realm
        realm.close();
    }

    //Metodo para la configuracion basica de el Realm
    private void setupRealmConfig() {
        //Iniciamos el Realm con el contexto de la Aplicacion
        Realm.init(getApplicationContext());
        //Creamos una nueva instancia de la configuracion y la personalizamos como queramos
        //Para al final contruirla
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        //Una vez creada la configuracion la establecemos como la predeterminada para nuestro Realm
        Realm.setDefaultConfiguration(config);
    }

    //Metodo para establecer los id de cada clase De Realm
    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("realmid").intValue()) : new AtomicInteger();
    }
}
