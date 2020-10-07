package com.test.imagediffference;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity {
ImageView image1,image2;

FrameLayout image1layer,image2layer;
    Paint paint;
    Path path;
    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE); // will hide the title
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        image1 = findViewById(R.id.image1);

        image2 = findViewById(R.id.image2);
        image1layer = findViewById(R.id.image1layer);
        image2layer = findViewById(R.id.image2layer);

        image1.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint({"ClickableViewAccessibility", "UseCompatLoadingForDrawables"})
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int X =(int) event.getX();
                int Y =(int) event.getY();
                String msg = "Coordinates are " + X + "and" + Y;
                int eventAction = event.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    int x = (int) event.getX();
                    int y = (int) event.getY();
                    if(checkPoint(X,Y) == true){
                        setTouchRight(x,y,image2layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.ring));
                        ( image1layer).addView(iv);
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                        vb.vibrate(60);
                    }
                    else{
                        setTouchWrong(x,y,image1layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        final ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.close));
                        ( image1layer).addView(iv);
                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();
                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                        vb.vibrate(60);
                        /*iv.setAnimation(com.test.imagediffference.AnimationUtils.fadeOut());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iv.setVisibility(View.GONE);
                            }
                        }, 1000);*/
                    }
                }
                return false;
            }
        });

        image2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int X = (int) event.getX();
                int Y = (int) event.getY();
                String msg = "Coordinates are " + X + "and" + Y;
                int eventAction = event.getAction();
                if(eventAction == MotionEvent.ACTION_DOWN){
                    int x = ( int)event.getX();
                    int y = (int)event.getY();

                    if(checkPoint(X,Y) == true){
                        setTouchRight(x,y,image1layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.ring));
                        ((ViewGroup) image2layer).addView(iv);
                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);

                        Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

                        vb.vibrate(60);
                    }
                    else{
                        setTouchWrong(x,y,image2layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        final ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.close));
                        ((ViewGroup) image2layer).addView(iv);

                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                        vb.vibrate(60);
                        /* ////  Animation fadeOut= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                        iv.setAnimation(com.test.imagediffference.AnimationUtils.fadeOut());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iv.setVisibility(View.GONE);
                            }
                        }, 1000);*/
                    }
                    Toast.makeText(MainActivity.this,msg,Toast.LENGTH_SHORT).show();

                }
                return false;
            }
        });
    }

    private void setTouchRight(float X, float Y, View viewLayer){
        int x = (int) X;
        int y = (int) Y;
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ImageView iv = new ImageView(getApplicationContext());
        lp.setMargins(x, y, 0, 0);
        iv.setLayoutParams(lp);
        iv.setImageDrawable(getResources().getDrawable(R.drawable.ring));
        ((ViewGroup) viewLayer).addView(iv);
        iteration(950f,600f);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void setTouchWrong(float X, float Y, View viewLayer){
        int x = (int) X;
        int y = (int) Y;
        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        ImageView iv = new ImageView(getApplicationContext());
        lp.setMargins(x, y, 0, 0);
        iv.setLayoutParams(lp);
        iv.setImageDrawable(getResources().getDrawable(R.drawable.close));
        ((ViewGroup) viewLayer).addView(iv);
    }

    public void iteration(float x,float y){
        TouchCoordinate touchCoordinate=new TouchCoordinate();
        Map<Integer,TouchCoordinate> matchTouchCoordinate= touchCoordinate.coordinateMap();
        for (int i=1; i<=matchTouchCoordinate.size();i++){
            TouchCoordinate touchCoordinate1=(TouchCoordinate) matchTouchCoordinate.get(i);
              if (touchCoordinate1==null){
                  Log.d("@shiva", "iteration: null");
              }
            if (touchCoordinate1.x==x && touchCoordinate1.y==y){
                Log.d("@shiva", "iteration:"+x);
            }
        }
    }


    private boolean checkPoint(int x, int y) {
        int touchX = (int) x;
        int touchY = y;
      /*  Bitmap bitmap1 = ((BitmapDrawable) image1.getDrawable()).getBitmap();
        Bitmap bitmap2 = ((BitmapDrawable) image2.getDrawable()).getBitmap();
        bitmap1.getHeight();
        bitmap2.getHeight();

        Matrix inverse = new Matrix();
        image1.getImageMatrix().invert(inverse);
        image2.getImageMatrix().invert(inverse);
        float[] touchPoint = new float[]{touchX, touchY};
        inverse.mapPoints(touchPoint);
        int xCoord = (int) touchPoint[0];
        int yCoord = (int) touchPoint[1];
        if (bitmap1.getHeight() > yCoord && bitmap1.getWidth() > xCoord  && bitmap2.getHeight() > yCoord && bitmap2.getWidth() > xCoord  ) {
            int pixel1 = bitmap1.getPixel(xCoord, yCoord);
            int pixel2 = bitmap2.getPixel(xCoord, yCoord);
            try {
                if (pixel1 != pixel2) {
                    return true;
                }*/
       float centerX = 524, centerY = 93;
        float radius = 50;

        if (Math.pow(centerX-touchX , 2)
                + Math.pow(centerY-touchY , 2) < Math.pow(radius, 2))
        {
           // Toast.makeText(MainActivity.this,"points inside circe",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            //Toast.makeText(MainActivity.this,"points outside circle",Toast.LENGTH_SHORT).show();
            return false;
        }
    }


    private void fadeOut(View viewLayer){
        Animation fadeOut= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        viewLayer.startAnimation(fadeOut);
    }
}