package com.test.imagediffference;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class HideView extends View {

    public HideView(Context context) {
        super(context);

    }
}
/*

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
                float X = event.getX();
                float Y = event.getY();
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
                        Bitmap bitmap=null;
                        ((ViewGroup) image1layer).addView(iv);
                    }
                    else{
                        // setTouchWrong(x,y,image1layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        final ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.close));
                        ((ViewGroup) image1layer).addView(iv);
                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                        vb.vibrate(60);

                        iv.setAnimation(com.test.imagediffference.AnimationUtils.fadeOut());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iv.setVisibility(View.GONE);
                            }
                        }, 1000);
                    }
                }
                return false;
            }
        });

        image2.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                float X = event.getX();
                float Y = event.getY();
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
                    }
                    else{
                        //setTouchWrong(x,y,image2layer);
                        FrameLayout.LayoutParams lp = new FrameLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
                        final ImageView iv = new ImageView(getApplicationContext());
                        lp.setMargins(x, y, 0, 0);
                        iv.setLayoutParams(lp);
                        iv.setImageDrawable(getResources().getDrawable(R.drawable.close));
                        ((ViewGroup) image2layer).addView(iv);
                        Vibrator vb = (Vibrator)   getSystemService(Context.VIBRATOR_SERVICE);
                        vb.vibrate(60);
                        ////  Animation fadeOut= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
                        iv.setAnimation(com.test.imagediffference.AnimationUtils.fadeOut());
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                iv.setVisibility(View.GONE);
                            }
                        }, 1000);
                    }

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
    private void setTouchWrong(float X,float Y, View viewLayer){
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

    public String getURLForResource (int resourceId) {
        //use BuildConfig.APPLICATION_ID instead of R.class.getPackage().getName() if both are not same
        return Uri.parse("android.resource://"+R.class.getPackage().getName()+"/" +resourceId).toString();
    }

    private boolean checkPoint(float x, float y){
        float touchX =  x;
        float touchY =  y;
        float centerX = 950, centerY = 600;
        float radius = 100;
        Bitmap bitmap= ((BitmapDrawable)image1.getDrawable()).getBitmap();
        bitmap.getPixel((int) touchX,(int) touchY);
        // bitmap.getPixel();
        if (Math.pow(centerX-touchX , 2)
                + Math.pow(centerY-touchY , 2) < Math.pow(radius, 2))
        {
            Toast.makeText(MainActivity.this,"points inside circe",Toast.LENGTH_SHORT).show();
            return true;
        }
        else
        {
            Toast.makeText(MainActivity.this,"points outside circle",Toast.LENGTH_SHORT).show();
            return false;
        }
    }
    private void fadeOut(View viewLayer){
        Animation fadeOut= android.view.animation.AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        viewLayer.startAnimation(fadeOut);
    }
}*/
