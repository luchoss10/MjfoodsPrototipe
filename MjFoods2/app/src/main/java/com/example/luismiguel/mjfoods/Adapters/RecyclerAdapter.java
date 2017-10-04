package com.example.luismiguel.mjfoods.Adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.luismiguel.mjfoods.Models.Restaurante;
import com.example.luismiguel.mjfoods.R;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * Created by LuisMiguel on 14/09/2017.
 * Adaptador PAra la lista del recycler_view de el fragment inicio
 */

//Extendemos nuestra clase de RecyclerView.Adapter<RecyclerAdapter.ViewHolder>
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    //Obtenemos los parametros para nuestro adapter
    private List<Restaurante> restaurantes;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Activity activity;

    //Creamos el metodo para la creacion de el adaptador
    public RecyclerAdapter(List<Restaurante> restaurantes, int layout, Activity activity, OnItemClickListener itemClickListener) {
        this.restaurantes = restaurantes;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
        this.activity = activity;
    }

    //Sobreeescribimos los metodos del adaptadror

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Creamos una nueva vista para la lista y la inflamos con el layout de el recycler_item
        View v = LayoutInflater.from(activity).inflate(layout, parent, false);
        //Guardamos la vista generada en el viewHolder
        ViewHolder vh = new ViewHolder(v);
        //Y se lo pasamos al padre para el manejo reciclado de la vista
        return vh;
    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        //En este metodo obtendremos de el adaptador padre los datos enviados anterior mente generados y se los pasamos
        //A el metodo bind, le pasaremos entonces el item y su listener
        holder.bind(restaurantes.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        //Aca optendremos el tamaño de la lista que visualizaremos
        return restaurantes.size();
    }

    //En este metodo vamos a Rellenar niuestra vista de item con cada dato del objeto en cuestion
    public class ViewHolder extends RecyclerView.ViewHolder {

        //Primero instanciamos los elementos que utilizaremos para la vista
        public TextView textViewRestaurante;
        public ImageView imageViewRestaurante;

        public ViewHolder(View itemView) {
            super(itemView);

            //Los relacionamos con los objetos el item de xml con la vista que anteriormente le habiamos
            //pasado al padre
            textViewRestaurante = (TextView) itemView.findViewById(R.id.textView_recycler_item);
            imageViewRestaurante = (ImageView) itemView.findViewById(R.id.imageView_recycler_item);
        }


        //Por ultimo en el metodo bind vamos a acomodar los datos de cada elemento y si ya estan simplemente los recicla
        public void bind(final Restaurante restaurante, final OnItemClickListener itemClickListener) {
            textViewRestaurante.setText(restaurante.getName());
            //Arreglar el picaso porque falta la imagen colocar la propiedad debe llegar de un http reques Investigar

            //Picasso.with(activity).load(restaurante.{-------------}).fit().into(imageViewRestaurante);

            //Por ultimo le integraremos el metodo setOnclick listener para cuando es pulsado
            //Con nuestra interfaz onitemclick
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    itemClickListener.onItemClick(restaurante, getAdapterPosition());
                }
            });
        }
    }

    public interface OnItemClickListener {
        void onItemClick(Restaurante restaurante, int position);
    }
}


