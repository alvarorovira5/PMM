package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class datosCliente extends AppCompatActivity {
    EditText nombre,apellidos,telefono,direccion;
    Button botonEnviar;
    String nombreI,apellidosI,direccionI,telefonoI,zona;
    String precio;
    Envios_SQLiteHelper envio;
    SQLiteDatabase db;
    int id_Cliente;
    String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos_cliente);

        //recojo los datos enviados desde el mainActivity
        //precioFinal + continente
        final Bundle mybundle= getIntent().getExtras();

        botonEnviar = (Button)findViewById(R.id.btnEnviar);

        envio= new Envios_SQLiteHelper(this,"Proyecto",null,1);
        db= envio.getWritableDatabase();

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nombre=(EditText)findViewById(R.id.nombre);
                apellidos=(EditText)findViewById(R.id.apellidos);
                telefono=(EditText)findViewById(R.id.telefono);
                direccion=(EditText)findViewById(R.id.direccion);

                Intent i= new Intent(getApplicationContext(),evento.class);
                Bundle bundleNuevo = new Bundle();

                bundleNuevo.putString("nombre", nombre.getText().toString());
                bundleNuevo.putString("apellidos", apellidos.getText().toString());
                bundleNuevo.putString("telefono", telefono.getText().toString());
                bundleNuevo.putString("direccion", direccion.getText().toString());

                //inserto en la TABLA Clientes

                nombreI=nombre.getText().toString();
                apellidosI=apellidos.getText().toString();
                telefonoI= telefono.getText().toString();
                direccionI=direccion.getText().toString();

                db.execSQL("INSERT INTO Clientes (nombre,apellidos,telefono,direccion)" +
                        "VALUES ('" + nombreI + "','" + apellidosI + "','" + telefonoI + "','" + direccionI+"')");

                //inserto en la TABLA Pedidos
                //string
                precio=mybundle.getString("precio");
                //convertir a double
                Double.parseDouble(precio);

                //HACER UN SELECT PARA EXTRAER EL CLIENTE PARA DESPUES INSERTAR EN LA TABLA PEDIDOS

                Cursor c= db.rawQuery("SELECT id_Cliente " +
                                        "FROM Clientes "+
                                         "WHERE telefono = '"+telefonoI+"'",null);

                if(c.moveToFirst()){
                    do{
                        id=c.getString(0);
                    }while(c.moveToNext());
                }
                //idea, al insertar un cliente (con su id (autoincrement)) extraigo su id (con el select de arriba) para insertarla en la
                // tabla Pedido para establecer relacion entre ellas.

                //convierto el id (string) en int

                id_Cliente=Integer.parseInt(id);
                //objeto continente
                Continentes cont=(Continentes)mybundle.getSerializable("continente");
                zona=cont.getNombre();
                db.execSQL("INSERT INTO Pedidos (zona,precio,id_Cliente)" +
                        "VALUES ('"+zona+"',"+precio+","+id_Cliente+")");
                i.putExtras(mybundle);
                i.putExtras(bundleNuevo);
                startActivity(i);

            }

        });

    }
}
