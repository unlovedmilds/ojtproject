package com.example.mondelavictoria.happy_kids_reading;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Mon Dela Victoria on 8/30/2018.
 */

public class MyAdapter extends PagerAdapter {
    List<Integer> listImages;
    Context context;
    LayoutInflater layoutInflater;
    public MyAdapter( List<Integer> listImages,Context context){
        this.listImages = listImages;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return listImages.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view = layoutInflater.inflate(R.layout.adapter,container,false);
        ImageView imageView = (ImageView)view.findViewById(R.id.imageView);
        imageView.setImageResource(listImages.get(position));
        container.addView(view);

        return view;


    }
}
