package com.juliana.tiendavirtualzapatos;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.navigation.NavigationView;
import com.google.android.material.snackbar.Snackbar;
import com.juliana.tiendavirtualzapatos.R;
import com.juliana.tiendavirtualzapatos.databinding.ActivityMainBinding;
import com.juliana.tiendavirtualzapatos.ui.Model.Sneaker;

public class SneakerDetailActivity extends AppCompatActivity {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    private ImageView sneakerImg;
    private TextView sneakerTitle;
    private TextView sneakerDescription;
    private Button botonComprar;
    private Button botonVolver;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.appBarMain.toolbar);
        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_productos, R.id.nav_servicios, R.id.nav_sucursales)
                .setOpenableLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);
        NavigationUI.setupWithNavController(navigationView, navController);

        getSupportActionBar().setDisplayShowHomeEnabled(true);

        setContentView(R.layout.sneaker_detail);

        int id = getIntent().getExtras().getInt("sneaker_id");

        int sneaker_drawable = getIntent().getExtras().getInt("sneaker_img");

        String sneaker_name = getIntent().getExtras().getString("sneaker_name");

        String sneaker_description = getIntent().getExtras().getString("sneaker_description");

        sneakerImg = (ImageView) findViewById(R.id.sneakerDetailedImage);
        sneakerTitle = (TextView) findViewById(R.id.sneakerDetailedTitle);
        sneakerDescription = (TextView) findViewById(R.id.sneakerDescription);

        sneakerImg.setImageResource(sneaker_drawable);
        sneakerTitle.setText(sneaker_name);
        sneakerDescription.setText(sneaker_description);

        botonComprar = (Button) findViewById(R.id.botonComprar);

        botonComprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Producto agregado al carrito", Toast.LENGTH_SHORT).show();
            }
        });

        botonVolver = (Button) findViewById(R.id.botonVolver);

        botonVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
