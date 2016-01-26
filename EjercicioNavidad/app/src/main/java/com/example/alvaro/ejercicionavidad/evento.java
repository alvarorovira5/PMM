package com.example.alvaro.ejercicionavidad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class evento extends AppCompatActivity {

    TextView texto;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);

        Bundle mybundle= getIntent().getExtras();

        texto= (TextView)findViewById(R.id.datos);

        texto.setText(mybundle.getString("datosEnviados"));
    }
}
