package com.example.mondelavictoria.happy_kids_reading;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.hanks.htextview.base.HTextView;

public class SplashScreen extends AppCompatActivity {

    static MediaPlayer mediaPlayer;
    private HTextView textViewTyper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_splash_screen);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mediaPlayer = MediaPlayer.create(SplashScreen.this,R.raw.doremi);


        int [] image = {R.drawable.monkey,R.drawable.lion,R.drawable.mouse};
        int rand = (int)(Math.random()*3);

        textViewTyper= (HTextView)findViewById(R.id.textViewTyper);
        ImageView imageView = (ImageView)findViewById(R.id.imageView);
       // TextView textView = (TextView)findViewById(R.id.textView);
        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        imageView.setImageResource(image[rand]);
        imageView.startAnimation(animation);
        textViewTyper.startAnimation(animation);

        textViewTyper.animateText("Learning Skills");
        mediaPlayer.start();
        final Intent intent = new Intent(this,CoverFlow.class);
        Thread timer = new Thread(){
            public void run(){
                try {
                    sleep(4500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    startActivity(intent);
                    finish();
                }
            }
        };
        timer.start();
    }
}
