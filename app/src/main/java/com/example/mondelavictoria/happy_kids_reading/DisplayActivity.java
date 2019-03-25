package com.example.mondelavictoria.happy_kids_reading;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.ZoomControls;

public class DisplayActivity extends AppCompatActivity {

    String paragraphString = "";
    TextView displayTextView;
    ZoomControls textZoomControls;
    float textSize = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);

        displayTextView = (TextView) findViewById(R.id.displayTextView);
        textZoomControls = (ZoomControls) findViewById(R.id.textZoomControl);

        //getting the value set from the other activity passed by the keyword paragraph
        Intent intent = getIntent();
        paragraphString = intent.getExtras().getString("paragraph");

        displayTextView.setText(paragraphString);

        //retrieving the size of the current textview size
        textSize = displayTextView.getTextSize();

        textZoomControls.setOnZoomInClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //incrementing size and setting textsize to the new value
                textSize++;

                displayTextView.setTextSize(textSize);
            }
        });

        textZoomControls.setOnZoomOutClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //incrementing size and setting textsize to the new value
                textSize--;

                displayTextView.setTextSize(textSize);

            }
        });
    }

}