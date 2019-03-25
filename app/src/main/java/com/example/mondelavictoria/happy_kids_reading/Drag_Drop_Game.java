package com.example.mondelavictoria.happy_kids_reading;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Drag_Drop_Game extends AppCompatActivity {

    CoverFlow coverFlow = new CoverFlow();
    LinearLayout btnTarget;
    LinearLayout target1,target2,target3,target4;
    Button test1,test2,test3,test4,btn1,btn2,btn3,btn4;
    String val = "";
    float x,y;
    int dragEvent;
    int id = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drag__drop__game);

        btnTarget = (LinearLayout)findViewById(R.id.btnTarget);

        target1 = (LinearLayout)findViewById(R.id.target1);
        target2 = (LinearLayout)findViewById(R.id.target2);
        target3 = (LinearLayout)findViewById(R.id.target3);
        target4 = (LinearLayout)findViewById(R.id.target4);

        test1 = (Button)findViewById(R.id.test1);
        test2 = (Button)findViewById(R.id.test2);
        test3 = (Button)findViewById(R.id.test3);
        test4 = (Button)findViewById(R.id.test4);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        btn1.setOnTouchListener( onTouchListener);
        btn2.setOnTouchListener( onTouchListener);
        btn3.setOnTouchListener( onTouchListener);
        btn4.setOnTouchListener( onTouchListener);

       /* RelativeLayout.LayoutParams absParams = (RelativeLayout.LayoutParams) btn1
                .getLayoutParams();
        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        Random r = new Random();
        absParams.width = r.nextInt(width);
        absParams.height = r.nextInt(height);
        btn1.setLayoutParams(absParams);*/

       /* RelativeLayout.LayoutParams params1 = (  RelativeLayout.LayoutParams) btn1.getLayoutParams();
        RelativeLayout.LayoutParams params2 = (  RelativeLayout.LayoutParams) btn2.getLayoutParams();
        RelativeLayout.LayoutParams params3 = (  RelativeLayout.LayoutParams) btn3.getLayoutParams();
        RelativeLayout.LayoutParams params4 = (  RelativeLayout.LayoutParams) btn4.getLayoutParams();
        btn1.setLayoutParams(params1);
        btn2.setLayoutParams(params2);
        btn3.setLayoutParams(params3);
        btn4.setLayoutParams(params4);*/

        List<Button> buttons = new ArrayList<Button>();
       buttons.add((Button)findViewById(R.id.btn1));
        buttons.add((Button)findViewById(R.id.btn2));
        buttons.add((Button)findViewById(R.id.btn3));
        buttons.add((Button)findViewById(R.id.btn4));


        /*for (int i = 0; i < 10; i++) {
            Button b = new Button(this);
            b.setText("" + (i+1));
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setId(generateUniqueId());                    // Set an id to Button

            buttons.add(b);
        }*/
        // Shuffle
        Collections.shuffle(buttons);


        for (int i = 0; i < 4; i++) {



                if( btn1.getParent()!=null && btn2.getParent()!=null && btn3.getParent()!=null && btn4.getParent()!=null) {
                    ((ViewGroup) btn1.getParent()).removeView(btn1);

                    ((ViewGroup) btn2.getParent()).removeView(btn2);

                    ((ViewGroup) btn3.getParent()).removeView(btn3);

                    ((ViewGroup) btn4.getParent()).removeView(btn4);
                }
                btnTarget.addView(buttons.get(i));

        }

    }

    View.OnTouchListener onTouchListener = new View.OnTouchListener() {
        int i = 0;
        @Override
        public boolean onTouch(View v, MotionEvent event) {


            ClipData data = ClipData.newPlainText("","");
            View.DragShadowBuilder myShadowBuilder = new View.DragShadowBuilder(v);
            v.startDrag(data,myShadowBuilder,v,0);



               /* if(v.getId() == R.id.btn1){
                    Toast.makeText(Drag_Drop_Game.this,"One",Toast.LENGTH_LONG).show();
                }
                if(v.getId() == R.id.btn2){
                Toast.makeText(Drag_Drop_Game.this,"Two",Toast.LENGTH_LONG).show();
                }*/


                return true;
        }

    };


    public int generateUniqueId(){
        View v = findViewById(id);
        while (v != null){
            v = findViewById(++id);
        }
        return id++;
    }
    public void buttonClicked(View v) {

       /* Random r = new Random();
        btn1.getX();
        btn1.getY();

        btn1.setX(r.nextFloat());
        btn1.setY(r.nextFloat());*/
    }

    View.OnDragListener dragListener = new View.OnDragListener() {
        @Override
        public boolean onDrag(View v, DragEvent event) {

            int dragEvent = event.getAction();
            final View view = (View) event.getLocalState();

            switch (dragEvent) {
                case DragEvent.ACTION_DRAG_ENTERED:

                    break;
                case DragEvent.ACTION_DRAG_LOCATION:

                    break;
                case DragEvent.ACTION_DRAG_ENDED:

                    break;
                case DragEvent.ACTION_DRAG_EXITED:

                    break;
                case DragEvent.ACTION_DROP:

                    if(view.getId() == R.id.btn1 && v.getId() == R.id.target1 ){

                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test1.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target2){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test2.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn3 && v.getId() == R.id.target3){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test3.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target4){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test4.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else{
                        Toast.makeText(Drag_Drop_Game.this,"Invalid Match",Toast.LENGTH_LONG).show();
                    }
                    break;
            }
            return true;
        }

    };

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
