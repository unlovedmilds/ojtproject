package com.example.mondelavictoria.happy_kids_reading;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    TextToSpeech speech;
    int result;
    TextView textView1;
    String randomElement;

    GridView myListView;
    List<String> your_array_list = new ArrayList<String>();


    ListView list;
    String[] itemname ={
            "Apple",
            "Banana",
            "Car",
            "Dog",
            "Elephant",
            "Flower",
            "Grapes",
            "Hammer"
    };

    Integer[] imgid={
            R.drawable.apples,
            R.drawable.bananas,
            R.drawable.car,
            R.drawable.dog,
            R.drawable.elephant,
            R.drawable.flower,
            R.drawable.grapes,
            R.drawable.hammer,
    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);



        speech = new TextToSpeech(MainActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i == TextToSpeech.SUCCESS) {
                    result = speech.setLanguage(Locale.FRANCE);
                } else {
                    Toast.makeText(getApplicationContext(), "Faild", Toast.LENGTH_LONG).show();
                }
            }
        });

        CustomListAdapter adapter = new CustomListAdapter(this, itemname, imgid);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                // TODO Auto-generated method stub
                String Slecteditem = itemname[+position];
                speech.speak(Slecteditem, TextToSpeech.QUEUE_FLUSH, null);

                try {
                    Thread.sleep(1000);

                    if(position == 0) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "A-P-P-L-E";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else if(position == 1) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "B-A-N-A-N-A";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }

                    else if(position == 2) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "C-A-R";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }

                    else if(position == 3) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "D-O-G";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else if(position == 4) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "E-L-E-P-H-A-N-T";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else if(position == 5) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "F-L-O-W-E-R";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else if(position == 6) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "G-R-A-P-E-S";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }
                    else if(position == 7) {
                        speech.setSpeechRate((float) 0.3);
                        String car = "H-A-M-M-E-R";
                        speech.speak(car, TextToSpeech.QUEUE_FLUSH, null);
                    }

                    //Toast.makeText(getApplicationContext(), Slecteditem, Toast.LENGTH_SHORT).show();
                }catch (Exception e){}

            }
        });


       /* myListView = (GridView)findViewById(R.id.mainListView);
       // your_array_list.get(new Random().nextInt( your_array_list.size()));
        //Populate the array


        your_array_list.add("Apple");
        your_array_list.add("Banana");
        your_array_list.add("Carrots");
        your_array_list.add("Dad");
        your_array_list.add("Eagle");
        your_array_list.add("Friend");
        your_array_list.add("Joker");
        your_array_list.add("Hello");
        your_array_list.add("Impossible");
        your_array_list.add("Great");


        your_array_list.get(new Random().nextInt( your_array_list.size()));*/
        /*Random rand = new Random();
        List<String> givenList = Arrays.asList("one", "two", "three", "four");

        int numberOfElements = 2;

        for (int i = 0; i < numberOfElements; i++) {
            int randomIndex = rand.nextInt(givenList.size());
            randomElement = givenList.get(randomIndex);
        }*/


        //set array to adapter
    }

    /*@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }*/

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
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