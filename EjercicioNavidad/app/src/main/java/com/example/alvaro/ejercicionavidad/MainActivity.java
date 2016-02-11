package com.example.alvaro.ejercicionavidad;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    EditText totalpeso;
    CheckBox cajaRegalo;
    CheckBox tarjetaDedicada;
    TextView textViewPeso;
    RadioGroup radioGroup;
    RadioButton Normal;
    RadioButton Urgente;
    Button botonEnviar;
    ImageView imagen;
    Spinner spinner;
    boolean validarPeso=true;
    String continenteSelecionado;
    int idContinente;
    double precioFinal=0.0;

    private Continentes[] continente =
            {
                    new Continentes(0, "Africa", 2, 20, R.drawable.africa),
                    new Continentes(1, "America", 2, 20, R.drawable.america),
                    new Continentes(2, "Asia", 1, 30, R.drawable.asia),
                    new Continentes(3, "Europa", 3, 10, R.drawable.europa),
                    new Continentes(4, "Oceania", 1, 30, R.drawable.oceania),
            };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //BD

        Envios_SQLiteHelper envio= new Envios_SQLiteHelper(this,"Proyecto",null,1);
        SQLiteDatabase db= envio.getWritableDatabase();

        precioFinal=0;

        imagen =(ImageView)findViewById(R.id.imageView);

        registerForContextMenu(imagen);

        spinner = (Spinner)findViewById(R.id.spinner);
        //establezco el adaptador al spinner
        AdaptadorContinente adaptadorContinente= new AdaptadorContinente(this);
        spinner.setAdapter(adaptadorContinente);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                idContinente = position;
                precioFinal= continente[idContinente].getPrecio();
                Toast.makeText(MainActivity.this, continente[idContinente].getNombre() + "", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        cajaRegalo= (CheckBox) findViewById(R.id.cajaRegalo);
        cajaRegalo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                precioFinal += 2;
            }
        });
        tarjetaDedicada= (CheckBox) findViewById(R.id.tarjetaDedicada);
        tarjetaDedicada.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                precioFinal+=5;
            }
        });

        totalpeso = (EditText) findViewById(R.id.total);
        radioGroup = (RadioGroup)findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.tarifaNormal) {
                    precioFinal += 3;
                } else {
                    precioFinal += 8;
                }
            }
        });

        botonEnviar=  (Button) findViewById(R.id.calcular);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //String peso=Integer.valueOf(totalpeso.getText().toString());
                String peso= totalpeso.getText().toString();

                if (peso.equals("")) {
                    Toast.makeText(MainActivity.this, "Ha dejado el peso vacio", Toast.LENGTH_LONG).show();
                }else {
                    Integer.parseInt(peso);

                    if (Integer.parseInt(peso) <= 5) {
                        precioFinal += 1;
                    } else if (Integer.parseInt(peso) >= 6 && Integer.parseInt(peso) <= 10) {
                        precioFinal += 1.5;
                    } else {
                        precioFinal += 2;
                    }

                    Intent i = new Intent(getApplicationContext(), datosCliente.class);
                    Bundle datos = new Bundle();
                    datos.putString("precio", precioFinal + "");
                    datos.putSerializable("continente", continente[idContinente]);
                    //le metos al intent los datos
                    i.putExtras(datos);
                    startActivity(i);
                }
            }
        });
    }
    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu,menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_acercaDe:
                Intent intentMain = new Intent(MainActivity.this , acerca_de.class);
                startActivity(intentMain);
                return true;
            case R.id.action_dibujo:
                Intent intentMain2 = new Intent(MainActivity.this,dibujo.class);
                startActivity(intentMain2);
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    //Menu contextual
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.action_acercaDe:
                Intent intentMain = new Intent(MainActivity.this ,acerca_de.class);
                startActivity(intentMain);
                return true;
            default:
                return super.onContextItemSelected(item);
        }
    }
    // array adapaer pilla el array he introduce los datos para preparalos.
    class AdaptadorContinente extends ArrayAdapter<Continentes>{
        //Pilla el contenido entero de la actividad.
        public Activity context;

        public AdaptadorContinente(Activity context) {
            super(context, R.layout.spinner_layout, continente);
            this.context = context;
        }

        //tipo de vista
        public View getDropDownView(int position, View convertView, ViewGroup parent){
            View vistaDesplegada = getView(position,convertView,parent);
            return vistaDesplegada;
        }
        //obtener datos en la vista en el xml plantilla,
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            //carga la plantilla del spinner
            View item = inflater.inflate(R.layout.spinner_layout, null);

            TextView textView=(TextView) item.findViewById(R.id.nombre_spinner);

            textView.setText(continente[position].getNombre() + " - " + continente[position].getPrecio()+"€");

            return (item);
        }
    }

}

