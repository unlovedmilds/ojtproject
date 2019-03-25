package com.example.mondelavictoria.happy_kids_reading;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;

public class Counting_Number extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    TextToSpeech speech;
    int result;
    private static ViewPager mPager;
    private static int currentPage = 0;
    private static int NUM_PAGES = 0;
    private static final Integer[] IMAGES= {R.drawable.zero,R.drawable.one,R.drawable.two,R.drawable.three,R.drawable.four,
            R.drawable.five,R.drawable.six,R.drawable.seven,R.drawable.eight,R.drawable.nine};
    private ArrayList<Integer> ImagesArray = new ArrayList<Integer>();

     Handler handler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counting__number);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        speech = new TextToSpeech(Counting_Number.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = speech.setLanguage(Locale.FRANCE);
                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });

        init();
    }
    private void init() {
        for(int i=0;i<IMAGES.length;i++)
            ImagesArray.add(IMAGES[i]);

        mPager = (ViewPager) findViewById(R.id.pager);


        mPager.setAdapter(new SlidingImage_Adapter(Counting_Number.this,ImagesArray));


        CirclePageIndicator indicator = (CirclePageIndicator)
                findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;

//Set circle indicator radius
        indicator.setRadius(5 * density);

        NUM_PAGES =IMAGES.length;

        // Auto start of viewpager
        handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }

                if(currentPage == 0) {

                    speech.speak("Zero", TextToSpeech.QUEUE_FLUSH, null);
                }else  if(currentPage == 1) {

                    speech.speak("One", TextToSpeech.QUEUE_FLUSH, null);
                }else  if(currentPage == 2) {

                    speech.speak("Two", TextToSpeech.QUEUE_FLUSH, null);
                }else  if(currentPage == 3) {

                    speech.speak("Three", TextToSpeech.QUEUE_FLUSH, null);
                }else  if(currentPage == 4) {

                    speech.speak("Four", TextToSpeech.QUEUE_FLUSH, null);
                }
                else  if(currentPage == 5) {

                    speech.speak("Five", TextToSpeech.QUEUE_FLUSH, null);
                }
                else  if(currentPage == 6) {

                    speech.speak("Six", TextToSpeech.QUEUE_FLUSH, null);
                }
                else  if(currentPage == 7) {

                    speech.speak("Seven", TextToSpeech.QUEUE_FLUSH, null);
                }
                else  if(currentPage == 8) {

                    speech.speak("Eight", TextToSpeech.QUEUE_FLUSH, null);
                }
                else  if(currentPage == 9) {

                    speech.speak("Nine", TextToSpeech.QUEUE_FLUSH, null);
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 2000, 2000);

        // Pager listener over indicator
        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        speech.shutdown();
    }

    @Override
    public void onBackPressed() {
        try {

            if(coverFlow.mediaPlayer1 != null && !CoverFlow.mediaPlayer1.isPlaying())
                coverFlow.mediaPlayer1.start();
        }catch (Exception e){

        }
        super.onBackPressed();

    }
}