package com.example.mondelavictoria.happy_kids_reading;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Locale;
import java.util.Random;

public class ShapeGame extends AppCompatActivity {

    MediaPlayer mediaPlayerRight, mediaPlayerShapeSong;
    TextToSpeech speech;

    private TextView countlabel;
    private ImageView questionImage;
    private Button answerBtn1;
    private Button answerBtn2;
    private Button answerBtn3;
    private Button answerBtn4;


    private String rightAnswer;
    private int rightAnswerCount = 0;
    private int quizCount = 1;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();



    String [][] quizData = {
            //Image Name , Right Answer ,Choice1, Choice2, Choice 3
            {"image_circle", "circle", "triangle", "square", "hexagon"},
            {"image_triangle",  "triangle", "circle", "square", "pentagon"},
            {"image_square", "square", "triangle", "pentagon", "hexagon"},
            {"image_pentagon", "pentagon", "triangle", "circle", "hexagon"},
            {"image_hexagon", "hexagon", "triangle", "pentagon", "circle"},


    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_game);
        countlabel = (TextView)findViewById(R.id.countLabel);
        questionImage = (ImageView)findViewById(R.id.questionImage);
        answerBtn1 = (Button)findViewById(R.id.answerBtn1);
        answerBtn2 = (Button)findViewById(R.id.answerBtn2);
        answerBtn3 = (Button)findViewById(R.id.answerBtn3);
        answerBtn4 = (Button)findViewById(R.id.answerBtn4);

        speech = new TextToSpeech(ShapeGame.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    int result = speech.setLanguage(Locale.FRANCE);
                    speech.speak("Select The Right Answer", TextToSpeech.QUEUE_FLUSH, null);

                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });

        mediaPlayerShapeSong = MediaPlayer.create(ShapeGame.this,R.raw.saveword);
        mediaPlayerShapeSong.setLooping(true);
        mediaPlayerShapeSong.start();


        //create quiz array data
        for(int i=0; i < quizData.length; i++ ){
            //prepare array
            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(quizData[i][0]); // image name
            tmpArray.add(quizData[i][1]); // Right Answer
            tmpArray.add(quizData[i][2]); // Choice1
            tmpArray.add(quizData[i][3]); //Choice2
            tmpArray.add(quizData[i][4]); // Choice3

            quizArray.add(tmpArray);

        }
        showNextQuiz();
    }

    public  void showNextQuiz(){

        //update quizCountLabel
        countlabel.setText("Q:" + quizCount);

        //Generate random number from 0 to 4 (quiz array size -1)
        Random random = new Random();
        int randomNum = random.nextInt(quizArray.size());

        //pick one quiz
        ArrayList<String> quiz = quizArray.get(randomNum);
        //Set image and right answer
        // array format: {"Image Name", "Right Answer", "Choice1","Choice2","Choice3",}
        questionImage.setImageResource(getResources().getIdentifier(quiz.get(0), "drawable", getPackageName()));
        rightAnswer = quiz.get(1);


        Animation animation = AnimationUtils.loadAnimation(this,R.anim.transition);
        questionImage.startAnimation(animation);

        //Remove image name from quiz and shuffle choices

        quiz.remove(0);
        Collections.shuffle(quiz);

        //Set Choices
        answerBtn1.setText(quiz.get(0));
        answerBtn2.setText(quiz.get(1));
        answerBtn3.setText(quiz.get(2));
        answerBtn4.setText(quiz.get(3));

        //Remove this quiz from quizarray
        quizArray.remove(randomNum);

    }

    public  void checkAnswer(View view){

        //Get push button
        Button answerBtn = (Button)findViewById(view.getId());
        String btnText = answerBtn.getText().toString();

        String alertTitle;

        if(btnText.equals(rightAnswer)){
            alertTitle = "Correct";
            rightAnswerCount++;

            mediaPlayerRight = MediaPlayer.create(ShapeGame.this,R.raw.hit);
            mediaPlayerRight.start();

        }else{
            alertTitle = "Wrong";
            mediaPlayerRight = MediaPlayer.create(ShapeGame.this,R.raw.over);
            mediaPlayerRight.start();
        }
        //Create Dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(alertTitle);
        builder.setMessage("Answer is: " + rightAnswer);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){

                if(quizArray.size() < 1){
                    //quizArray is empty
                    showResult();
                }else{
                    quizCount++;
                    showNextQuiz();
                }
            }

        });
        builder.setCancelable(false);
        builder.show();

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
            speech.setSpeechRate((float) 0.3);
            speech.speak("You Got a Perfect Score", TextToSpeech.QUEUE_FLUSH, null);
            textView.setText("You Got a Perfect Score !!!");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLUE);
            textView.setLayoutParams(lp);
        }else if(rightAnswerCount < quizCount && rightAnswerCount > 1){
            speech.setSpeechRate((float) 0.3);
            speech.speak("You are Good", TextToSpeech.QUEUE_FLUSH, null);
            textView.setText("You are Good !!!");
            textView.setTextSize(20);
            textView.setTextColor(Color.BLACK);
            textView.setLayoutParams(lp);
        }else if(rightAnswerCount <= 1){
            speech.setSpeechRate((float) 0.3);
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
                mediaPlayerShapeSong.stop();
                recreate();
            }

        });
        builder.setNegativeButton("Quit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i){
                Intent intent = new Intent(ShapeGame.this,CoverFlow.class);
                intent.putExtra("Value", String.valueOf(rightAnswerCount));
                startActivity(intent);
                mediaPlayerShapeSong.stop();
                finish();
            }

        });
        builder.show();
    }

    @Override
    public void onBackPressed() {
        try {
            mediaPlayerShapeSong.stop();
            finish();
            mediaPlayerShapeSong.pause();
        }catch (Exception e){

        }
        super.onBackPressed();

    }

    @Override
    protected void onResume() {
        super.onResume();
    }
}
