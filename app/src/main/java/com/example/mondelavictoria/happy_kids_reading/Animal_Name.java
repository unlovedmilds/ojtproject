package com.example.mondelavictoria.happy_kids_reading;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ViewSwitcher;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Animal_Name extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    private AppCompatActivity activity;
    MediaPlayer mediaPlayer;
    private SoundPlayer sound;
    private ImageSwitcher simpleImageSwitcher;
    Button btnNext;
    TextView textView2,textView3,textView4,textView0,textViewScore;
    Random rand_set_up_text;
    Random rand_set_up_text1;
    Random rand_set_up_text2;
    int rand_text_set_up,rand_text_set_up1,rand_text_set_up2;
    int last,last_;
    int rand,rand2,rand3,rand4;
    int score;
    int j;
    String v2,v3,v4;

    TextToSpeech speech;
    int result;

    final String []  array =  {"Elephant","Monkey","Mouse","Lion","Penguin","Octopos"};
    final String []  arrayOk =  {"Nice One Kid","That's Correct","That's Great Kid"};
    final String []  arrayWrong =  {"Ops!!! Try Again Kid","That's Not Correct","Sorry Kid, I minus your score"};
    String m,e,l;


    // Array of Image IDs to Show In ImageSwitcher
    int imageIds[] = {R.drawable.elephant1, R.drawable.monkey1, R.drawable.mouse1,
            R.drawable.lion1, R.drawable.pengwin1,R.drawable.octopos};
    int count = imageIds.length;
    // to keep current Index of ImageID array
    int currentIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_animal__name);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        mediaPlayer = MediaPlayer.create(Animal_Name.this,R.raw.melody);
        mediaPlayer.setLooping(true);
        sound = new SoundPlayer(this);

        final ImageView imageView = (ImageView)findViewById(R.id.check);
        imageView.setVisibility(View.INVISIBLE);


        speech = new TextToSpeech(Animal_Name.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = speech.setLanguage(Locale.FRANCE);

                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });

        textView0 = (TextView)findViewById(R.id.textView0);
        textView2 = (TextView)findViewById(R.id.textView2);
        textView3 = (TextView)findViewById(R.id.textView3);
        textView4 = (TextView)findViewById(R.id.textView4);
        textViewScore = (TextView)findViewById(R.id.textViewScore);
        rand_set_up_text = new Random();
        rand_set_up_text1 = new Random();
        rand_set_up_text2 = new Random();


        // get The references of Button and ImageSwitcher
        btnNext = (Button) findViewById(R.id.buttonNext);
        simpleImageSwitcher = (ImageSwitcher) findViewById(R.id.simpleImageSwitcher);

        simpleImageSwitcher .setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        simpleImageSwitcher .setOutAnimation(AnimationUtils.loadAnimation(this,
                android.R.anim.fade_out));



        // Set the ViewFactory of the ImageSwitcher that will create ImageView object when asked
        simpleImageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {

            public View makeView() {
                // TODO Auto-generated method stub

                // Create a new ImageView and set it's properties
                ImageView imageView = new ImageView(getApplicationContext());
                // set Scale type of ImageView to Fit Center
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);


                // set the Height And Width of ImageView To FIll PARENT
                imageView.setLayoutParams(new ImageSwitcher.LayoutParams(LinearLayout.LayoutParams.FILL_PARENT, LinearLayout.LayoutParams.FILL_PARENT));
                return imageView;
            }
        });


        // Declare in and out animations and load them using AnimationUtils class
        Animation in = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(this, android.R.anim.slide_out_right);

        // set the animation type to ImageSwitcher
        simpleImageSwitcher.setInAnimation(in);
        simpleImageSwitcher.setOutAnimation(out);


        // ClickListener for NEXT button
        // When clicked on Button ImageSwitcher will switch between Images
        // The current Image will go OUT and next Image  will come in with specified animation
        btnNext.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                // TODO Auto-generated method stub

                mediaPlayer.start();
                sound.playHitSound();
                imageView.setVisibility(View.INVISIBLE);
                textView0.setVisibility(View.GONE);

                textView2.setTextColor(Color.parseColor("#ffffff"));
                textView3.setTextColor(Color.parseColor("#ffffff"));
                textView4.setTextColor(Color.parseColor("#ffffff"));

                Animation in2 = AnimationUtils.loadAnimation(Animal_Name.this,R.anim.transition);
                textView2.setAnimation(in2);
                Animation in3 = AnimationUtils.loadAnimation(Animal_Name.this,R.anim.transition);
                textView3.setAnimation(in3);
                Animation in4 = AnimationUtils.loadAnimation(Animal_Name.this, R.anim.transition);
                textView4.setAnimation(in4);

                textViewScore.setText(""+ score);
                btnNext.setText("NEXT");
                currentIndex++;
                //  Check If index reaches maximum then reset it
                if (currentIndex == count)
                    currentIndex = 0;

                /*rand_text_set_up = rand_set_up_text.nextInt(array_set_up_text.length - 1);
                textView2.setText(array_set_up_text[rand_text_set_up]);
                last =  rand_text_set_up;

                rand_text_set_up1 = rand_set_up_text1.nextInt(array_set_up_text.length - 1);
                if(last ==  rand_text_set_up1) {
                    textView3.setText(array_set_up_text[rand_text_set_up1 + 1]);
                    last_ =  rand_text_set_up1;
                }else{
                    textView3.setText(array_set_up_text[rand_text_set_up1]);
                    last_ =  rand_text_set_up1;
                }
                rand_text_set_up2 = rand_set_up_text2.nextInt(array_set_up_text.length - 1);

                if(last_ ==  rand_text_set_up1 && last ==  rand_text_set_up) {
                    textView4.setText(array_set_up_text[rand_text_set_up2 + 1]);
                    last_ =  rand_text_set_up1;
                }else{
                    textView4.setText(array_set_up_text[rand_text_set_up2]);
                    last_ =  rand_text_set_up1;
                }*/


               rand = (int)(Math.random()*6);
                simpleImageSwitcher.setImageResource(imageIds[rand]); // set the image in ImageSwitcher
                List<String> shuffle = new ArrayList<String>(Arrays.asList(array));
                for(int i = 0; i <shuffle.size(); i++) {
                    Collections.shuffle(shuffle);
                    for (j = 0; j < shuffle.size(); j++) {
                        System.out.print(shuffle.get(j) + " ");
                        textView2.setText(shuffle.get(0) + " ");
                        textView3.setText(shuffle.get(1) + " ");
                        textView4.setText(shuffle.get(2) + " ");

                        v2 =  textView2.getText().toString().trim();
                        v3 =  textView3.getText().toString().trim();
                        v4 =  textView4.getText().toString().trim();
                        System.out.print("\n");

                    }
                }


                if(rand == 0) {


                    if(    v2.equals("Elephant") ||
                            v3.equals("Elephant") ||
                            v4.equals("Elephant"))

                    {
                        //Toast.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();

                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }
                else if(rand == 1) {


                    if(    v2.equals("Monkey") ||
                           v3.equals("Monkey") ||
                            v4.equals("Monkey"))

                    {
                        //.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();

                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }
                else if(rand == 2) {


                    if(    v2.equals("Mouse") ||
                           v3.equals("Mouse") ||
                           v4.equals("Mouse"))

                    {

                        //Toast.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();
                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }
                else if(rand == 3) {


                    if(    v2.equals("Lion") ||
                            v3.equals("Lion") ||
                           v4.equals("Lion"))

                    {

                        //Toast.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();
                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }
                else if(rand == 4) {


                    if(    v2.equals("Penguin") ||
                           v3.equals("Penguin") ||
                          v4.equals("Penguin"))

                    {
                        //Toast.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();

                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }
                else if(rand == 5) {


                    if(     v2.equals("Octopos") ||
                           v3.equals("Octopos") ||
                           v4.equals("Octopos"))

                    {

                       // Toast.makeText(Animal_Name.this,"Ok",Toast.LENGTH_LONG).show();
                    }else{
                        textView2.setText(shuffle.get(3) + " ");
                        textView3.setText(shuffle.get(4) + " ");
                        textView4.setText(shuffle.get(5) + " ");
                    }

                }

                //Toast.makeText(Animal_Name.this,String.valueOf(rand),Toast.LENGTH_LONG).show();

            }
        });


        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = textView2.getText().toString().trim();
                rand2 = (int)(Math.random()*3);


                if(rand == 1 && val.equals("Monkey")){

                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    //Toast.makeText(Animal_Name.this,"Nice One Kid",Toast.LENGTH_LONG).show();

                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                } else if(rand == 2 && val.equals("Mouse")){
                    //Toast.makeText(Animal_Name.this,"Nice One Kid",Toast.LENGTH_LONG).show();
                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();
                } else if(rand == 3 && val.equals("Lion")){
                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }  else if(rand == 4 && val.equals("Penguin")){
                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }   else if(rand == 5 && val.equals("Octopos")){
                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }  else if(rand == 0 && val.equals("Elephant")){
                    speech.speak(arrayOk[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }  else{
                    speech.speak(arrayWrong[rand2], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score--);
                    textView2.setTextColor(Color.parseColor("#d50000"));
                    update();
                    sound.playOverSound();
                }

            }
        });

        textView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = textView3.getText().toString().trim();
                rand3 = (int)(Math.random()*3);

                if(rand == 1 && val.equals("Monkey")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                } else if(rand == 2 && val.equals("Mouse")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                } else if(rand == 3 && val.equals("Lion")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                } else if(rand == 4 && val.equals("Penguin")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }   else if(rand == 5 && val.equals("Octopos")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                }  else if(rand == 0 && val.equals("Elephant")){
                    speech.speak(arrayOk[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);
                    update();

                } else{
                    speech.speak(arrayWrong[rand3], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score--);
                    textView3.setTextColor(Color.parseColor("#d50000"));
                    sound.playOverSound();
                    update();

                }

            }
        });
        textView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String val = textView4.getText().toString().trim();
                rand4 = (int)(Math.random()*3);

                if(rand == 1 && val.equals("Monkey")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);


                } else if(rand == 2 && val.equals("Mouse")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);


                } else if(rand == 3 && val.equals("Lion")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);

                }  else if(rand == 4 && val.equals("Penguin")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);

                }   else if(rand == 5 && val.equals("Octopos")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);

                }  else if(rand == 0 && val.equals("Elephant")){
                    speech.speak(arrayOk[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score++);
                    imageView.setVisibility(View.VISIBLE);

                }  else{
                    speech.speak(arrayWrong[rand4], TextToSpeech.QUEUE_FLUSH, null);
                    textViewScore.setText(""+ score--);
                    textView4.setTextColor(Color.parseColor("#d50000"));
                    sound.playOverSound();
                    update();
                }

            }
        });
    }


    public void update(){
        textViewScore.setText(""+score);
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