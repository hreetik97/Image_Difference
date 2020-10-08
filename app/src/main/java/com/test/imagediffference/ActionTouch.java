package com.test.imagediffference;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.core.graphics.drawable.DrawableCompat;

public class ActionTouch implements View.OnTouchListener {

    private  View.OnClickListener onClickListener;

   public ActionTouch(View.OnClickListener onClickListener){
       this.onClickListener = onClickListener;
   }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        if(event.getAction()==MotionEvent.ACTION_UP){
            ViewGroup viewGroup = (ViewGroup) v;
            for(int pos = viewGroup.getChildCount()-1;pos>=0;pos--){
                View rlView = viewGroup.getChildAt(pos);
                View view = rlView.findViewById(R.id.image1);

                Rect r =new Rect(0,0,rlView.getWidth(),rlView.getHeight());

                viewGroup.getChildVisibleRect(rlView,r,new Point(0,0));
                boolean isTouched = event.getRawX() >= r.left && event.getRawX() <= r.right && event.getRawY() >= r.top && event.getRawY() <= r.bottom;
                if(!isTouched) continue;

                Bitmap bitmap = getBitmapFromDrawable(((ImageView) view).getDrawable(), view.getWidth(), view.getHeight());

                int x = (int)(event.getRawX() - r.left);
                int y = (int)(event.getRawY() - r.top);

                if(bitmap.getPixel(x,y)== Color.TRANSPARENT)
                    continue;
                if(onClickListener != null){
                    onClickListener.onClick(view);
                    break;
                }
            }
        }

       return true;
    }
    public Bitmap getBitmapFromDrawable(Drawable drawable,int newWidth, int newHeight){
       if(Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP){
           drawable = (DrawableCompat.wrap(drawable)).mutate();
       }
       Bitmap bitmap = Bitmap.createBitmap(newWidth,newHeight,Bitmap.Config.ARGB_8888);
       Canvas canvas = new Canvas(bitmap);
       drawable.setBounds(0,0,canvas.getWidth(),canvas.getHeight());
       drawable.draw(canvas);
       return bitmap;
    }
}
