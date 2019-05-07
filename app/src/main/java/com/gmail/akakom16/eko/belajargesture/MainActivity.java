package com.gmail.akakom16.eko.belajargesture;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.widget.TextView;
import android.widget.TextView;
import android.widget.RelativeLayout;


public class MainActivity extends AppCompatActivity  implements
        GestureDetector.OnGestureListener,
        GestureDetector.OnDoubleTapListener{
    private TextView gestureText;
    private GestureDetectorCompat gDetector;
    private RelativeLayout layout;
    public static final int SWIPE_THRESHOLD=100;
    public static final int SWIPE_VELOCITY_THRESHOLD=100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText =(TextView)findViewById(R.id.gestureStatusText_);
        layout = (RelativeLayout) findViewById(R.id.layout_utama);
        layout.setBackgroundColor(Color.WHITE);
        this.gDetector = new GestureDetectorCompat(this,this);
        gDetector.setOnDoubleTapListener(this);
    }
    @Override
    public boolean onDown(MotionEvent event) {
        gestureText.setText ("onDown");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public boolean onFling(MotionEvent event1, MotionEvent event2,
                           float velocityX, float velocityY) {
       // gestureText.setText("onFling");
        //return true;
        boolean result = false;
        float diffY = event2.getY() - event1.getY();
        float diffX = event2.getX() - event1.getX();

        if (Math.abs(diffX)>Math.abs(diffY)){
            if (Math.abs(diffX)> SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                if (diffX > 0) {
                    gestureText.setText("OnSwipeRight");
                    layout.setBackgroundColor(Color.BLUE);
                }else {
                    gestureText.setText("OnSwipeLeft");
                    layout.setBackgroundColor(Color.CYAN);
                }
                result = true;
            }
        }else {
            if (Math.abs(diffY)>SWIPE_THRESHOLD && Math.abs(velocityX)>SWIPE_VELOCITY_THRESHOLD){
                if (diffY > 0){
                    gestureText.setText("OnSwipeButtom");
                    layout.setBackgroundColor(Color.GRAY);
                }else {
                    gestureText.setText("OnSwipeTop");
                    layout.setBackgroundColor(Color.DKGRAY);
                }
                result = true;
            }
        }
return result;
    }
    @Override
    public void onLongPress(MotionEvent event) {
        gestureText.setText("onLongPress");
        layout.setBackgroundColor(Color.BLACK);
    }
    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2,
                            float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public void onShowPress(MotionEvent event) {
        gestureText.setText("onShowPress");
    }
    @Override
    public boolean onSingleTapUp(MotionEvent event) {
        gestureText.setText("onSingleTapUp");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public boolean onDoubleTap(MotionEvent event) {
        gestureText.setText("onDoubleTap");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public boolean onDoubleTapEvent(MotionEvent event) {
        gestureText.setText("onDoubleTapEvent");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public boolean onSingleTapConfirmed(MotionEvent event) {
        gestureText.setText("onSingleTapConfirmed");
        layout.setBackgroundColor(Color.WHITE);
        return true;
    }
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }
}
