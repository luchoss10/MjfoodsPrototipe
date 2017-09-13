package com.example.luismiguel.mjfoods.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.luismiguel.mjfoods.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class OfertasFragment extends Fragment {


    public OfertasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_ofertas, container, false);

        return view;
    }

}
