package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class evento extends AppCompatActivity {

    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        Bundle mybundle= getIntent().getExtras();

        //Intent i= new Intent(getApplicationContext(),resumen.class);
        Bundle datos= new Bundle();
        Continentes cont=(Continentes)mybundle.getSerializable("continente");
        //datos.putString("datosEnviados", variable + "");
        ImageView image= (ImageView) findViewById(R.id.imageView);
        image.setImageResource(cont.getImagen());

        TextView zona= (TextView) findViewById(R.id.zona);
        zona.setText(cont.getNombre());


        //le metos al intent los datos
        //i.putExtras(datos);
       // i.putExtras(mybundle);
        //startActivity(i);

        texto= (TextView)findViewById(R.id.datos);

        texto.setText(mybundle.getString("datosEnviados"));
    }
}
