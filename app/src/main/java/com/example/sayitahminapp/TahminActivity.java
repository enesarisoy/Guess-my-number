package com.example.sayitahminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class TahminActivity extends AppCompatActivity {
    private Button button2;
    private EditText editTextsayi;
    private TextView textViewHak, textViewYardim;
    private int rastgeleSayi;
    private int sayac = 5;
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tahmin);

        button2 = findViewById(R.id.button2);
        editTextsayi = findViewById(R.id.editTextsayi);
        textViewYardim = findViewById(R.id.textViewYardim);
        textViewHak = findViewById(R.id.textViewHak);

        Random r = new Random();
        rastgeleSayi = r.nextInt(101);
        Log.e("Rastgele sayi : ", String.valueOf(rastgeleSayi));



        button2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {



                sayac = sayac - 1;
                int tahmin = Integer.parseInt(editTextsayi.getText().toString());
                if(tahmin == rastgeleSayi)
                {
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",true);
                    startActivity(i);
                    finish();
                    return;
                }
                if(tahmin > rastgeleSayi)
                {
                    textViewYardim.setVisibility(View.VISIBLE);
                    textViewYardim.setText("AZALT");
                    textViewHak.setText("Kalan hak : " + sayac);
                    if(sayac!=0)
                    {
                    mMediaPlayer = MediaPlayer.create(TahminActivity.this, R.raw.puh);
                    mMediaPlayer.start();

                    }
                }
                if(tahmin < rastgeleSayi)
                {
                    textViewYardim.setVisibility(View.VISIBLE);
                    textViewYardim.setText("ARTTIR");
                    textViewHak.setText("Kalan hak : " + sayac);
                    if(sayac!=0)
                    {
                        mMediaPlayer = MediaPlayer.create(TahminActivity.this, R.raw.puh);
                        mMediaPlayer.start();

                    }

                }
                if(sayac==0)
                {
                    Intent i = new Intent(TahminActivity.this,SonucActivity.class);
                    i.putExtra("sonuc",false);
                    startActivity(i);
                    finish();
                    return;
                }

                editTextsayi.setText("");

            }
        });


    }
}