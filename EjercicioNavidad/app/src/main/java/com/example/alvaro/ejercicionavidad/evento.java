package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class evento extends AppCompatActivity {

    TextView texto,nombre,apellidos,direccion,telefono;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        //setContentView(R.layout.activity_evento);

        //recojo los datos enviados desde el mainActivity
        Bundle mybundle= getIntent().getExtras();


        //recojo el objeto continente
        Continentes cont=(Continentes)mybundle.getSerializable("continente");

        ImageView image= (ImageView) findViewById(R.id.imageView);
        image.setImageResource(cont.getImagen());

        TextView zona= (TextView) findViewById(R.id.zona);
        zona.setText(cont.getNombre());

        texto= (TextView)findViewById(R.id.datos);
        texto.setText(mybundle.getString("precio"));

        //nombre
        nombre=(TextView)findViewById(R.id.nombre);
        nombre.setText(mybundle.getString("nombre"));
        //apellido
        apellidos=(TextView)findViewById(R.id.apellidos);
        apellidos.setText(mybundle.getString("apellidos"));
        //direccion
        direccion=(TextView)findViewById(R.id.direccion);
        direccion.setText(mybundle.getString("direccion"));
        //telefono
        telefono=(TextView)findViewById(R.id.telefono);
        telefono.setText(mybundle.getString("telefono"));
    }
}
