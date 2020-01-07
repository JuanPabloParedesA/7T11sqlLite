package com.example.a7t11sqllite;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Agregar extends AppCompatActivity {
    EditText txtnombre,txtedad,txtcorreo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);

        txtnombre = findViewById(R.id.txtNombre);
        txtedad = findViewById(R.id.txtEdad);
        txtcorreo = findViewById(R.id.txtCorreo);


    }

    public void registrar(View v){

        ContentValues contentValues = new ContentValues();
        DatosConexion datosConexion= new DatosConexion(this);
        datosConexion.open();

        contentValues.put("Nombre",txtnombre.getText().toString());
        contentValues.put("Edad",txtedad.getText().toString());
        contentValues.put("Correo",txtcorreo.getText().toString());

        if (datosConexion.insertar(contentValues))
            Toast.makeText(this, "Se agregoeldato...", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "No se puede registrar", Toast.LENGTH_SHORT).show();
        datosConexion.close();
    }

    //Boton Menu
}
