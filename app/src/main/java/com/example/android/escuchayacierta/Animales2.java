package com.example.android.escuchayacierta;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Animales2 extends AppCompatActivity {


    MediaPlayer mediaPlayer;
    RadioGroup radioGroup;
    RadioButton rbElefante;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales2);

        mediaPlayer = MediaPlayer.create(Animales2.this, R.raw.elephan);
        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        rbElefante = (RadioButton) findViewById(R.id.rbElefante);


        Intent intentDatos=getIntent();
        contador= intentDatos.getIntExtra("ccontador", 0);

    }

    public void Play (View view){
        mediaPlayer.start();
    }

    public void Pause (View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void Elefante (View view){
        radioGroup.check(R.id.rbElefante);
        Toast toast = Toast.makeText(this, getString(R.string.toastCorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Insecto (View view){
        radioGroup.check(R.id.rbInsecto);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Leopardo (View view){
        radioGroup.check(R.id.rbLeopardo);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Oveja (View view){
        radioGroup.check(R.id.rbOveja);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }



    public void Siguiente (View view) {
        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        if (rbElefante.isChecked()) {
            contador=contador+10;
        }

        Intent intentDatos = new Intent(this, Resultado.class);
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

