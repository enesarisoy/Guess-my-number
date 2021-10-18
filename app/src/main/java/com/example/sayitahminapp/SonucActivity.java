package com.example.sayitahminapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class SonucActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;
    private Button button3;
    private TextView textViewSonuc;
    private boolean sonuc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sonuc);
        button3 = findViewById(R.id.button3);
        textViewSonuc = findViewById(R.id.textViewSonuc);
        mMediaPlayer = new MediaPlayer();


        sonuc = getIntent().getBooleanExtra("sonuc",false);
        if(sonuc)
        {
            textViewSonuc.setText("HELAAAAAAAAL");

        }else
        {
            textViewSonuc.setText("KAYBETTİN GG");
            mMediaPlayer = MediaPlayer.create(this, R.raw.wasted);
            mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
            mMediaPlayer.setLooping(false);
            mMediaPlayer.start();
        }


        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SonucActivity.this,MainActivity.class));
            }
        });

    }
}