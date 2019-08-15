package com.example.mondelavictoria.happy_kids_reading;

import android.content.ClipData;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.DragEvent;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class SodukoGame extends AppCompatActivity {

    LinearLayout btnTarget;
    LinearLayout target1,target2,target3,target4,
            target5,target6,target7,target8,target9,target10,target11,target12,
            target13,target14,target15,target16;
    ImageView test1,test2,test3,test4,test5,test6,test7,test8,test9,test10,test11,test12,
            test13,test14,test15,test16;
    Button btn1,btn2,btn3,btn4;

    boolean isCorrect = false;

    ArrayList<ArrayList<String>> quizArray = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sodukogame);

        btnTarget = (LinearLayout)findViewById(R.id.btnTarget);

        target1 = (LinearLayout)findViewById(R.id.target1);
        target2 = (LinearLayout)findViewById(R.id.target2);
        target3 = (LinearLayout)findViewById(R.id.target3);
        target4 = (LinearLayout)findViewById(R.id.target4);
        target5 = (LinearLayout)findViewById(R.id.target5);
        target6 = (LinearLayout)findViewById(R.id.target6);
        target7 = (LinearLayout)findViewById(R.id.target7);
        target8 = (LinearLayout)findViewById(R.id.target8);
        target9 = (LinearLayout)findViewById(R.id.target9);
        target10 = (LinearLayout)findViewById(R.id.target10);
        target11 = (LinearLayout)findViewById(R.id.target11);
        target12 = (LinearLayout)findViewById(R.id.target12);
        target13 = (LinearLayout)findViewById(R.id.target13);
        target14 = (LinearLayout)findViewById(R.id.target14);
        target15 = (LinearLayout)findViewById(R.id.target15);
        target16 = (LinearLayout)findViewById(R.id.target16);

        test1 = (ImageView) findViewById(R.id.test1);
        test2 = (ImageView) findViewById(R.id.test2);
        test3 = (ImageView) findViewById(R.id.test3);
        test4 = (ImageView) findViewById(R.id.test4);
        test5 = (ImageView) findViewById(R.id.test5);
        test6 = (ImageView) findViewById(R.id.test6);
        test7 = (ImageView) findViewById(R.id.test7);
        test8 = (ImageView) findViewById(R.id.test8);
        test9 = (ImageView) findViewById(R.id.test9);
        test10 = (ImageView) findViewById(R.id.test10);
        test11 = (ImageView) findViewById(R.id.test11);
        test12 = (ImageView) findViewById(R.id.test12);
        test13 = (ImageView) findViewById(R.id.test13);
        test14 = (ImageView) findViewById(R.id.test14);
        test15 = (ImageView) findViewById(R.id.test15);
        test16 = (ImageView) findViewById(R.id.test16);


        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);
        target5.setOnDragListener(dragListener);
        target6.setOnDragListener(dragListener);
        target7.setOnDragListener(dragListener);
        target8.setOnDragListener(dragListener);
        target9.setOnDragListener(dragListener);
        target10.setOnDragListener(dragListener);
        target11.setOnDragListener(dragListener);
        target12.setOnDragListener(dragListener);
        target13.setOnDragListener(dragListener);
        target14.setOnDragListener(dragListener);
        target15.setOnDragListener(dragListener);
        target16.setOnDragListener(dragListener);

        btn1.setOnTouchListener( onTouchListener);
        btn2.setOnTouchListener( onTouchListener);
        btn3.setOnTouchListener( onTouchListener);
        btn4.setOnTouchListener( onTouchListener);

        Button check = (Button)findViewById(R.id.check);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                check();

            }
        });



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
                        test1.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target9){
                        test9.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target10){
                        test10.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target11){
                        test11.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target12){
                        test12.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target13){
                        test13.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target14){
                        test14.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target15){
                        test15.setImageDrawable(getDrawable(R.drawable.one));
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target16){
                        test16.setImageDrawable(getDrawable(R.drawable.one));
                    }

                    else if(view.getId() == R.id.btn2 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target9){
                        test9.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target10){
                        test10.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target11){
                        test11.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target12){
                        test12.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target13){
                        test13.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target14){
                        test14.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target15){
                        test15.setImageDrawable(getDrawable(R.drawable.two));
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target16){
                        test16.setImageDrawable(getDrawable(R.drawable.two));
                    }


                    else if(view.getId() == R.id.btn3 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target9){
                        test9.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target10){
                        test10.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target11){
                        test11.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target12){
                        test12.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target13){
                        test13.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target14){
                        test14.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target15){
                        test15.setImageDrawable(getDrawable(R.drawable.three));
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target16){
                        test16.setImageDrawable(getDrawable(R.drawable.three));
                    }


                    else if(view.getId() == R.id.btn4 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target9){
                        test9.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target10){
                        test10.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target11){
                        test11.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target12){
                        test12.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target13){
                        test13.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target14){
                        test14.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target15){
                        test15.setImageDrawable(getDrawable(R.drawable.four));
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target16){
                        test16.setImageDrawable(getDrawable(R.drawable.four));
                    }

                    else{
                        Toast.makeText(SodukoGame.this,"Invalid Match",Toast.LENGTH_LONG).show();
                    }
                    break;
            }

            return true;
        }

    };

    public void check() {


        /*if( test1.getTag().toString().equals("one")){
            Toast.makeText(this, "okey", Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "notokey", Toast.LENGTH_SHORT).show();
        }
        String image1 = test1.getDrawable().getConstantState().toString();
        String image2 = test2.getDrawable().getConstantState().toString();


        //create quiz array data

            ArrayList<String> tmpArray = new ArrayList<>();
            tmpArray.add(image1);
            tmpArray.add(image2);

            quizArray.add(tmpArray);



        for(int i = 0; i < 16;i++) {
            if  (quizArray.get(i).equals(quizArray.get(i+1))) {
                Toast.makeText(this, "okey", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "notokey", Toast.LENGTH_SHORT).show();
            }
        }*/

        final Bitmap bitmap1 = ((BitmapDrawable)test1.getDrawable()).getBitmap();
        final Bitmap bitmap2 = ((BitmapDrawable)test2.getDrawable()).getBitmap();
        final Bitmap bitmap3 = ((BitmapDrawable)test3.getDrawable()).getBitmap();
        final Bitmap bitmap4 = ((BitmapDrawable)test4.getDrawable()).getBitmap();
        final Bitmap bitmap5 = ((BitmapDrawable)test5.getDrawable()).getBitmap();
        final Bitmap bitmap6 = ((BitmapDrawable)test6.getDrawable()).getBitmap();
        final Bitmap bitmap7 = ((BitmapDrawable)test7.getDrawable()).getBitmap();
        final Bitmap bitmap8 = ((BitmapDrawable)test8.getDrawable()).getBitmap();
        final Bitmap bitmap9 = ((BitmapDrawable)test9.getDrawable()).getBitmap();
        final Bitmap bitmap10 = ((BitmapDrawable)test10.getDrawable()).getBitmap();
        final Bitmap bitmap11 = ((BitmapDrawable)test11.getDrawable()).getBitmap();
        final Bitmap bitmap12 = ((BitmapDrawable)test12.getDrawable()).getBitmap();
        final Bitmap bitmap13 = ((BitmapDrawable)test13.getDrawable()).getBitmap();
        final Bitmap bitmap14 = ((BitmapDrawable)test14.getDrawable()).getBitmap();
        final Bitmap bitmap15 = ((BitmapDrawable)test15.getDrawable()).getBitmap();
        final Bitmap bitmap16 = ((BitmapDrawable)test16.getDrawable()).getBitmap();



        if(bitmap1.sameAs(bitmap2) ||  bitmap1.sameAs(bitmap3) || bitmap1.sameAs(bitmap4) || bitmap1.sameAs(bitmap5) || bitmap1.sameAs(bitmap6)
                || bitmap1.sameAs(bitmap9) ||  bitmap1.sameAs(bitmap11) ||bitmap1.sameAs(bitmap13) || bitmap1.sameAs(bitmap16)){
             Toast.makeText(this, "Same", Toast.LENGTH_SHORT).show();

        }else if(bitmap2.sameAs(bitmap1) ||  bitmap2.sameAs(bitmap3) || bitmap2.sameAs(bitmap4) || bitmap2.sameAs(bitmap6)
                || bitmap2.sameAs(bitmap10) || bitmap2.sameAs(bitmap14)){
            Toast.makeText(this, "Same", Toast.LENGTH_SHORT).show();

        }else if(bitmap3.sameAs(bitmap1) ||  bitmap3.sameAs(bitmap2) || bitmap3.sameAs(bitmap4) ||  bitmap3.sameAs(bitmap7)
                ||  bitmap3.sameAs(bitmap11) ||  bitmap3.sameAs(bitmap15)){
            Toast.makeText(this, "Same", Toast.LENGTH_SHORT).show();

        }else if(bitmap4.sameAs(bitmap1) ||  bitmap4.sameAs(bitmap2) || bitmap4.sameAs(bitmap3) ||  bitmap4.sameAs(bitmap7)
                ||  bitmap4.sameAs(bitmap8) ||  bitmap4.sameAs(bitmap10) ||  bitmap4.sameAs(bitmap12) ||  bitmap4.sameAs(bitmap13)
                ||  bitmap4.sameAs(bitmap16)){
            Toast.makeText(this, "Same", Toast.LENGTH_SHORT).show();

        }else {
             Toast.makeText(this, "Correct", Toast.LENGTH_SHORT).show();
            isCorrect = true;


            //Create Dialog
            final AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Puzzel Solve !!!");
            builder.setMessage("Good Job...." );
            builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i){
                }

            });
            builder.setCancelable(false);
            builder.show();


         }

    }


}
