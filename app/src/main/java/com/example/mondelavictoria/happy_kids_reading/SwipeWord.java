package com.example.mondelavictoria.happy_kids_reading;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.Toast;

public class SwipeWord extends AppCompatActivity {

    ImageView imageView1,imageView2;
    String val = "";
    String v1,v2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_word);

        imageView1 = (ImageView)findViewById(R.id.imageView1);
        imageView2 = (ImageView)findViewById(R.id.imageView2);


        imageView1.setOnTouchListener(new OnSwipeTouchListener(SwipeWord.this) {
            public void onSwipeTop() {
                Toast.makeText(SwipeWord.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                Toast.makeText(SwipeWord.this, "right", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeLeft() {
                Toast.makeText(SwipeWord.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {

                v1 = "Bottom";
                Toast.makeText(SwipeWord.this, v1, Toast.LENGTH_SHORT).show();
            }

        });
        imageView2.setOnTouchListener(new OnSwipeTouchListener(SwipeWord.this) {
            public void onSwipeTop() {
                Toast.makeText(SwipeWord.this, "top", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeRight() {
                v2 = "Right";

            }
            public void onSwipeLeft() {
                Toast.makeText(SwipeWord.this, "left", Toast.LENGTH_SHORT).show();
            }
            public void onSwipeBottom() {

            }

        });

        val = v1 + v2;
        Toast.makeText(SwipeWord.this, val, Toast.LENGTH_SHORT).show();

    }
}
