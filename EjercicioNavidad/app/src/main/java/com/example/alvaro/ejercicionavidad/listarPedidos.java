package com.example.alvaro.ejercicionavidad;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.AbsListView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class listarPedidos extends AppCompatActivity {
    Envios_SQLiteHelper envio;
    SQLiteDatabase db;
    ArrayList<todosPedidos> datos;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_pedidos);


        envio= new Envios_SQLiteHelper(this,"Proyecto",null,1);
        db= envio.getWritableDatabase();

        Cursor c = db.rawQuery("SELECT C.Nombre, P.* " +
                "FROM Pedidos P, Clientes C " +
                " WHERE P.id_Cliente = C.id_Cliente ", null);


        datos = new ArrayList<todosPedidos>();

        if (c.moveToFirst()) {
            do {
                todosPedidos usuarioPedido = new todosPedidos();

                usuarioPedido.setZona(c.getString(c.getColumnIndex("zona")));
                usuarioPedido.setNombre(c.getString(c.getColumnIndex("nombre")));
                usuarioPedido.setPrecio(c.getFloat(c.getColumnIndex("precio")));
                usuarioPedido.setId_Pedidos(c.getInt(c.getColumnIndex("id_Pedido")));
                usuarioPedido.setId_Cliente(c.getInt(c.getColumnIndex("id_Cliente")));

                datos.add(usuarioPedido);
            } while (c.moveToNext());
        }


        listaPedidos_Adapter adapter;
// Inicializamos el adapter.
        adapter = new listaPedidos_Adapter(this, datos);
// Asignamos el Adapter al ListView, en este punto hacemos que el
// ListView muestre los datos que queremos.
        ListView listView= (ListView) findViewById(R.id.listView);
        listView.setAdapter(adapter);

        ///////////////////////////////////////////////////
        ///////////////////////////////////////////////////
        //context menu
        ///////////////////////////////////////////////////
        //////////////////////////////////////////////////

        //Menu para eliminar al dejar pulsado una linea del ListView
        listView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE_MODAL);
        listView.setMultiChoiceModeListener(new AbsListView.MultiChoiceModeListener() {
            private String idSeleccionado;

            //selecciona lo que hay seleccionado
            @Override
            public void onItemCheckedStateChanged(ActionMode mode, int position,
                                                  long id, boolean checked) {
                // Here you can do something when items are selected/de-selected,
                // such as update the title in the CAB
                idSeleccionado=String.valueOf(datos.get(position).getId_Pedidos());
                Toast.makeText(listarPedidos.this, "on item checked", Toast.LENGTH_LONG).show();

            }
            //lo que hara cuando haya algo seleccionado, mostra menu eliminar.
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                // Inflate the menu for the CAB
                MenuInflater inflater = mode.getMenuInflater();
                inflater.inflate(R.menu.item_action, menu);
                return true;
            }
            //cuando seleccione algo del menu, lo hara.
            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                // Respond to clicks on the actions in the CAB
                switch (item.getItemId()) {
                    case R.id.action_eliminar:
                        //metodo eleminar
                        eliminar(idSeleccionado);
                        //metodo recargar pag
                        recargar();
                        //showToast("ELIMINAR id: " + idSeleccionado);
                        mode.finish(); // Action picked, so close the CAB
                        return true;
                    default:
                        return false;
                }
            }
            @Override
            public void onDestroyActionMode(ActionMode mode) {
                // Here you can make any necessary updates to the activity when
                // the CAB is removed. By default, selected items are deselected/unchecked.
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                // Here you can perform updates to the CAB due to
                // an invalidate() request
                return false;
            }
        });//final menu contextual listView

    }

    public void eliminar(String id) {
        envio= new Envios_SQLiteHelper(this,"Proyecto",null,1);
        db= envio.getWritableDatabase();

        String[] idBorrar = new String[]{String.valueOf(id)};


        db.delete("Pedidos", "id_Pedido=?", idBorrar);
        db.close();
        envio.close();

        Toast.makeText(listarPedidos.this, "Usuario eliminado correctamente", Toast.LENGTH_LONG).show();
    }

    public void recargar() {
        Intent home_intent = new Intent(getApplicationContext(), listarPedidos.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

        startActivity(home_intent);
    }
}
