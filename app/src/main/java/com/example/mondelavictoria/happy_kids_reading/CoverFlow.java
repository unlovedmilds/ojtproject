package com.example.mondelavictoria.happy_kids_reading;

import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Locale;

import it.moondroid.coverflow.components.ui.containers.FeatureCoverFlow;

public class CoverFlow extends AppCompatActivity {

    private FeatureCoverFlow coverFlow;
    private CoverFlowAdapter adapter;
    private ArrayList<Game> games;

    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    Handler handler;

    static MediaPlayer mediaPlayer1;

    TextToSpeech speech;
    int result,count = 0;
    int [] raw = {R.raw.melody1,R.raw.melody2};
    int [] iv = {R.drawable.audiowaves};
    int rand;

    ImageView imageView;
    boolean changeIcon = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cover_flow);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.kidss);


        imageView = (ImageView)findViewById(R.id.wave);

        rand = (int)(Math.random()*2);
        mediaPlayer1 = MediaPlayer.create(CoverFlow.this,raw[rand]);
        mediaPlayer1.setLooping(true);
        mediaPlayer1.start();


        ImageView imageView = (ImageView)findViewById(R.id.image);
        coverFlow = (FeatureCoverFlow) findViewById(R.id.coverflow);

        settingDummyData();
        adapter = new CoverFlowAdapter(this, games);
        coverFlow.setAdapter(adapter);
        coverFlow.setOnScrollPositionListener(onScrollListener());

        speech = new TextToSpeech(CoverFlow.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = speech.setLanguage(Locale.FRANCE);
                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(count == 0) {
                    speech.speak("Hello, My name is Princess", TextToSpeech.QUEUE_FLUSH, null);
                    count++;
                }
                else if(count == 1) {
                    speech.speak("Hi, My name is Mike", TextToSpeech.QUEUE_FLUSH, null);
                    count++;
                }
                else if(count == 2) {
                    speech.speak("Hi, My name is John", TextToSpeech.QUEUE_FLUSH, null);
                    count = 0;
                }
            }
        });
    }

    private FeatureCoverFlow.OnScrollPositionListener onScrollListener() {
        return new FeatureCoverFlow.OnScrollPositionListener() {
            @Override
            public void onScrolledToPosition(int position) {
                Log.v("MainActiivty", "position: " + position);


            }

            @Override
            public void onScrolling() {
                Log.i("MainActivity", "scrolling");

            }
        };
    }

    private void settingDummyData() {
        games = new ArrayList<>();
        games.add(new Game(R.drawable.phonic, "Phonics"));
        games.add(new Game(R.drawable.wordgame, "Words Usage"));
        games.add(new Game(R.drawable.read, "Reading Skills"));
        games.add(new Game(R.drawable.guesswho, "Guessing Game"));
        games.add(new Game(R.drawable.numbercounting, "Counting Numbers"));
        games.add(new Game(R.drawable.ruzzle, "Ruzzle Game"));
        games.add(new Game(R.drawable.dragdrops, "Drag and Drop"));
        games.add(new Game(R.drawable.alpha, "Word Save"));
        games.add(new Game(R.drawable.mathinokids, "Mathino Kids"));
        /*games.add(new Game(R.mipmap.ic_launcher_round, "Swipe Word"));
        games.add(new Game(R.mipmap.ic_launcher_round, "The Witcher 3"));
        games.add(new Game(R.mipmap.ic_launcher, "Tom raider 3"));
        games.add(new Game(R.mipmap.ic_launcher_round, "Need for Speed Most Wanted"));*/



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_coverflow, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notes) {
            if (changeIcon == false) {
                item.setIcon(R.drawable.notes);
                mediaPlayer1.stop();
                imageView.setImageResource(R.drawable.waveaudios);
                changeIcon = true;

            } else if (changeIcon == true) {
                item.setIcon(R.drawable.notesoff);
                mediaPlayer1 = MediaPlayer.create(CoverFlow.this,raw[rand]);
                mediaPlayer1.start();
                imageView.setImageResource(R.drawable.waveaudio);
                changeIcon = false;
            }
        }
        return super.onOptionsItemSelected(item);
    }


    final int time_interval = 2000;;
    long mback;
    boolean off= false;
    @Override
    public void onBackPressed() {

        if(off == false) {
            try {
                mediaPlayer1.pause();
                off = true;
            } catch (Exception e) {

            }
        }else {
            mediaPlayer1.start();
            off = false;
        }

        if(mback + time_interval > System.currentTimeMillis()){

            mediaPlayer1.stop();
            super.onBackPressed();


        }else{
            mback = System.currentTimeMillis();
            Toast.makeText(this,"Please, click back again to exit",Toast.LENGTH_SHORT).show();


        }



    }
}
