package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class evento extends AppCompatActivity {

    TextView texto, nombre, apellidos, direccion, telefono,precio;
    Envios_SQLiteHelper envio;
    SQLiteDatabase db;
    String id,id_Cliente;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evento);
        //recojo el bundle
        final Bundle mybundle = getIntent().getExtras();
        id_Cliente=mybundle.getString("id_Cliente");
        //recojo el objeto continente
        Continentes cont=(Continentes)mybundle.getSerializable("continente");
        //Toast.makeText(evento.this, id_Cliente, Toast.LENGTH_SHORT).show();

        //setContentView(R.layout.activity_evento);
        /*
        //recojo los datos enviados desde el mainActivity
        Bundle mybundle= getIntent().getExtras();




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
        telefono.setText(mybundle.getString("telefono"));*/

        //////////////////////////////////////////////////
        /////////////////////////////////////////////////
        // El codigo de arriba sirve para cuando utilizo
        // el bundle.
        // Ahora la idea, es mostrar la informacion del
        // pedido, con un select selecionando el cliente
        //con su correspondiente pedido.
        //////////////////////////////////////////////////
        //////////////////////////////////////////////////

        envio = new Envios_SQLiteHelper(this, "Proyecto", null, 1);
        db = envio.getWritableDatabase();

        //hacer consulta
        //saco todos los datos del cliente
        Cursor c= db.rawQuery("SELECT * " +
                "FROM Clientes "+
                "WHERE id_cliente = '"+id_Cliente+"'",null);

        Clientes clientes= new Clientes();

        if(c.moveToFirst()){
            do{
                clientes.setNombre(c.getString(c.getColumnIndex("nombre")));
                clientes.setApellidos(c.getString(c.getColumnIndex("apellidos")));
                clientes.setDireccion(c.getString(c.getColumnIndex("direccion")));
                clientes.setTelefono(c.getInt(c.getColumnIndex("telefono")));

            }while(c.moveToNext());
        }

        //saco todos los datos del pedido

        Cursor d= db.rawQuery("SELECT * " +
                "FROM Pedidos "+
                "WHERE id_cliente = '"+id_Cliente+"'",null);

        Pedidos pedidos= new Pedidos();
        if(d.moveToFirst()){
            do{
                pedidos.setZona(d.getString(d.getColumnIndex("zona")));
                Toast.makeText(evento.this, d.getString(d.getColumnIndex("zona")), Toast.LENGTH_SHORT).show();
                pedidos.setPrecio(d.getInt(d.getColumnIndex("precio")));
            }while(c.moveToNext());
        }
        //despues de esto los muestro.

        //Establezco la zona
        TextView zona= (TextView) findViewById(R.id.inputZona);
        zona.setText(pedidos.getZona());
       // Toast.makeText(evento.this, pedidos.getZona(), Toast.LENGTH_SHORT).show();

        //Establezco el precio
        precio= (TextView)findViewById(R.id.inputPrecio);
        precio.setText(pedidos.getPrecio()+"");

        //Establezco el nombre
        nombre=(TextView)findViewById(R.id.inputNombre);
        nombre.setText(clientes.getNombre());

        //Establezco los apellidos
        apellidos=(TextView)findViewById(R.id.inputApellidos);
        apellidos.setText(clientes.getApellidos());

        //direccion
        direccion=(TextView)findViewById(R.id.inputDireccion);
        direccion.setText(clientes.getDireccion());

        //telefono
        telefono=(TextView)findViewById(R.id.inputTelefono);
        telefono.setText(String.valueOf(clientes.getTelefono()));

        //imagen
        ImageView image= (ImageView) findViewById(R.id.imageView);
        image.setImageResource(cont.getImagen());

    }
    //Menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_listar,menu);


        return true;
    }
    //opciones menu
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.action_listarPedido2:
                Intent intentMain = new Intent(evento.this , listarPedidos.class);
                startActivity(intentMain);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
