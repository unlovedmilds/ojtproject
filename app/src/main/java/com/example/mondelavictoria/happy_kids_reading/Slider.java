package com.example.mondelavictoria.happy_kids_reading;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.gigamole.infinitecycleviewpager.HorizontalInfiniteCycleViewPager;

import java.util.ArrayList;
import java.util.List;

public class Slider extends AppCompatActivity {
    List<Integer> listImages = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slider);

        listImages.add(R.mipmap.ic_launcher);
        listImages.add(R.mipmap.ic_launcher_round);
        listImages.add(R.mipmap.ic_launcher);

        HorizontalInfiniteCycleViewPager pager = (HorizontalInfiniteCycleViewPager)findViewById(R.id.horizontal_cycle);
        MyAdapter adapter = new MyAdapter(listImages,getBaseContext());
        pager.setAdapter(adapter);


    }


}