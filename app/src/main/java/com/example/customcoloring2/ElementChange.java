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
    public boolean OnTouch(View view, MotionEvent motionEvent) {

        return true;

    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

       // TextView element = findViewById(R.id.element);

       // for (int i=0; i<6; i++){
           // if (shapeArray[i].containsPoint(motionEvent.getX(), motionEvent.getY())){
         //       element.setText(shapeArray[i].name);
            //}
        //}

        return false;
    }
}
