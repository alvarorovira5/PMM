package com.example.alvaro.ejercicionavidad;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;

/**
 * Created by alvaro on 2/02/16.
 */
public class Envios_SQLiteHelper extends SQLiteOpenHelper {

    String sqlCreateClientes = "CREATE TABLE Clientes (" +
            "id_Cliente INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "nombre TEXT NOT NULL," +
            "apellidos TEXT NOT NULL," +
            "telefono INTEGER NOT NULL," +
            "direccion TEXT NOT NULL);";

    //Sentencia SQL para crear la tabla de Pedidos
    String sqlCreatePedidos = "CREATE TABLE Pedidos (" +
            "id_Pedido INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, " +
            "zona TEXT NOT NULL, " +
            "precio INTEGER NOT NULL, " +
            "id_Cliente INTEGER," +
            "FOREIGN KEY( 'id_Cliente') REFERENCES Clientes ('id_Cliente'))";


    public Envios_SQLiteHelper(Context context, String nombre, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, nombre, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Se ejecuta la sentencia SQL de creación de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreatePedidos);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int versionAnterior, int versionNueva) {
        //NOTA: Por simplicidad del ejemplo aquí utilizamos directamente la opción de
        //      eliminar la tabla anterior y crearla de nuevo vacía con el nuevo formato.
        //      Sin embargo lo normal será que haya que migrar datos de la tabla antigua
        //      a la nueva, por lo que este método debería ser más elaborado.

        //Se elimina la versión anterior de la tabla
        db.execSQL("DROP TABLE IF EXISTS Pedidos");

        //Se crea la nueva versión de la tabla
        db.execSQL(sqlCreateClientes);
        db.execSQL(sqlCreatePedidos);
    }
    /*
    public int id(){


        Envios_SQLiteHelper envio =  new Envios_SQLiteHelper(this,"Proyecto",null,1);
        SQLiteDatabase db =envio.getReadableDatabase();

        Cursor c= db.rawQuery("SELECT id_Cliente " +
                "FROM Clientes"+
                "WHERE telefonoI='"+telefonoI+"'");

        if(c.moveToFirst()){
            do{
                String id=c.getString(0);
            }while(c.moveToNext());
        }
        Integer.parseInt(id);
        return id;
    }*/
}
