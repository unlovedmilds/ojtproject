package com.example.mondelavictoria.happy_kids_reading;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mon Dela Victoria on 8/30/2018.
 */

public class CoverFlowAdapter extends BaseAdapter {
    private ArrayList<Game> data;
    private AppCompatActivity activity;


    public CoverFlowAdapter(AppCompatActivity context, ArrayList<Game> objects) {
        this.activity = context;
        this.data = objects;

    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Game getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.item_flow_view, null, false);

            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.gameImage.setImageResource(data.get(position).getImageSource());
        viewHolder.gameName.setText(data.get(position).getName());

        convertView.setOnClickListener(onClickListener(position));

        return convertView;
    }



    private View.OnClickListener onClickListener(final int position) {
        return new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                final Dialog dialog = new Dialog(activity);
                dialog.setContentView(R.layout.dialog_game_info);
                dialog.setCancelable(true); // dimiss when touching outside
                dialog.setTitle("Game Details");

                TextView text = (TextView) dialog.findViewById(R.id.name);
                text.setText(getItem(position).getName());
                ImageView image = (ImageView) dialog.findViewById(R.id.image);
                image.setImageResource(getItem(position).getImageSource());



               // dialog.show();
                if(position == 0) {
                    Intent intent = new Intent(activity, MainActivity.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                } else if(position == 1) {
                    Intent intent = new Intent(activity, Alphabet_Letters.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                } else if(position == 2) {
                    Intent intent = new Intent(activity, SpeechToRead.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                } else if(position == 3) {
                    Intent intent = new Intent(activity, Animal_Name.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                } else if(position == 4) {
                    Intent intent = new Intent(activity, Counting_Number.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 5) {
                    Intent intent = new Intent(activity, Puzzle_Game.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 6) {
                    Intent intent = new Intent(activity, Drag_Drop_Game.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 7) {
                    Intent intent = new Intent(activity, Word_Save.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 8) {
                    Intent intent = new Intent(activity, Mathino_Kids.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 9) {
                    Intent intent = new Intent(activity, ShapeGame.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else if(position == 10) {
                    Intent intent = new Intent(activity, SodukoGame.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }else {
                    Intent intent = new Intent(activity, SodukoPuzzle.class);
                    CoverFlow.mediaPlayer1.pause();
                    activity.startActivity(intent);

                }

            }

        };

    }


    private static class ViewHolder {
        private TextView gameName;
        private ImageView gameImage;

        public ViewHolder(View v) {
            gameImage = (ImageView) v.findViewById(R.id.image);
            gameName = (TextView) v.findViewById(R.id.name);
        }
    }




}


