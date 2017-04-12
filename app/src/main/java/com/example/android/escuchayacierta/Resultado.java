package com.example.android.escuchayacierta;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Resultado extends AppCompatActivity {

    int contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        Intent intentDatos=getIntent();
        contador= intentDatos.getIntExtra("ccontador", 0);

        TextView tvResultado = (TextView) findViewById(R.id.tvResultado);
        ImageView ivFondoResultado = (ImageView) findViewById(R.id.ivFondoResultado);
        TextView tvPuntuacion= (TextView) findViewById(R.id.tvPpuntuacion);

        if (contador==30) {

            tvResultado.setText(R.string.resultado100);
            ivFondoResultado.setImageResource(R.drawable.resultado100);


        }else if (contador==20){

            tvResultado.setText(R.string.resultadooGanador );
            ivFondoResultado.setImageResource(R.drawable.fondo_ganador);

        }else if(contador<20){

            tvResultado.setText(R.string.resultadoPerdedor  );
            ivFondoResultado.setImageResource(R.drawable.sigue_practicando);

        }

    }

    public void Menu (View view) {

        Intent intentActividad = new Intent(this, Menu.class);
        startActivity(intentActividad);
    }

}
