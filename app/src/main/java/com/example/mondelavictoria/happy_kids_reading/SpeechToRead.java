package com.example.mondelavictoria.happy_kids_reading;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class SpeechToRead extends AppCompatActivity {

    TextToSpeech speech;
    CoverFlow coverFlow = new CoverFlow();
    static MediaPlayer mediaPlayer;
    private TextView txvResult,textView;
    int rand_,rand,random_color;
    String viewAnswer;

    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;
    TextView first,second;

    boolean changeIcon = false;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    final String [] words = {"Good Evening Sir                              ","Make Your Parents Proud                                ",
            "Be A Good Kid Always                                 ",
            "Happy Mothers Day                                ",
            "Good Morning Mom                                     "};
    final String [] colors = {"blue","red","yellow","white","black"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_speech_to_read);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        speech = new TextToSpeech(SpeechToRead.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    int result = speech.setLanguage(Locale.FRANCE);
                    speech.speak("Read the sentence correctly", TextToSpeech.QUEUE_FLUSH, null);

                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });


        mediaPlayer = MediaPlayer.create(SpeechToRead.this,R.raw.melody4);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();




        txvResult = (TextView) findViewById(R.id.txvResult);
        textView = (TextView) findViewById(R.id.textView);

        //textView.setText(s);
        //textView.setHorizontallyScrolling(true);
        rand_ = (int)(Math.random()*5);

        //textView.setText(words[rand_]);
        textView.setEllipsize(TextUtils.TruncateAt.MARQUEE);
        textView.setSingleLine();
        //textView.setMarqueeRepeatLimit(5);
        textView.setSelected(true);

        first = (TextView) findViewById(R.id.first);
        second = (TextView) findViewById(R.id.second);






        //create quiz array data
        for(int i=0; i < words.length; i++ ) {
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(words[i]); // image name
            tmpArray.add(words[i]); // Right Answer
            tmpArray.add(words[i]); // Choice1
            tmpArray.add(words[i]); //Choice2
            tmpArray.add(words[i]); // Choice3

            quizArray.add(tmpArray);
        }

        showNextQuiz();

    }

    public  void showNextQuiz(){
        //Generate random number from 0 to 4 (quiz array size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        random_color = (int)(Math.random()*5);

        //pick one quiz
        ArrayList<String> quiz = quizArray.get(randomNum);
        viewAnswer = quiz.get(0);
        textView.setText(viewAnswer);
        textView.setTextColor(Color.parseColor(colors[random_color]));

        final ValueAnimator animator = ValueAnimator.ofFloat(0.0f, 1.0f);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setInterpolator(new LinearInterpolator());
        animator.setDuration(9000L);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                final float progress = (float) animation.getAnimatedValue();
                final float width = first.getWidth();
                final float translationX = width * progress;
                first.setTranslationX(translationX);
                second.setTranslationX(translationX - width);
                first.setText(viewAnswer);
                second.setText(viewAnswer);
            }
        });
        animator.start();



        quizArray.remove(randomNum);
    }

    public void getSpeechInput(View view) {

        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE_MODEL, RecognizerIntent.LANGUAGE_MODEL_FREE_FORM);
        intent.putExtra(RecognizerIntent.EXTRA_LANGUAGE, Locale.getDefault());

        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, 10);
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
                    txvResult.setTextColor(Color.parseColor(colors[random_color]));
                    String alertTitle;
                    String res = txvResult.getText().toString().trim();
                    String res1 = textView.getText().toString().trim();
                    if(res.equalsIgnoreCase(res1)){
                        alertTitle = "Correct!!!";
                        rightAnswerCount++;

                        mediaPlayer.start();

                    }else{
                        alertTitle = "Wrong!!!";

                        mediaPlayer.start();
                    }
                    //Create Dialog
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setTitle(alertTitle);
                    builder.setMessage("Answer is: " + viewAnswer);
                    speech.setSpeechRate((float) 0.1);
                    speech.speak(alertTitle + "Answer is: " + viewAnswer, TextToSpeech.QUEUE_FLUSH, null);
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i){

                            if(quizArray.size() < 1){
                                txvResult.setText("");
                                //quizArray is empty
                                showResult();
                            }else{
                                txvResult.setText("");
                                quizCount++;
                                showNextQuiz();
                            }
                        }

                    });
                    builder.setCancelable(false);
                    builder.show();
                }
                break;
        }
    }

    public void showResult(){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Result");
        builder.setMessage(rightAnswerCount+ "/"+quizCount);


        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL);

        final RatingBar rating = new RatingBar(this);
        final TextView textView = new TextView(this);




        LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,
                100, Gravity.CENTER);
        lp.setMargins(25, 0, 0, 0);
        linearLayout.setLayoutParams(lp);

        //add ratingBar to linearLayout

        rating.setLayoutParams(lp);
        rating.setNumStars(5);
        rating.setStepSize(1);
        rating.setRating((float) rightAnswerCount);



        if(rightAnswerCount == quizCount){

            speech.speak("You Got a Perfect Score", TextToSpeech.QUEUE_FLUSH, null);
            textView.setText("You Got a Perfect Score !!!");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLUE);
            textView.setLayoutParams(lp);
        }else if(rightAnswerCount < quizCount && rightAnswerCount > 1){

            speech.speak("You are Good", TextToSpeech.QUEUE_FLUSH, null);
            textView.setText("You are Good !!!");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setLayoutParams(lp);
        }else if(rightAnswerCount <= 1){
            //speech.setSpeechRate((float) 0.2);
            speech.speak("Please Study Hard", TextToSpeech.QUEUE_FLUSH, null);
            textView.setText("Please Study Hard !!!");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setLayoutParams(lp);
        }

        linearLayout.addView(textView);
        linearLayout.addView(rating);



        builder.setIcon(android.R.drawable.btn_star);

        //add linearLayout to dailog
        builder.setView(linearLayout);


        builder.setPositiveButton("Try Again", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                mediaPlayer.stop();
                recreate();
            }

        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                mediaPlayer.stop();
                Intent intent = new Intent(SpeechToRead.this,CoverFlow.class);
                startActivity(intent);
                finish();
            }

        });
        builder.show();
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