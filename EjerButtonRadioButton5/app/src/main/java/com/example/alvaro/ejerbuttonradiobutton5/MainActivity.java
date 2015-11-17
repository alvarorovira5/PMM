package com.example.alvaro.ejerbuttonradiobutton5;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView cant1, cant2, textResultado;

    RadioGroup radioGroupOperaciones;
    RadioButton radioButtonSumar, radioButtonRestar;
    int total;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        cant1 = (TextView)findViewById(R.id.editText1);
        cant2 = (TextView)findViewById(R.id.editText2);
        textResultado = (TextView)findViewById(R.id.textViewResultado);

        radioGroupOperaciones = (RadioGroup)findViewById(R.id.radioGroupOperaciones);
        radioButtonSumar = (RadioButton)findViewById(R.id.radioButtonSumar);
        radioButtonRestar = (RadioButton)findViewById(R.id.radioButtonRestar);


        radioGroupOperaciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                if (radioGroupOperaciones.getCheckedRadioButtonId() == R.id.radioButtonSumar){
                    total = Integer.parseInt(cant1.getText().toString()) + Integer.parseInt(cant2.getText().toString());
                    String mensaje = "";
                    mensaje = ""+total;
                    textResultado.setText(mensaje);
                }
                if (radioGroupOperaciones.getCheckedRadioButtonId() == R.id.radioButtonRestar){
                    total = Integer.parseInt(cant1.getText().toString()) - Integer.parseInt(cant2.getText().toString());
                    String mensaje = "";
                    mensaje = ""+total;
                    textResultado.setText(mensaje);
                }
            }
        });
    }
}
