package com.example.luismiguel.mjfoods.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luismiguel.mjfoods.Adapters.RecyclerAdapter;
import com.example.luismiguel.mjfoods.Models.Restaurante;
import com.example.luismiguel.mjfoods.R;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class InicioFragment extends Fragment implements RecyclerAdapter.OnItemClickListener {

    //Elementos necesarios para visualizar los restaurantes en el fragment inicio
    private List<Restaurante> restaurantes;
    private RecyclerView mRecyclerView;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;

    public InicioFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_inicio, container, false);

        mRecyclerView = (RecyclerView) view.findViewById(R.id.recycler_view_incio);
        mLayoutManager = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new RecyclerAdapter(restaurantes,R.layout.recycler_view_menu_item, getActivity(), this);

        return view;
    }

    @Override
    public void onItemClick(Restaurante restaurante, int position) {

    }
}
