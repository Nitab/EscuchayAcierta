package com.example.android.escuchayacierta;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Animales1 extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RadioGroup radioGroup;
    RadioButton rbRana;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales1);
        mediaPlayer = MediaPlayer.create(Animales1.this, R.raw.frog);
        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        rbRana = (RadioButton) findViewById(R.id.rbRana);


        Intent intentDatosObtenidos =getIntent();
        contador= intentDatosObtenidos.getIntExtra("ccontador", 0);


    }

    public void Play (View view){
        mediaPlayer.start();
    }

    public void Pause (View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void Caballo (View view){
        radioGroup.check(R.id.rbCaballo);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Cerdo (View view){
        radioGroup.check(R.id.rbCerdo);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Rana (View view){
        radioGroup.check(R.id.rbRana);
        Toast toast = Toast.makeText(this, getString(R.string.toastCorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Lobo (View view){
        radioGroup.check(R.id.rbLobo);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }



    public void Siguiente (View view) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }

        if (rbRana.isChecked()) {
            contador=contador+10;
        }

        Intent intentDatos = new Intent(this, Animales2.class);
        intentDatos.putExtra("ccontador", contador);
        startActivity(intentDatos);

    }


    public void Menu (View view) {

        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }

        Intent intentActividad = new Intent(this, Menu.class);
        startActivity(intentActividad);
    }


}


