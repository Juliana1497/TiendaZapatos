package com.juliana.tiendavirtualzapatos;

import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import com.juliana.tiendavirtualzapatos.databinding.ActivityMainBinding;
import com.juliana.tiendavirtualzapatos.ui.Adapters.SneakerAdapter;
import com.juliana.tiendavirtualzapatos.ui.Fragments.ProductosFragment;
import com.juliana.tiendavirtualzapatos.ui.Fragments.ServiciosFragment;
import com.juliana.tiendavirtualzapatos.ui.Fragments.SucursalesFragment;
import com.juliana.tiendavirtualzapatos.ui.Model.Sneaker;

public class MainActivity extends AppCompatActivity {

    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            throw new RuntimeException(e);
        }
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

        Fragment productoFragment = new ProductosFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment,productoFragment).commit();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id =  item.getItemId();
        if(id == R.id.itemCarrito){
            Fragment productosFragment = new ProductosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, productosFragment).commit();
            //Toast.makeText(this,"Este es el carrito de compras",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemCerrarSesion){
            Fragment serviciosFragment = new ServiciosFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, serviciosFragment).commit();
            //Toast.makeText(this,"Este es nosotros",Toast.LENGTH_SHORT).show();
        }else if(id == R.id.itemNosotros){
            Fragment sucursalesFragment = new SucursalesFragment();
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment, sucursalesFragment).commit();
            //Toast.makeText(this,"Este es cerrar sesión",Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_content_main);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }
}