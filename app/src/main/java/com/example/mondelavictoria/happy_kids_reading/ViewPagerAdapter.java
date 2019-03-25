package com.example.mondelavictoria.happy_kids_reading;

import android.content.Context;
import android.speech.tts.TextToSpeech;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

/**
 * Created by Rey Dela Victoria on 9/5/2018.
 */

public class ViewPagerAdapter extends PagerAdapter{

    TextToSpeech speech;
    int result;

    private Context context;
    private LayoutInflater layoutInflater;
    private Integer [] images = {R.drawable.a1,R.drawable.b1,R.drawable.c1,
            R.drawable.d1,R.drawable.e1,R.drawable.f1,
            R.drawable.g1,R.drawable.h1,R.drawable.l1,
            R.drawable.j1,R.drawable.k1,R.drawable.l1,
            R.drawable.m1,R.drawable.n1,R.drawable.o1,
            R.drawable.p1,R.drawable.q1,R.drawable.r1,
            R.drawable.s1,R.drawable.t1,R.drawable.u1,
            R.drawable.v1,R.drawable.w1,R.drawable.x1,
            R.drawable.y1,R.drawable.z};

    public ViewPagerAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.custom_layout, null);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView);
        imageView.setImageResource(images[position]);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if(position == 0){
                    //Toast.makeText(context, "Slide A", Toast.LENGTH_SHORT).show();

                } else if(position == 1){
                    //Toast.makeText(context, "Slide b", Toast.LENGTH_SHORT).show();

                } else {
                    //Toast.makeText(context, "Slide C", Toast.LENGTH_SHORT).show();

                }

            }
        });

        ViewPager vp = (ViewPager) container;
        vp.addView(view, 0);
        return view;

    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {

        ViewPager vp = (ViewPager) container;
        View view = (View) object;
        vp.removeView(view);

    }
}