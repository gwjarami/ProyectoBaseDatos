package com.isi.geison.proyectobasedatos;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.isi.geison.proyectobasedatos.Modelo.Flores;

public class ActivityIngresarProducto extends AppCompatActivity implements View.OnClickListener{

    private DatabaseReference databaseReference;

    EditText codigo, nombre, precio, altura, caracteristica, significado;
    Button btnGuardar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_producto);

        databaseReference = FirebaseDatabase.getInstance().getReference();

        btnGuardar = (Button) findViewById(R.id.btnGuardar);
        codigo = (EditText) findViewById(R.id.etCodigo);
        nombre = (EditText) findViewById(R.id.etNombre);
        precio = (EditText) findViewById(R.id.etPrecio);
        altura = (EditText) findViewById(R.id.etAltura);
        caracteristica = (EditText) findViewById(R.id.etCaracteristica);
        significado = (EditText) findViewById(R.id.etSignificado);

        btnGuardar.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnGuardar:
                Flores flor = new Flores(altura.getText().toString(),caracteristica.getText().toString()
                        ,nombre.getText().toString(),precio.getText().toString()
                        ,significado.getText().toString());
                //flor.setCodigo(codigo.getText().toString());

                databaseReference.child("Flores").child(codigo.getText().toString()).setValue(flor);
        }
    }
}
