package com.example.media_development;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;

public class Audio extends AppCompatActivity {


    MediaPlayer mediaplayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaplayer=null;
    }
    public void music(View view) {
        switch(view.getId()){
            case R.id.button5:
                if(mediaplayer == null){
                    mediaplayer = MediaPlayer.create(this,R.raw.music);
                }
                mediaplayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mp) {
                        stopMusic();
                    }
                });
                mediaplayer.start();
                break;
            case R.id.button3:
                if(mediaplayer != null){
                    mediaplayer.pause();
                }
                break;
            case R.id.button4:
                if(mediaplayer != null){
                    mediaplayer.stop();
                    stopMusic();
                }
                break;
        }
    }
    private void stopMusic(){
        mediaplayer.release();
        mediaplayer=null;
    }
    @Override
    protected void onStop(){
        super.onStop();
        stopMusic();
    }
}
