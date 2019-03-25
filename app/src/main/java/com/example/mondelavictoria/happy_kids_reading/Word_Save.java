package com.example.mondelavictoria.happy_kids_reading;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import io.netopen.hotbitmapgg.library.view.RingProgressBar;

public class Word_Save extends AppCompatActivity {

    public int score = 00;
    public int topscore = 00;
    int x=0;
    int _score;
    Thread  t;
    CoverFlow coverFlow = new CoverFlow();
    MediaPlayer mediaPlayer;
    MediaPlayer mediaPlayer1;
    MediaPlayer saveWord;
    private String display = " ";
    private static AlertDialog dialog;
    String val;
    boolean ok = false;
    boolean oke1 = false;
    boolean oke2 = false;
    boolean oke3 = false;
    final String []  array =  {"KIDS","CART","BAIT"};
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btn10,btn11,btn12;
    Button btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9;
    ImageView imageViewWinning;
    TextView textView5;
    RingProgressBar progressBar;
    ProgressBar progressBars;
    int progress = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_word__save);
        textView5 = (TextView)findViewById(R.id.textView5);
        handler = new Handler(){

            public void handleMessage(Message msg){
                if (msg.what == 0) {
                    if(progress < 100){
                        progress++;
                        progressBar.setProgress(progress);

                        textView5.setText("Time Left:"+ String.valueOf(progress));
                    }if(progress >= 70){
                        progressBar.setRingProgressColor(Color.parseColor("red"));
                    }
                    if(progress == 100){
                        textView5.setText("You Are Running Out Of Time 00:");

                    }
                }
            }
        };



        imageViewWinning = (ImageView)findViewById(R.id.winning);
        imageViewWinning.setVisibility(View.INVISIBLE);

        progressBars = (ProgressBar)findViewById(R.id.progressBars);
        progressBar = (RingProgressBar)findViewById(R.id.progressBar);
        progressBar.setOnProgressListener(new RingProgressBar.OnProgressListener() {

            @Override
            public void progressToComplete() {
                final Dialog dialog = new Dialog(Word_Save.this);
                dialog.setContentView(R.layout.gameover_dialog);
                final Button gameover = (Button)dialog.findViewById(R.id.gameover);
                // set width for dialog
                //int width = (int) (Word_Save.this.getResources().getDisplayMetrics().widthPixels * 0.95);
                // set height for dialog
                //int height = (int) (Word_Save.this.getResources().getDisplayMetrics().heightPixels * 0.5);
                //dialog.getWindow().setLayout(width, height);
                //dialog.getWindow().setBackgroundDrawable(null);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
                try {
                    dialog.show();
                }catch (Exception e){}


                gameover.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dialog.dismiss();

                        Intent intent = new Intent(Word_Save.this,Word_Save.class);
                        startActivity(intent);
                        finish();
                    }
                });
            }

        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0;i<100;i++){
                    try {
                        Thread.sleep(200);
                        handler.sendEmptyMessage(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        saveWord = MediaPlayer.create(Word_Save.this,R.raw.saveword);
        saveWord.setLooping(true);
        if( !saveWord.isPlaying()) {
            saveWord.stop();
        }

        btn1 = (Button) findViewById(R.id.button1);
        btn2 = (Button) findViewById(R.id.button2);
        btn3 = (Button) findViewById(R.id.button3);
        btn4 = (Button) findViewById(R.id.button4);
        //btn5 = (Button) findViewById(R.id.button5);
        //btn6 = (Button) findViewById(R.id.button6);
        btn7 = (Button) findViewById(R.id.button7);
        btn8 = (Button) findViewById(R.id.button8);
        btn9 = (Button) findViewById(R.id.button9);
        btn10 = (Button) findViewById(R.id.button10);
        btn11 = (Button) findViewById(R.id.button11);
        btn12 = (Button) findViewById(R.id.button12);

        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);


        //btn1.setVisibility(View.INVISIBLE);
        //btn2.setVisibility(View.INVISIBLE);
        //btn3.setVisibility(View.INVISIBLE);
        //btn4.setVisibility(View.INVISIBLE);
       // btn5.setVisibility(View.GONE);
        //btn6.setVisibility(View.GONE);
        btn8.setVisibility(View.INVISIBLE);
        btn11.setVisibility(View.INVISIBLE);

        List<String> shuffle = new ArrayList<String>(Arrays.asList(array));
        for(int i = 0; i <shuffle.size(); i++) {
            Collections.shuffle(shuffle);
            for (int j = 0; j < shuffle.size(); j++) {

                val = shuffle.get(0) + " ";

            }
        }
        for(int x = 0; x < val.length(); x++) {
            btn7.setText(Character.toString(val.charAt(3)));
            btn10.setText(Character.toString(val.charAt(0)));
            btn9.setText(Character.toString(val.charAt(2)));
            btn12.setText(Character.toString(val.charAt(1)));
        }

       /* btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                btn7.startAnimation(animation1);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                btn9.startAnimation(animation1);
            }
        });
        btn10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                btn10.startAnimation(animation1);
            }
        });
        btn12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
                btn12.startAnimation(animation1);
            }
        });*/
    }

    public void onClickLetter(View v) {

        Button b = (Button) v;

        //Animation animations = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
        //b.startAnimation(animations);

        mediaPlayer = MediaPlayer.create(Word_Save.this,R.raw.hit);
        mediaPlayer.start();

        if(oke1 || oke2 || oke3){
            btn1.setText("");
            btn2.setText("");
            btn3.setText("");
            btn4.setText("");
            oke1 = false;
            oke2 = false;
            oke3 = false;
        }

        if (btn1.getText().toString().isEmpty()) {
            btn1.setText(b.getText());
            btn1.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            //btn1.startAnimation(animation);

        }
        else if(!btn1.getText().toString().isEmpty() && btn2.getText().toString().isEmpty()){
            btn2.setText(b.getText());
            btn2.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
           // btn2.startAnimation(animation);

        }
        else if(!btn1.getText().toString().isEmpty() && !btn2.getText().toString().isEmpty() && btn3.getText().toString().isEmpty()){
            btn3.setText(b.getText());
            btn3.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            //btn3.startAnimation(animation);

        }
        else if(!btn1.getText().toString().isEmpty() && !btn2.getText().toString().isEmpty() && !btn3.getText().toString().isEmpty()
                && btn4.getText().toString().isEmpty()){
            btn4.setText(b.getText());
           btn4.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            //btn4.startAnimation(animation);


        }
        String v1 = btn1.getText().toString();
        String v2 = btn2.getText().toString();
        String v3 = btn3.getText().toString();
        String v4 = btn4.getText().toString();

        display = v1+v2+v3+v4;
        if(display.contentEquals("KIDS") || display.contentEquals("CART") || display.contentEquals("BAIT")){
            btn_1.setText(v1);
            btn_2.setText(v2);
            btn_3.setText(v3);
            btn_4.setText(v4);

            oke1 = true;
            score = score + 10;
            display = "";
        }if(!ok)
            if(display.contentEquals("KID") || display.contentEquals("ART") || display.contentEquals("BIT")){
            btn_5.setText(v1);
            btn_6.setText(v2);
            btn_7.setText(v3);

                display = "";
                score = score + 5;
                ok = true;
                oke2 = true;


        }if(display.contentEquals("IS") || display.contentEquals("AT") || display.contentEquals("IT")){
            btn_8.setText(v1);
            btn_9.setText(v2);

                score = score + 3;
                oke3 = true;


        }
        if( !btn_1.getText().toString().isEmpty() && !btn_2.getText().toString().isEmpty() && !btn_3.getText().toString().isEmpty() &&
                !btn_4.getText().toString().isEmpty() && !btn_5.getText().toString().isEmpty() && !btn_6.getText().toString().isEmpty() &&
                !btn_7.getText().toString().isEmpty() && !btn_8.getText().toString().isEmpty() && !btn_9.getText().toString().isEmpty()){
            progress = 101;
            final Dialog dialog = new Dialog(Word_Save.this);
            dialog.setContentView(R.layout.winning_dialog);
            final Button winner = (Button)dialog.findViewById(R.id.winner);
            final TextView scores = (TextView)dialog.findViewById(R.id.textViewScore);
            final TextView topscores = (TextView)dialog.findViewById(R.id.textViewTopScore);


            topscores.setText(String.valueOf(topscore));
            // set width for dialog
            //int width = (int) (this.getResources().getDisplayMetrics().widthPixels * 0.95);
            // set height for dialog
            //int height = (int) (this.getResources().getDisplayMetrics().heightPixels * 0.5);
            //dialog.getWindow().setLayout(width, height);
            //dialog.getWindow().setBackgroundDrawable(null);
            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;

            imageViewWinning.setVisibility(View.VISIBLE);
            Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_in);
            imageViewWinning.startAnimation(animation);

            try {
                dialog.show();

            }catch (Exception e){}
            try {

            new Thread(new Runnable() {
                public void run() {
                    while (score > x) {
                        _score += 1;
                        // Update the progress bar and display the current value in the text view

                        handler.post(new Runnable() {
                            public void run() {
                                progressBars.setProgress(_score);
                                scores.setText(String.valueOf(_score));
                            }
                        });
                        x++;
                    }

                }
            }).start();

            }catch (Exception e){}
            winner.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Intent intent = new Intent(Word_Save.this,Word_Save.class);
                    startActivity(intent);
                    imageViewWinning.setVisibility(View.INVISIBLE);
                    if( saveWord.isPlaying())
                        saveWord.stop();
                    finish();
                }
            });


        }

    }

    public void onClickCancel1(View v){btn1.setText("");
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
    }
    public void onClickCancel2(View v){
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
        btn2.setText("");
    }
    public void onClickCancel3(View v){
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
        btn3.setText("");
    }
    public void onClickCancel4(View v){
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
        btn4.setText("");}
    public void onClickCancel5(View v){
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
        btn5.setText("");}
    public void onClickCancel6(View v){
        mediaPlayer1 = MediaPlayer.create(Word_Save.this,R.raw.over);
        mediaPlayer1.start();
        btn6.setText("");}

    @Override
    public void onBackPressed() {
        try {
            saveWord.stop();
            finish();
            saveWord.pause();
            if(coverFlow.mediaPlayer1 != null && !CoverFlow.mediaPlayer1.isPlaying())
                coverFlow.mediaPlayer1.start();
        }catch (Exception e){

        }
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
