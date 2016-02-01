package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class datosCliente extends AppCompatActivity {
    EditText nombre,apellidos,telefono,direccion;
    Button botonEnviar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);

        //recojo los datos enviados desde el mainActivity
        //precioFinal + continente
        final Bundle mybundle= getIntent().getExtras();



        botonEnviar = (Button)findViewById(R.id.btnEnviar);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=(EditText)findViewById(R.id.nombre);
                apellidos=(EditText)findViewById(R.id.apellidos);
                telefono=(EditText)findViewById(R.id.telefono);
                direccion=(EditText)findViewById(R.id.direccion);

                Intent i= new Intent(getApplicationContext(),evento.class);
                Bundle bundleNuevo = new Bundle();

                bundleNuevo.putString("nombre",nombre.getText().toString());
                bundleNuevo.putString("apellidos",apellidos.getText().toString());
                bundleNuevo.putString("telefono",telefono.getText().toString());
                bundleNuevo.putString("direccion",direccion.getText().toString());

                i.putExtras(mybundle);
                i.putExtras(bundleNuevo);
                startActivity(i);

            }

        });

    }
}
