package com.example.customcoloring2;

import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class ElementChange implements View.OnTouchListener {
    private Drawing drawing = null;

    public void TouchListener(Drawing initDrawing) {
        this.drawing = initDrawing;
    }

    //Should register touch
    public boolean OnTouch(View view, MotionEvent motionEvent, Shapes shape) {
        return true;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent, Shapes shape) {

       //TextView element = findViewById(R.id.element);

       //for (int i=0; i<6; i++){
        //   if (shape.containsPoint(motionEvent.getX(), motionEvent.getY())){
        //       element.setText(shape.getName());

         //  }
       //}

        return false;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        return false;s4r
    }
}
