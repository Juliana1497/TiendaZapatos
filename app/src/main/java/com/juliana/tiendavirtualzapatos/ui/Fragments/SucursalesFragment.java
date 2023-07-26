package com.juliana.tiendavirtualzapatos.ui.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.juliana.tiendavirtualzapatos.R;
import com.juliana.tiendavirtualzapatos.ui.Adapters.SneakerAdapter;
import com.juliana.tiendavirtualzapatos.ui.Model.Sneaker;

public class SucursalesFragment extends Fragment {

    public SucursalesFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.sucursales_layout, container, false);
    }

}
