package com.example.mondelavictoria.happy_kids_reading;

import android.content.ClipData;
import android.content.DialogInterface;
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

public class SodukoPuzzle extends AppCompatActivity {

    LinearLayout btnTarget, btnTarget1;
    LinearLayout target1,target2,target3,target4,
            target5,target6,target7,target8;

    ImageView test1,test2,test3,test4,test5,test6,test7,test8;
    Button btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8;

    boolean isCorrect = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soduko_puzzle);

        btnTarget = (LinearLayout)findViewById(R.id.btnTarget);
        btnTarget1 = (LinearLayout)findViewById(R.id.btnTarget1);

        target1 = (LinearLayout)findViewById(R.id.target1);
        target2 = (LinearLayout)findViewById(R.id.target2);
        target3 = (LinearLayout)findViewById(R.id.target3);
        target4 = (LinearLayout)findViewById(R.id.target4);
        target5 = (LinearLayout)findViewById(R.id.target5);
        target6 = (LinearLayout)findViewById(R.id.target6);
        target7 = (LinearLayout)findViewById(R.id.target7);
        target8 = (LinearLayout)findViewById(R.id.target8);

        test1 = (ImageView) findViewById(R.id.test1);
        test2 = (ImageView) findViewById(R.id.test2);
        test3 = (ImageView) findViewById(R.id.test3);
        test4 = (ImageView) findViewById(R.id.test4);
        test5 = (ImageView) findViewById(R.id.test5);
        test6 = (ImageView) findViewById(R.id.test6);
        test7 = (ImageView) findViewById(R.id.test7);
        test8 = (ImageView) findViewById(R.id.test8);

        btn1 = (Button)findViewById(R.id.btn1);
        btn2 = (Button)findViewById(R.id.btn2);
        btn3 = (Button)findViewById(R.id.btn3);
        btn4 = (Button)findViewById(R.id.btn4);
        btn5 = (Button)findViewById(R.id.btn5);
        btn6 = (Button)findViewById(R.id.btn6);
        btn7 = (Button)findViewById(R.id.btn7);
        btn8 = (Button)findViewById(R.id.btn8);

        target1.setOnDragListener(dragListener);
        target2.setOnDragListener(dragListener);
        target3.setOnDragListener(dragListener);
        target4.setOnDragListener(dragListener);
        target5.setOnDragListener(dragListener);
        target6.setOnDragListener(dragListener);
        target7.setOnDragListener(dragListener);
        target8.setOnDragListener(dragListener);

        btn1.setOnTouchListener( onTouchListener);
        btn2.setOnTouchListener( onTouchListener);
        btn3.setOnTouchListener( onTouchListener);
        btn4.setOnTouchListener( onTouchListener);
        btn5.setOnTouchListener( onTouchListener);
        btn6.setOnTouchListener( onTouchListener);
        btn7.setOnTouchListener( onTouchListener);
        btn8.setOnTouchListener( onTouchListener);

        final Button check = (Button)findViewById(R.id.check);

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
                        test1.setImageDrawable(getDrawable(R.drawable.rats));
                        test1.setTag(" ");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.rats));
                        test2.setTag(" ");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.rats));
                        test3.setTag(" ");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.rats));
                        test4.setTag("one");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.rats));
                        test5.setTag("one");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.rats));
                        test6.setTag(" ");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.rats));
                        test7.setTag(" ");
                    }else if(view.getId() == R.id.btn1 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.rats));
                        test8.setTag(" ");
                    }

                    else if(view.getId() == R.id.btn2 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.cat));
                        test1.setTag(" ");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.cat));
                        test2.setTag(" ");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.cat));
                        test3.setTag("two");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.cat));
                        test4.setTag(" ");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.cat));
                        test5.setTag(" ");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.cat));
                        test6.setTag("two");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.cat));
                        test7.setTag(" ");
                    }else if(view.getId() == R.id.btn2 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.cat));
                        test8.setTag(" ");
                    }


                    else if(view.getId() == R.id.btn3 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.dog));
                        test1.setTag("three");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.dog));
                        test2.setTag("three");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.dog));
                        test3.setTag(" ");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.dog));
                        test4.setTag(" ");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.dog));
                        test5.setTag(" ");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.dog));
                        test6.setTag(" ");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.dog));
                        test7.setTag("three");
                    } else if(view.getId() == R.id.btn3 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.dog));
                        test8.setTag("three");
                    }


                    else if(view.getId() == R.id.btn4 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.hyena));
                        test1.setTag("four");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.hyena));
                        test2.setTag("four");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.hyena));
                        test3.setTag(" ");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.hyena));
                        test4.setTag(" ");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.hyena));
                        test5.setTag(" ");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.hyena));
                        test6.setTag(" ");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.hyena));
                        test7.setTag("four");
                    }else if(view.getId() == R.id.btn4 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.hyena));
                        test8.setTag("four");
                    }


                    else if(view.getId() == R.id.btn5 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.lions));
                        test1.setTag("five");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.lions));
                        test2.setTag("five");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.lions));
                        test3.setTag(" ");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.lions));
                        test4.setTag(" ");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.lions));
                        test5.setTag(" ");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.lions));
                        test6.setTag(" ");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.lions));
                        test7.setTag("five");
                    }else if(view.getId() == R.id.btn5 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.lions));
                        test8.setTag("five");
                    }


                    else if(view.getId() == R.id.btn6 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.elephants));
                        test1.setTag("six");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.elephants));
                        test2.setTag("six");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.elephants));
                        test3.setTag(" ");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.elephants));
                        test4.setTag("six");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.elephants));
                        test5.setTag(" ");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.elephants));
                        test6.setTag(" ");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.elephants));
                        test7.setTag("six");
                    }else if(view.getId() == R.id.btn6 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.elephants));
                        test8.setTag("six");
                    }

                    else if(view.getId() == R.id.btn7 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.dragon));
                        test1.setTag(" ");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.dragon));
                        test2.setTag(" ");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.dragon));
                        test3.setTag("seven");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.dragon));
                        test4.setTag(" ");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.dragon));
                        test5.setTag(" ");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.dragon));
                        test6.setTag("seven");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.dragon));
                        test7.setTag(" ");
                    }else if(view.getId() == R.id.btn7 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.dragon));
                        test8.setTag(" ");
                    }

                    else if(view.getId() == R.id.btn8 && v.getId() == R.id.target1){
                        test1.setImageDrawable(getDrawable(R.drawable.pudge));
                        test1.setTag(" ");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target2){
                        test2.setImageDrawable(getDrawable(R.drawable.pudge));
                        test2.setTag(" ");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target3){
                        test3.setImageDrawable(getDrawable(R.drawable.pudge));
                        test3.setTag(" ");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target4){
                        test4.setImageDrawable(getDrawable(R.drawable.pudge));
                        test4.setTag("eight");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target5){
                        test5.setImageDrawable(getDrawable(R.drawable.pudge));
                        test5.setTag("eight");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target6){
                        test6.setImageDrawable(getDrawable(R.drawable.pudge));
                        test6.setTag(" ");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target7){
                        test7.setImageDrawable(getDrawable(R.drawable.pudge));
                        test7.setTag(" ");
                    }else if(view.getId() == R.id.btn8 && v.getId() == R.id.target8){
                        test8.setImageDrawable(getDrawable(R.drawable.pudge));
                        test8.setTag(" ");
                    }


                    else{
                        Toast.makeText(SodukoPuzzle.this,"Invalid Match",Toast.LENGTH_LONG).show();
                    }
                    break;
            }

            return true;
        }

    };

    public void check(){

         if( test1.getTag().toString().equals("three") && test2.getTag().toString().equals("five") &&
                 test3.getTag().toString().equals("seven") && test4.getTag().toString().equals("one") &&
                 test5.getTag().toString().equals("eight") && test6.getTag().toString().equals("two") &&
                 test7.getTag().toString().equals("four") && test8.getTag().toString().equals("six")){
             //Create Dialog
             final AlertDialog.Builder builder = new AlertDialog.Builder(SodukoPuzzle.this);
             builder.setTitle("Puzzel Solve !!!");
             builder.setMessage("Good Job....!" );
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i){
                     recreate();
                 }

             });
             builder.setCancelable(false);
             builder.show();

        }else if( test1.getTag().toString().equals("five") && test2.getTag().toString().equals("three") &&
                 test3.getTag().toString().equals("two") && test4.getTag().toString().equals("eight") &&
                 test5.getTag().toString().equals("one") && test6.getTag().toString().equals("seven") &&
                 test7.getTag().toString().equals("six") && test8.getTag().toString().equals("four")){
             //Create Dialog
             final AlertDialog.Builder builder = new AlertDialog.Builder(SodukoPuzzle.this);
             builder.setTitle("Puzzel Solve !!!");
             builder.setMessage("Good Job....!" );
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i){
                     recreate();
                 }

             });
             builder.setCancelable(false);
             builder.show();

         }else if( test1.getTag().toString().equals("four") && test2.getTag().toString().equals("six") &&
                 test3.getTag().toString().equals("seven") && test4.getTag().toString().equals("one") &&
                 test5.getTag().toString().equals("eight") && test6.getTag().toString().equals("two") &&
                 test7.getTag().toString().equals("three") && test8.getTag().toString().equals("five")){
             //Create Dialog
             final AlertDialog.Builder builder = new AlertDialog.Builder(SodukoPuzzle.this);
             builder.setTitle("Puzzel Solve !!!");
             builder.setMessage("Good Job....!" );
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i){
                     recreate();
                 }

             });
             builder.setCancelable(false);
             builder.show();

         }else if( test1.getTag().toString().equals("six") && test2.getTag().toString().equals("four") &&
                 test3.getTag().toString().equals("two") && test4.getTag().toString().equals("eight") &&
                 test5.getTag().toString().equals("one") && test6.getTag().toString().equals("seven") &&
                 test7.getTag().toString().equals("five") && test8.getTag().toString().equals("three")){
             //Create Dialog
             final AlertDialog.Builder builder = new AlertDialog.Builder(SodukoPuzzle.this);
             builder.setTitle("Puzzle Solve !!!");
             builder.setMessage("Good Job....!" );
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i){
                     recreate();
                 }

             });
             builder.setCancelable(false);
             builder.show();
         }else{

             //Create Dialog
             final AlertDialog.Builder builder = new AlertDialog.Builder(this);
             builder.setTitle("Puzzle Unsolve !!!");
             builder.setMessage("Try Again...." );
             builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                 @Override
                 public void onClick(DialogInterface dialogInterface, int i){
                     recreate();
                 }

             });
             builder.setCancelable(false);
             builder.show();
        }
    }
}

