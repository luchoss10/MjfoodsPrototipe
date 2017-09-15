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
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private List<Restaurante> restaurantes;
    private int layout;
    private OnItemClickListener itemClickListener;
    private Activity activity;

    public RecyclerAdapter(List<Restaurante> restaurantes, int layout, OnItemClickListener itemClickListener, Activity activity) {
        this.restaurantes = restaurantes;
        this.layout = layout;
        this.itemClickListener = itemClickListener;
        this.activity = activity;

    }

    @Override
    public RecyclerAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(activity).inflate(layout, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;

    }

    @Override
    public void onBindViewHolder(RecyclerAdapter.ViewHolder holder, int position) {
        holder.bind(restaurantes.get(position), itemClickListener);
    }

    @Override
    public int getItemCount() {
        return restaurantes.size();

    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        public TextView textViewRestaurante;
        public ImageView imageViewRestaurante;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewRestaurante = (TextView) itemView.findViewById(R.id.textView_recycler_item);
            imageViewRestaurante = (ImageView) itemView.findViewById(R.id.imageView_recycler_item);

        }


        public void bind(final Restaurante restaurante, final OnItemClickListener itemClickListener) {
            textViewRestaurante.setText(restaurante.getName());
            //Arreglar el picaso porque falta la imagen colocar la propiedad debe llegar de un http reques Investigar

            //Picasso.with(activity).load(restaurante.{-------------}).fit().into(imageViewRestaurante);

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


