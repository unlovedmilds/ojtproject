package com.example.mondelavictoria.happy_kids_reading;

import android.content.ClipData;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Mathino_Kids extends AppCompatActivity {

    LinearLayout btnTarget;
    LinearLayout btnTarget1;
    CoverFlow coverFlow = new CoverFlow();
    LinearLayout target1,target2,target3,target4;
    LinearLayout target11,target21,target31,target41;
    LinearLayout target12,target22,target32,target42;
    LinearLayout target13,target23,target33,target43;
    Button test1,test2,test3,test4;
    Button test11,test21,test31,test41;
    Button test12,test22,test32,test42;
    Button test13,test23,test33,test43;
    ImageView btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    String val1,val2,val3,val4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mathino__kids);

        btnTarget = (LinearLayout)findViewById(R.id.btnTarget);
        btnTarget1 = (LinearLayout)findViewById(R.id.btnTarget1);

        target1 = (LinearLayout)findViewById(R.id.target1);
        target2 = (LinearLayout)findViewById(R.id.target2);
        target3 = (LinearLayout)findViewById(R.id.target3);
        target4 = (LinearLayout)findViewById(R.id.target4);

        target11 = (LinearLayout)findViewById(R.id.target11);
        target21 = (LinearLayout)findViewById(R.id.target21);
        target31 = (LinearLayout)findViewById(R.id.target31);
        target41 = (LinearLayout)findViewById(R.id.target41);

        target12 = (LinearLayout)findViewById(R.id.target12);
        target22 = (LinearLayout)findViewById(R.id.target22);
        target32 = (LinearLayout)findViewById(R.id.target32);
        target42 = (LinearLayout)findViewById(R.id.target42);

        target13 = (LinearLayout)findViewById(R.id.target13);
        target23 = (LinearLayout)findViewById(R.id.target23);
        target33 = (LinearLayout)findViewById(R.id.target33);
        target43 = (LinearLayout)findViewById(R.id.target43);

        test1 = (Button)findViewById(R.id.test1);
        test2 = (Button)findViewById(R.id.test2);
        test3 = (Button)findViewById(R.id.test3);
        test4 = (Button)findViewById(R.id.test4);

        test11 = (Button)findViewById(R.id.test11);
        test21 = (Button)findViewById(R.id.test21);
        test31 = (Button)findViewById(R.id.test31);
        test41 = (Button)findViewById(R.id.test41);

        test12 = (Button)findViewById(R.id.test12);
        test22 = (Button)findViewById(R.id.test22);
        test32 = (Button)findViewById(R.id.test32);
        test42 = (Button)findViewById(R.id.test42);

        test13 = (Button)findViewById(R.id.test13);
        test23 = (Button)findViewById(R.id.test23);
        test33 = (Button)findViewById(R.id.test33);
        test43 = (Button)findViewById(R.id.test43);

        btn1 = (ImageView) findViewById(R.id.btn1);
        btn2 = (ImageView) findViewById(R.id.btn2);
        btn3 = (ImageView) findViewById(R.id.btn3);
        btn4 = (ImageView) findViewById(R.id.btn4);
        btn5 = (ImageView) findViewById(R.id.btn5);
        btn6 = (ImageView) findViewById(R.id.btn6);
        btn7 = (ImageView) findViewById(R.id.btn7);
        btn8 = (ImageView) findViewById(R.id.btn8);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);

        target11.setOnDragListener(dragListener);
        target21.setOnDragListener(dragListener);
        target31.setOnDragListener(dragListener);
        target41.setOnDragListener(dragListener);

        target12.setOnDragListener(dragListener);
        target22.setOnDragListener(dragListener);
        target32.setOnDragListener(dragListener);
        target42.setOnDragListener(dragListener);

        target13.setOnDragListener(dragListener);
        target23.setOnDragListener(dragListener);
        target33.setOnDragListener(dragListener);
        target43.setOnDragListener(dragListener);


        btn1.setOnTouchListener( onTouchListener);
        btn2.setOnTouchListener( onTouchListener);
        btn3.setOnTouchListener( onTouchListener);
        btn4.setOnTouchListener( onTouchListener);

        btn5.setOnTouchListener( onTouchListener);
        btn6.setOnTouchListener( onTouchListener);
        btn7.setOnTouchListener( onTouchListener);
        btn8.setOnTouchListener( onTouchListener);


        /*LinearLayout.LayoutParams absParams =
                (LinearLayout.LayoutParams)btn1.getLayoutParams();

        DisplayMetrics displaymetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
        int width = displaymetrics.widthPixels;
        int height = displaymetrics.heightPixels;

        Random r = new Random();

        absParams.width =  r.nextInt(width ) ;
        absParams.height =  r.nextInt(height );
        btn1.setLayoutParams(absParams);*/
        int [] image = {R.drawable.two,R.drawable.three,R.drawable.four,R.drawable.five};
        shuffleArray(image);


       ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(R.drawable.one);
        list.add(R.drawable.two);
        list.add(R.drawable.three);
        list.add(R.drawable.four);
        //list.add(R.drawable.five);
        //list.add(R.drawable.six);
        //list.add(R.drawable.seven);
        //list.add(R.drawable.eight);
        //list.add(R.drawable.nine);
        Collections.shuffle(list);

       /* btn1.setImageResource(Integer.valueOf(list.get(0)));
        btn2.setImageResource(Integer.valueOf(list.get(1)));
        btn3.setImageResource(Integer.valueOf(list.get(2)));
        btn4.setImageResource(Integer.valueOf(list.get(3)));
        btn5.setImageResource(Integer.valueOf(list.get(4)));
        btn6.setImageResource(Integer.valueOf(list.get(5)));
        btn7.setImageResource(Integer.valueOf(list.get(6)));
        btn8.setImageResource(Integer.valueOf(list.get(7)));


        test1.setBackgroundResource((Integer.valueOf(list.get(0))));
        test3.setBackgroundResource((Integer.valueOf(list.get(1))));
        test11.setBackgroundResource((Integer.valueOf(list.get(2))));
        test31.setBackgroundResource((Integer.valueOf(list.get(3))));
        test12.setBackgroundResource((Integer.valueOf(list.get(3))));
        test32.setBackgroundResource((Integer.valueOf(list.get(1))));
        test13.setBackgroundResource((Integer.valueOf(list.get(0))));
        test33.setBackgroundResource((Integer.valueOf(list.get(2))));*/

        List<ImageView> buttons = new ArrayList<ImageView>();
        List<ImageView> buttons1 = new ArrayList<ImageView>();
        buttons.add((ImageView)findViewById(R.id.btn1));
        buttons.add((ImageView)findViewById(R.id.btn2));
        buttons.add((ImageView)findViewById(R.id.btn3));
        buttons.add((ImageView)findViewById(R.id.btn4));
        buttons1.add((ImageView)findViewById(R.id.btn5));
        buttons1.add((ImageView)findViewById(R.id.btn6));
        buttons1.add((ImageView)findViewById(R.id.btn7));
        buttons1.add((ImageView)findViewById(R.id.btn8));


        /*for (int i = 0; i < 10; i++) {
            Button b = new Button(this);
            b.setText("" + (i+1));
            b.setGravity(Gravity.CENTER_HORIZONTAL);
            b.setId(generateUniqueId());                    // Set an id to Button

            buttons.add(b);
        }*/
        // Shuffle
        Collections.shuffle(buttons);
        Collections.shuffle(buttons1);


        for (int i = 0; i < 4; i++) {



            if( btn1.getParent()!=null && btn2.getParent()!=null && btn3.getParent()!=null && btn4.getParent()!=null) {
                ((ViewGroup) btn1.getParent()).removeView(btn1);

                ((ViewGroup) btn2.getParent()).removeView(btn2);

                ((ViewGroup) btn3.getParent()).removeView(btn3);

                ((ViewGroup) btn4.getParent()).removeView(btn4);
            }
            btnTarget.addView(buttons.get(i));

        }

        for (int i = 0; i < 4; i++) {



            if( btn5.getParent()!=null  && btn6.getParent()!=null  && btn7.getParent()!=null  && btn8.getParent()!=null) {
                ((ViewGroup) btn5.getParent()).removeView(btn5);

                ((ViewGroup) btn6.getParent()).removeView(btn6);

                ((ViewGroup) btn7.getParent()).removeView(btn7);

                ((ViewGroup) btn8.getParent()).removeView(btn8);
            }
            btnTarget1.addView(buttons1.get(i));

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

    static void shuffleArray(int[] arr)
    {
        Random rnd = new Random();
        for (int i = arr.length - 1; i > 0; i--)
        {
            int index = rnd.nextInt(i + 1);
            // Swap
            int a = arr[index];
            arr[index] = arr[i];
            arr[i] = a;
        }
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

                    if(view.getId() == R.id.btn1 && v.getId() == R.id.target4 ){

                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test4.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target41){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test41.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn3 && v.getId() == R.id.target42){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test42.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target43){
                        LinearLayout oldparent = (LinearLayout)view.getParent();
                        oldparent.removeView(view);
                        LinearLayout newparent = (LinearLayout)v;
                        test43.setVisibility(View.GONE);
                        newparent.addView(view);

                    }else{
                        Toast.makeText(Mathino_Kids.this,"Invalid Match",Toast.LENGTH_LONG).show();
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
