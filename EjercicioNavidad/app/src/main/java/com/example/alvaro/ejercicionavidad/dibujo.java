package com.example.alvaro.ejercicionavidad;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class dibujo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new MiDibujo(this));




    }
    class MiDibujo extends View {
        public MiDibujo(Context c){

            super(c);
        }

        protected void onDraw(Canvas lienzo){
            Paint miPincel= new Paint();
            miPincel.setColor(Color.BLACK);
            miPincel.setStyle(Paint.Style.STROKE);
            miPincel.setStrokeWidth(5);
            miPincel.setTextSize(70);

            int width = this.getWidth();
            int ancho = width/5;
            int height = this.getHeight();
            int altura = height / 20;



            lienzo.drawRect(ancho, altura * 5, ancho * 4, altura * 11, miPincel);


            miPincel.setStrokeWidth(5);
            miPincel.setTextSize(60);

            lienzo.drawText("Álvaro Rovira Ibáñez", ancho, altura* 19, miPincel);


        }
    }
}
