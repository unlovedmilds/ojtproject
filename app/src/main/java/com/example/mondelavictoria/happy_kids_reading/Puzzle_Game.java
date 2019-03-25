package com.example.mondelavictoria.happy_kids_reading;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Random;

public class Puzzle_Game extends AppCompatActivity {
    private static GestureDetectGridView_Puzzle mGridView;

    CoverFlow coverFlow = new CoverFlow();
    private static final int COLUMNS = 3;
    private static final int DIMENSIONS = COLUMNS * COLUMNS;

    private static int mColumnWidth, mColumnHeight;

    public static final String up = "up";
    public static final String down = "down";
    public static final String left = "left";
    public static final String right = "right";

    private static String[] tileList;
    static int val=0;
    static boolean res = false;

    static String [] r = {"0","1","2"};
    static int rand = (int)(Math.random()*5);

    private static SoundPlayer sound;
    static MediaPlayer mediaPlayer;

    private static AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_puzzle__game);

        sound = new SoundPlayer(this);
        mediaPlayer = MediaPlayer.create(Puzzle_Game.this,R.raw.youwin);

        rand = (int)(Math.random()*3);

        //val=rand;
        init();

        scramble();

        setDimensions();

    }

    public void init() {
        mGridView = (GestureDetectGridView_Puzzle) findViewById(R.id.grid);
        mGridView.setNumColumns(COLUMNS);

        tileList = new String[DIMENSIONS];
        for (int i = 0; i < DIMENSIONS; i++) {
            tileList[i] = String.valueOf(i);
        }
    }

    public void scramble() {
        int index;
        String temp;
        Random random = new Random();

        for (int i = tileList.length - 1; i > 0; i--) {
            index = random.nextInt(i + 1);
            temp = tileList[index];
            tileList[index] = tileList[i];
            tileList[i] = temp;
        }
    }

    public void setDimensions() {
        ViewTreeObserver vto = mGridView.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mGridView.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                int displayWidth = mGridView.getMeasuredWidth();
                int displayHeight = mGridView.getMeasuredHeight();

                int statusbarHeight = getStatusBarHeight(getApplicationContext());
                int requiredHeight = displayHeight - statusbarHeight;

                mColumnWidth = displayWidth / COLUMNS;
                mColumnHeight = requiredHeight / COLUMNS;

                display(getApplicationContext());
            }
        });
    }

    public int getStatusBarHeight(Context context) {
        int result = 0;
        int resourceId = context.getResources().getIdentifier("status_bar_height", "dimen",
                "android");

        if (resourceId > 0) {
            result = context.getResources().getDimensionPixelSize(resourceId);
        }

        return result;
    }

    public  static void display(Context context) {
        ArrayList<Button> buttons = new ArrayList<>();
        Button button;


        if(val == 0) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.pigeon_piece1);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.pigeon_piece2);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.pigeon_piece3);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.pigeon_piece4);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.pigeon_piece5);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.pigeon_piece6);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.pigeon_piece7);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.pigeon_piece8);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.pigeon_piece9);

                buttons.add(button);
            }
            mGridView.setAdapter(new CustomAdapter_Puzzle(buttons, mColumnWidth, mColumnHeight));
        }

        else if(val == 1) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.elephant_01);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.elephant_02);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.elephant_03);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.elephant_04);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.elephant_05);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.elephant_06);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.elephant_07);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.elephant_08);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.elephant_09);

                buttons.add(button);
            }
            mGridView.setAdapter(new CustomAdapter_Puzzle(buttons, mColumnWidth, mColumnHeight));
        }

        else if(val == 2) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.frog__01);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.frog__02);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.frog__03);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.frog__04);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.frog__05);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.frog__06);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.frog__07);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.frog__08);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.frog__09);

                buttons.add(button);
            }
            mGridView.setAdapter(new CustomAdapter_Puzzle(buttons, mColumnWidth, mColumnHeight));
        }

        else if(val == 3) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.tiger__01);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.tiger__02);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.tiger__03);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.tiger__04);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.tiger__05);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.tiger__06);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.tiger__07);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.tiger__08);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.tiger__09);

                buttons.add(button);
            }
            mGridView.setAdapter(new CustomAdapter_Puzzle(buttons, mColumnWidth, mColumnHeight));
        }

        else if(val == 4) {
            for (int i = 0; i < tileList.length; i++) {
                button = new Button(context);

                if (tileList[i].equals("0"))
                    button.setBackgroundResource(R.drawable.spider_01);
                else if (tileList[i].equals("1"))
                    button.setBackgroundResource(R.drawable.spider_02);
                else if (tileList[i].equals("2"))
                    button.setBackgroundResource(R.drawable.spider_03);
                else if (tileList[i].equals("3"))
                    button.setBackgroundResource(R.drawable.spider_04);
                else if (tileList[i].equals("4"))
                    button.setBackgroundResource(R.drawable.spider_05);
                else if (tileList[i].equals("5"))
                    button.setBackgroundResource(R.drawable.spider_06);
                else if (tileList[i].equals("6"))
                    button.setBackgroundResource(R.drawable.spider_07);
                else if (tileList[i].equals("7"))
                    button.setBackgroundResource(R.drawable.spider_08);
                else if (tileList[i].equals("8"))
                    button.setBackgroundResource(R.drawable.spider_09);

                buttons.add(button);
            }
            mGridView.setAdapter(new CustomAdapter_Puzzle(buttons, mColumnWidth, mColumnHeight));
        }

    }


    private static void swap(final Context context, int currentPosition, int swap) {
        String newPosition = tileList[currentPosition + swap];
        tileList[currentPosition + swap] = tileList[currentPosition];
        tileList[currentPosition] = newPosition;
        display(context);


        if (isSolved()) {
            mediaPlayer = MediaPlayer.create(context,R.raw.youwin);
            mediaPlayer.start();
            //sound.playOverWin();
            AlertDialog.Builder builder = new AlertDialog.Builder(context);
            builder.setCancelable(false);
            builder.setTitle("PUZZLE GAME");
            builder.setMessage("You Win Kid !!!");
            builder.setPositiveButton("Next Level", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {


                    val++;
                    if(val==5){
                        val=0;
                        Intent intent = new Intent(context, Puzzle_Game.class);
                        context.startActivity(intent);
                    }else {
                        Intent intent = new Intent(context, Puzzle_Game.class);
                        context.startActivity(intent);
                    }

                }
            })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    });
            dialog = builder.create();
            dialog.getWindow().getAttributes().windowAnimations = R.style.dialog_animation;
            dialog.show();
            //builder.create().show();

        }
    }


    public static void moveTiles(Context context, String direction, int position) {

        // Upper-left-corner tile
        if (position == 0) {

            if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();

            // Upper-center tiles
        } else if (position > 0 && position < COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();

            // Upper-right-corner tile
        } else if (position == COLUMNS - 1) {
            if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();

            // Left-side tiles
        } else if (position > COLUMNS - 1 && position < DIMENSIONS - COLUMNS &&
                position % COLUMNS == 0) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else if (direction.equals(down)) swap(context, position, COLUMNS);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();

            // Right-side AND bottom-right-corner tiles
        } else if (position == COLUMNS * 2 - 1 || position == COLUMNS * 3 - 1) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(down)) {

                // Tolerates only the right-side tiles to swap downwards as opposed to the bottom-
                // right-corner tile.
                if (position <= DIMENSIONS - COLUMNS - 1) swap(context, position,
                        COLUMNS);
                else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
                sound.playOverMusex();
            } else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();
            // Bottom-left corner tile
        } else if (position == DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();

            // Bottom-center tiles
        } else if (position < DIMENSIONS - 1 && position > DIMENSIONS - COLUMNS) {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else Toast.makeText(context, "Invalid move", Toast.LENGTH_SHORT).show();
            sound.playOverMusex();
            // Center tiles
        } else {
            if (direction.equals(up)) swap(context, position, -COLUMNS);
            else if (direction.equals(left)) swap(context, position, -1);
            else if (direction.equals(right)) swap(context, position, 1);
            else swap(context, position, COLUMNS);
            sound.playOverMusex();
        }
    }

    private static boolean isSolved() {
        boolean solved = false;

        for (int i = 0; i < tileList.length; i++) {
            if (tileList[i].equals(String.valueOf(i))) {
                solved = true;
            } else {
                solved = false;
                break;
            }
        }

        return solved;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.notes) {
            Intent intent = new Intent(Puzzle_Game.this,CoverFlow.class);
            startActivity(intent);
            finish();
            }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        try {

            //mediaPlayer = MediaPlayer.create(Puzzle_Game.this,R.raw.youwin);
            //if(mediaPlayer != null && !mediaPlayer.isPlaying())
            //Intent intent = new Intent(Puzzle_Game.this,CoverFlow.class);
            //startActivity(intent);
            //finish();
                //mediaPlayer.start();

            if(coverFlow.mediaPlayer1 != null && !CoverFlow.mediaPlayer1.isPlaying())
                coverFlow.mediaPlayer1.start();
        }catch (Exception e){

        }
        super.onBackPressed();

    }
}