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
 */

public class MyAplication extends Application {

    public static AtomicInteger RestauranteRealmID = new AtomicInteger();
    public static AtomicInteger PlatoRealmID = new AtomicInteger();


    @Override
    public void onCreate() {
        super.onCreate();
        setupRealmConfig();
        Realm realm = Realm.getDefaultInstance();
        RestauranteRealmID = getIdByTable(realm, Restaurante.class);
        PlatoRealmID = getIdByTable(realm, Plato.class);
        realm.close();
    }

    private void setupRealmConfig() {
        Realm.init(getApplicationContext());
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
        Realm.setDefaultConfiguration(config);
    }

    private <T extends RealmObject> AtomicInteger getIdByTable(Realm realm, Class<T> anyClass) {
        RealmResults<T> results = realm.where(anyClass).findAll();
        return (results.size() > 0) ? new AtomicInteger(results.max("realmid").intValue()) : new AtomicInteger();
    }
}
