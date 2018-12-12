package com.example.annafragoso.aulaandroid;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //private TextView txtNome;

    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    Menu action_messages;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       /* FloatingActionButton mEditButton =
                (FloatingActionButton) findViewById(R.id.fabEdit);
        mEditButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });*/



        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        navigationView = findViewById(R.id.navigation_view);

        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        if (menuItem.isChecked()) {
                            menuItem.setChecked(false);
                        }
                        else {
                            menuItem.setChecked(true);
                        }
                        drawerLayout.closeDrawers();
                        if (menuItem.getItemId() == R.id.action_anotacao) {
                            AnotacaoFragment fragment = new AnotacaoFragment();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragment).commit();
                            return true;
                        }
                        /*if (menuItem.getItemId() == R.id.action_lista) {
                            ListaFragment fragment = new ListaFragment();
                            getSupportFragmentManager().beginTransaction().replace(
                                    R.id.frag_container, fragment).commit();
                            return true;
                        }*/

                        return false;
                    }
                });

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        actionBarDrawerToggle =
                new ActionBarDrawerToggle(this, drawerLayout,
                        R.string.openDrawer, R.string.closeDrawer) {
                };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        //código novo

        TextView txtNome = navigationView.getHeaderView(0).findViewById(R.id.txtNome);

        SharedPreferences prefs = getSharedPreferences("usuario", MODE_PRIVATE);
        String email = prefs.getString("email", "Usuário não identificado");
        txtNome.setText(email);

    }






    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (actionBarDrawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        if(item.getItemId() == R.id.action_anotacao) {
            Intent intent = new Intent(MainActivity.this, AnotacaoFragment.class);
            startActivity(intent);
        }
        if(item.getItemId() == R.id.action_lista) {
            Intent intent = new Intent(MainActivity.this, ListaActivity.class);
            startActivity(intent);
        }

        if(item.getItemId() == R.id.action_messages) {
            SobreFragment fragment = new SobreFragment();
            getSupportFragmentManager().beginTransaction().replace(
                    R.id.frag_container, fragment).commit();
        }
        if(item.getItemId() == R.id.action_sair) {
            finish();
        }
        return super.onOptionsItemSelected(item);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Carrega o menu
        getMenuInflater().inflate(R.menu.navegacao, menu);
        return true;
    }

}
