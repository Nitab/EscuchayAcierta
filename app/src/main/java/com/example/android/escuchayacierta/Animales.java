package com.example.android.escuchayacierta;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class Animales extends AppCompatActivity {

    MediaPlayer mediaPlayer;
    RadioGroup radioGroup;
    RadioButton rbGato;
    int contador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animales);
        mediaPlayer = MediaPlayer.create(Animales.this, R.raw.cat);
        radioGroup =(RadioGroup)findViewById(R.id.radioGroup);
        rbGato = (RadioButton) findViewById(R.id.rbGato);

    }

    public void Play (View view){
            mediaPlayer.start();
    }

    public void Pause (View view){
        if (mediaPlayer.isPlaying()){
            mediaPlayer.pause();
        }
    }

    public void Gato (View view){
        radioGroup.check(R.id.rbGato);
        Toast toast = Toast.makeText(this, getString(R.string.toastCorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Perro (View view){
        radioGroup.check(R.id.rbPerro);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Aguila (View view){
        radioGroup.check(R.id.rbAguila);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }

    public void Vaca (View view){
        radioGroup.check(R.id.rbVaca);
        Toast toast = Toast.makeText(this, getString(R.string.toastIncorrecto), Toast.LENGTH_LONG);
        toast.show();
    }



    public void Siguiente (View view){


        if (mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        if (rbGato.isChecked()){
            contador=contador+10;
        }
        Intent intentDatos =new Intent(this, Animales1.class);
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
