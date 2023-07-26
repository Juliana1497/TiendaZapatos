package com.juliana.tiendavirtualzapatos.ui.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.juliana.tiendavirtualzapatos.R;
import com.juliana.tiendavirtualzapatos.ui.Adapters.SneakerAdapter;
import com.juliana.tiendavirtualzapatos.ui.Model.Sneaker;
import com.juliana.tiendavirtualzapatos.SneakerDetailActivity;

public class ProductosFragment extends Fragment {

    private GridView grilla;
    private SneakerAdapter sneakerAdapter;

    public ProductosFragment(){

    }

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.productos_layout, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState){
        super.onViewCreated(view, savedInstanceState);

        grilla = getView().findViewById(R.id.grilla);
        sneakerAdapter = new SneakerAdapter(getContext());
        grilla.setAdapter(sneakerAdapter);

        grilla.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Sneaker item = (Sneaker) parent.getItemAtPosition(position);

                Intent intent = new Intent(getContext(), SneakerDetailActivity.class);
                intent.putExtra("sneaker_id",item.getId());
                intent.putExtra("sneaker_img",item.getIdDrawable());
                intent.putExtra("sneaker_name",item.getName());
                intent.putExtra("sneaker_description",item.getDescription());
                startActivity(intent);

                //Toast.makeText(getContext(), "Se seleccionó "+item.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
