package com.example.alvaro.tablelayout;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnRojo;
    Button btnAmarillo;
    Button btnAzul;

    Button btnBorrar;

    TextView textViewcolor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnRojo = (Button)findViewById(R.id.btnRojo);
        btnAmarillo = (Button)findViewById(R.id.btnAmarillo);
        btnAzul = (Button)findViewById(R.id.btnAzul);
        btnBorrar = (Button)findViewById(R.id.btnBorrar);

        textViewcolor = (TextView)findViewById(R.id.textViewcolor);



        btnRojo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewcolor.setBackgroundColor(getResources().getColor(R.color.colorRed));
            }
        });
        btnAmarillo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewcolor.setBackgroundColor(getResources().getColor(R.color.colorYellow));
            }
        });
        btnAzul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewcolor.setBackgroundColor(getResources().getColor(R.color.colorBlue));
            }
        });

        btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textViewcolor.setBackgroundColor(getResources().getColor(R.color.colorPorDefecto));
            }
        });

    }
}
