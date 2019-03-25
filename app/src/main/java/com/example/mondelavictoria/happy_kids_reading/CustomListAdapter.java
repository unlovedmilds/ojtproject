package com.example.mondelavictoria.happy_kids_reading;

import android.app.Activity;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Mon Dela Victoria on 8/30/2018.
 */

public class CustomListAdapter extends ArrayAdapter <String> {
    private final Activity context;
    private final String[] itemname;
    private final Integer[] imgid;

    public CustomListAdapter(Activity context, String[] itemname, Integer[] imgid) {
        super(context, R.layout.mylist, itemname);
        // TODO Auto-generated constructor stub

        this.context=context;
        this.itemname=itemname;
        this.imgid=imgid;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.mylist, null,true);

        TextView txtTitle = (TextView) rowView.findViewById(R.id.item);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        TextView extratxt = (TextView) rowView.findViewById(R.id.textView1);

        txtTitle.setText(itemname[position]);
        imageView.setImageResource(imgid[position]);
        extratxt.setText("Description "+itemname[position]);

        if( position % 2 == 1){
            rowView.setBackgroundColor(Color.parseColor("#ffb300"));
        }else{
            rowView.setBackgroundColor(Color.parseColor("#ffffff"));
        }

        /*// Get the Layout Parameters for ListView Current Item View
        ViewGroup.LayoutParams params = rowView.getLayoutParams();

        // Set the height of the Item View
        params.height = 100;
        rowView.setLayoutParams(params);*/

        return rowView;

    }
}
