package com.example.mati.radiolinearlayout;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final RadioGroup radioGroupColores = (RadioGroup)findViewById(R.id.radioGroup);

        RadioButton radioAzul = (RadioButton) findViewById(R.id.Azul);
        RadioButton radioBlanco = (RadioButton) findViewById(R.id.Blanco);
        RadioButton radioRojo = (RadioButton) findViewById(R.id.Rojo);

        Button btnEstablecerColor = (Button) findViewById(R.id.establecerColor);
        Button btnBorrarColor= (Button) findViewById(R.id.borrarColor);

        final TextView ColorTextView = (TextView)findViewById(R.id.textView);

        btnEstablecerColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (R.id.Rojo == radioGroupColores.getCheckedRadioButtonId()){
                    ColorTextView.setBackgroundColor(Color.RED);
                }
                if (R.id.Azul == radioGroupColores.getCheckedRadioButtonId()){
                    ColorTextView.setBackgroundColor(Color.BLUE);
                }
                if (R.id.Blanco == radioGroupColores.getCheckedRadioButtonId()){
                    ColorTextView.setBackgroundColor(Color.WHITE);
                }
            }
        });
        btnBorrarColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ColorTextView.setBackgroundColor(Color.BLACK);
            }
        });
    }


}
