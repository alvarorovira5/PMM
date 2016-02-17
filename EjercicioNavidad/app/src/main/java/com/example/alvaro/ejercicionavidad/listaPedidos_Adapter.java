package com.example.alvaro.ejercicionavidad;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by alvaro on 17/02/16.
 */
public class listaPedidos_Adapter extends ArrayAdapter {

    private Context context;
    private ArrayList<todosPedidos> datos;

    public listaPedidos_Adapter(Context context, ArrayList<todosPedidos> datos) {
        super(context, R.layout.lista_pedidos_item, datos);
        // Guardamos los parámetros en variables de clase.
        this.context = context;
        this.datos = datos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // En primer lugar "inflamos" una nueva vista, que será la que se
        // mostrará en la celda del ListView. Para ello primero creamos el
        // inflater, y después inflamos la vista.
        LayoutInflater inflater = LayoutInflater.from(context);
        View item = inflater.inflate(R.layout.lista_pedidos_item, null);

        // A partir de la vista, recogeremos los controles que contiene para
        // poder manipularlos.


        // Recogemos el TextView para mostrar el nombre y establecemos el
        // nombre.
        TextView nombre = (TextView) item.findViewById(R.id.nombre);
        nombre.setText(datos.get(position).getNombre());

        // zona
        TextView zona = (TextView) item.findViewById(R.id.zona);
        zona.setText(datos.get(position).getZona());

        // precio
        TextView precio = (TextView) item.findViewById(R.id.precio);
        precio.setText(Float.toString(datos.get(position).getPrecio()));

        // id_cliente
        TextView id_cliente = (TextView) item.findViewById(R.id.id_cliente);
        id_cliente.setText(Integer.toString(datos.get(position).getId_Cliente()));

        // id_pedido
        TextView id_pedido = (TextView) item.findViewById(R.id.id_Pedidos);
        id_pedido.setText(Integer.toString(datos.get(position).getId_Pedidos()));

        // Devolvemos la vista para que se muestre en el ListView.
        return item;
    }
}
