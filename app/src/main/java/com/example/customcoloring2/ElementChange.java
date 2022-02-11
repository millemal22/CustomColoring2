package com.example.customcoloring2;

import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class ElementChange implements View.OnTouchListener {
    private Drawing drawing = null;
    private TextView message;


    //Change name
    public ElementChange(TextView msg, Drawing initDrawing) {

        this.drawing = initDrawing;
        this.message = msg;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        this.message.setText("works");
        return false;
    }
}
