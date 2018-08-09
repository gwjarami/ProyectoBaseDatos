package com.isi.geison.proyectobasedatos;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Switch;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.isi.geison.proyectobasedatos.Adaptador.FloresRecycleViewAdapter;
import com.isi.geison.proyectobasedatos.Fragments.MainActivityFragment;
import com.isi.geison.proyectobasedatos.Modelo.Flores;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference ref;
    private RecyclerView rvFlores;
    private List<Flores> listaFlores;
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Button btnEliminar, btnModificar;
    //Flores flor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ref = FirebaseDatabase.getInstance().getReference();

        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(MainActivity.this, ActivityIngresarProducto.class);
                startActivity(intent);
            }
        });

    }

    public void onStart(){
        super.onStart();
        rvFlores = findViewById(R.id.rvFlores);
        btnEliminar = (Button) findViewById(R.id.btnEliminar);
        btnModificar = (Button) findViewById(R.id.btnModificar);
        LlenarDatosFirebase();
    }

    private void LlenarDatosFirebase() {
        ref.child("Flores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                listaFlores = new ArrayList<>();
                for(DataSnapshot postSnapshot:dataSnapshot.getChildren()){
                    Flores flor = postSnapshot.getValue(Flores.class);
                    //flor.setCodigo(postSnapshot.getKey());
                    System.out.print(flor.toString());
                    listaFlores.add(flor);
                }
                LlenarRecyclerView();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

    private void LlenarRecyclerView() {
        LinearLayoutManager llm = new LinearLayoutManager(this);
        rvFlores.setHasFixedSize(true);
        rvFlores.setLayoutManager(llm);
        FloresRecycleViewAdapter adapter = new FloresRecycleViewAdapter(this, listaFlores);
        rvFlores.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnEliminar:
//                ref.child("Flores").child(flor.getCodigo()).removeValue(new DatabaseReference.CompletionListener() {
//                    @Override
//                    public void onComplete(DatabaseError databaseError, DatabaseReference databaseReference) {
//
//                    }
//                });
                break;
            case R.id.btnModificar:
                break;
        }
    }
}
