package com.example.mondelavictoria.happy_kids_reading;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

public class SpeechToRead extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    MediaPlayer mediaPlayer;
    private TextView txvResult,textView;
    ImageView imageView;
    int rand_,rand;

    final String [] words = {"Don't Forget to Smile                           ","Make Your Parents Proud                                ",
            "Be A Good Kid Always                                 ",
            "Happy New Year                                     "};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_speech_to_read);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mediaPlayer = MediaPlayer.create(SpeechToRead.this,R.raw.melody4);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();

        txvResult = (TextView) findViewById(R.id.txvResult);
        textView = (TextView) findViewById(R.id.textView);

        //textView.setText(s);
        //textView.setHorizontallyScrolling(true);
        rand_ = (int)(Math.random()*4);
        textView.setText(words[rand_]);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSingleLine();
        //textView.setMarqueeRepeatLimit(5);
        textView.setSelected(true);

        imageView = (ImageView)findViewById(R.id.ok);
        imageView.setVisibility(View.GONE);

    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
            imageView.setVisibility(View.GONE);
            mediaPlayer.pause();

        } else {
            Toast.makeText(this, "Your Device Don't Support Speech Input", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 10:
                if (resultCode == RESULT_OK && data != null) {
                    ArrayList<String> result = data.getStringArrayListExtra(RecognizerIntent.EXTRA_RESULTS);
                    txvResult.setText(result.get(0));

                    String res = txvResult.getText().toString().trim();
                    String res1 = textView.getText().toString().trim();
                    if(res.equalsIgnoreCase(res1)){
                        Toast.makeText(this, "Good", Toast.LENGTH_SHORT).show();
                        rand = (int)(Math.random()*4);
                        textView.setText(words[rand]);
                        imageView.setVisibility(View.VISIBLE);
                        mediaPlayer.start();

                    }else{
                        Toast.makeText(this, "Ops!!", Toast.LENGTH_SHORT).show();
                        mediaPlayer.start();
                    }
                    if(rand_ == rand){
                        rand = (int)(Math.random()*4);
                        textView.setText(words[rand]);
                    }else{

                    }
                }
                break;
        }
    }
    @Override
    public void onBackPressed() {
        try {
            mediaPlayer.stop();
            finish();
            if(coverFlow.mediaPlayer1 != null && !CoverFlow.mediaPlayer1.isPlaying())
                coverFlow.mediaPlayer1.start();
        }catch (Exception e){

        }
        super.onBackPressed();

    }
}