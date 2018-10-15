package com.example.imtiazaminsajid.flyingbird;

import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    private GameView gameView;

    private MediaPlayer mediaPlayer;

    private boolean isPlaying = false;

    private Handler handler = new Handler();

    private final static long TIMER_INTERVEL = 30;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

//        if (!isPlaying){
//            mediaPlayer = MediaPlayer.create(this, R.raw.backgroundaudio);
//            mediaPlayer.setLooping(true);
//            mediaPlayer.start();
//            isPlaying = true;
//        } else {
//            mediaPlayer.stop();
//            mediaPlayer.reset();
//            isPlaying=false;
//        }

        gameView =  new GameView(this);
        setContentView(gameView);




        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        gameView.invalidate();
                    }
                });

            }
        }, 0, TIMER_INTERVEL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        gameView.media();
    }
}
