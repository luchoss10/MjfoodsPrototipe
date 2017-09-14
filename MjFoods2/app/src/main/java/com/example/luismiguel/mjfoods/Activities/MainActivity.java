package com.example.luismiguel.mjfoods.Activities;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.luismiguel.mjfoods.Fragments.CategoriasFragment;
import com.example.luismiguel.mjfoods.Fragments.InicioFragment;
import com.example.luismiguel.mjfoods.Fragments.OfertasFragment;
import com.example.luismiguel.mjfoods.Fragments.OpcionesFragment;
import com.example.luismiguel.mjfoods.R;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    //Instanciamos el drawer layout y el navigationview para el control de los eventos del menu de nustro equipo
    //Los elmentos de cada parte ya se aran en sus respectivos fragments
    private DrawerLayout drawerLayout;
    private NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Metodo para estabelcer el toolbar
        setToolbar();

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        navigationView = (NavigationView) findViewById(R.id.navView);

        setFragmentByDefault();

        navigationView.setNavigationItemSelectedListener(this);

    }

    private void setToolbar() {
        //Instanciamos y traemos el toolbar
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //Se lo ponemos al actionbar de nuestra app
        setSupportActionBar(toolbar);
        //Establecemos el icono para pulsar y volver a desplegar el menu
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_home);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    //Metodo para establecer el fragment de inicio como prederteminado
    private void setFragmentByDefault() {
        changeFragment(new InicioFragment(), navigationView.getMenu().getItem(0));
    }

    //Metodo para el cambio de fragment
    private void changeFragment(Fragment fragment, MenuItem item) {
        //Se inicia la transaccion del fragmen a otro por lo cual se requiere el fragmentManager
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.content_frame, fragment)
                .commit();
        //Indicamos la opcion de menu pulsada
        item.setChecked(true);
        //Cambiamos el titulo del actionbar por la opcion del menu en donde se encuentra
        getSupportActionBar().setTitle(item.getTitle());
    }

    //Metodo del actionbar para deectar cuando se han pulsado estos elementos
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case android.R.id.home:
                //Cuando se pulse el boton de home se abrira el menu o drawer layuot
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    //Metodo para detectar que opcion del menu se selecciono
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        boolean fragmentTranssaction = false;
        Fragment fragment = null;

        switch (item.getItemId()) {
            case R.id.menu_inicio:
                fragment = new InicioFragment();
                fragmentTranssaction = true;
                break;
            case R.id.menu_categorias:
                fragment = new CategoriasFragment();
                fragmentTranssaction = true;
                break;
            case R.id.menu_offerts:
                fragment = new OfertasFragment();
                fragmentTranssaction = true;
                break;
            case R.id.menu_options:
                fragment = new OpcionesFragment();
                fragmentTranssaction = true;
                break;
        }

        if (fragmentTranssaction) {
            changeFragment(fragment, item);
            drawerLayout.closeDrawers();
        }
        return true;
    }


}
