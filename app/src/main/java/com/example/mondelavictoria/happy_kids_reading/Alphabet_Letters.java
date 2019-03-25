package com.example.mondelavictoria.happy_kids_reading;

import android.content.pm.ActivityInfo;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.annotation.RequiresApi;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;


public class Alphabet_Letters extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    ViewPager viewPager;
    LinearLayout sliderDotspanel;
    TextView textView;
    private int dotscount;
    private ImageView[] dots;

    TextToSpeech speech;
    int result;
    int i ,x;
    int pos=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_alphabet__letters);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


        speech = new TextToSpeech(Alphabet_Letters.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = speech.setLanguage(Locale.FRANCE);
                    speech.speak("Letter A", TextToSpeech.QUEUE_FLUSH, null);
                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });


        viewPager = (ViewPager) findViewById(R.id.viewPager);

        sliderDotspanel = (LinearLayout) findViewById(R.id.SliderDots);
        ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(this);

        viewPager.setAdapter(viewPagerAdapter);

        dotscount = viewPagerAdapter.getCount();
        dots = new ImageView[dotscount];

        for(int i = 0; i < dotscount; i++){


            dots[i] = new ImageView(this);
            dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));

            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            params.setMargins(4, 0, 4, 0);

            sliderDotspanel.addView(dots[i], params);

        }



        dots[0].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onPageSelected(int position) {

                for(i = 0; i< dotscount; i++){
                    dots[i].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                    dots[position].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
                }

                if(position > 12){
                    dots[pos].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.nonactive_dot));
                    dots[pos].setImageDrawable(ContextCompat.getDrawable(getApplicationContext(), R.drawable.active_dot));
                    pos++;
                }


            }


            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MyTimerTask(), 2000, 4000);

    }


    public class MyTimerTask extends TimerTask {

        @Override
        public void run() {

            Alphabet_Letters.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {

                    if(viewPager.getCurrentItem() == 0){
                        viewPager.setCurrentItem(1);
                        speech.speak("Letter b", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 1){
                        viewPager.setCurrentItem(2);
                        speech.speak("Letter C", TextToSpeech.QUEUE_FLUSH, null);
                    }  else if(viewPager.getCurrentItem() == 2){
                        viewPager.setCurrentItem(3);
                        speech.speak("Letter D", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 3){
                        viewPager.setCurrentItem(4);
                        speech.speak("Letter E ", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 4){
                        viewPager.setCurrentItem(5);
                        speech.speak("Letter F", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 5){
                        viewPager.setCurrentItem(6);
                        speech.speak("Letter G", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 6){
                        viewPager.setCurrentItem(7);
                        speech.speak("Letter H", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 7){
                        viewPager.setCurrentItem(8);
                        speech.speak("Letter I", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 8){
                        viewPager.setCurrentItem(9);
                        speech.speak("Letter J", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 9){
                        viewPager.setCurrentItem(10);
                        speech.speak("Letter K", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 10){
                        viewPager.setCurrentItem(11);
                        speech.speak("Letter L", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 11){
                        viewPager.setCurrentItem(12);
                        speech.speak("Letter M", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 12){
                        viewPager.setCurrentItem(13);
                        speech.speak("Letter N", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 13){
                        viewPager.setCurrentItem(14);
                        speech.speak("Letter O", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 14){
                        viewPager.setCurrentItem(15);
                        speech.speak("Letter P", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 15){
                        viewPager.setCurrentItem(16);
                        speech.speak("Letter Q", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 16){
                        viewPager.setCurrentItem(17);
                        speech.speak("Letter R", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 17){
                        viewPager.setCurrentItem(18);
                        speech.speak("Letter S", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 18){
                        viewPager.setCurrentItem(19);
                        speech.speak("Letter T", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 19){
                        viewPager.setCurrentItem(20);
                        speech.speak("Letter U", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 20){
                        viewPager.setCurrentItem(21);
                        speech.speak("Letter V", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 21){
                        viewPager.setCurrentItem(22);
                        speech.speak("Letter W", TextToSpeech.QUEUE_FLUSH, null);
                    }else if(viewPager.getCurrentItem() == 22){
                        viewPager.setCurrentItem(23);
                        speech.speak("Letter X", TextToSpeech.QUEUE_FLUSH, null);
                    } else if(viewPager.getCurrentItem() == 23){
                        viewPager.setCurrentItem(24);
                        speech.speak("Letter Y", TextToSpeech.QUEUE_FLUSH, null);
                    }else if(viewPager.getCurrentItem() == 24){
                        viewPager.setCurrentItem(25);
                        speech.speak("Letter Z", TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else {
                        viewPager.setCurrentItem(0);
                        pos =0;
                        speech.speak("Letter A", TextToSpeech.QUEUE_FLUSH, null);
                    }
                }
            });

        }
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
