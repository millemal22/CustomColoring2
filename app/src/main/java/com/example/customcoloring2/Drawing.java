package com.example.customcoloring2;

import static android.graphics.Color.convert;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class Drawing extends SurfaceView {

    //paint instance
    Paint paintColor = new Paint();
    private int color;
    private int x;
    private int y;
    private int radius;
    public ShapeMaker[] shapeArray = new ShapeMaker[6];

    //makes the drawing?
    public Drawing(Context context){
        super(context);
        setWillNotDraw(false);
    }

    //also makes the drawing
    public Drawing(Context context, AttributeSet attr){
        super(context, attr);
        setWillNotDraw(false);
    }

    //also also makes the drawing also
    public Drawing (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setWillNotDraw(false);
    }


    //should draw the test circles
    public void onDraw(Canvas canvas/*, ShapeMaker[] shapes*/){
        super.onDraw(canvas);
        setWillNotDraw(false);
        //this.shapeArray = shapes;

        //draws my circles
        canvas.drawOval(, 50, 350, 300, paintColor);
        canvas.drawOval(50, 350, 350, 600, paintColor);
        canvas.drawOval(50, 650, 350, 900, paintColor);
        canvas.drawOval(800, 50, 1100, 300, paintColor);
        canvas.drawOval(800, 350, 1100, 600, paintColor);
        canvas.drawOval(800, 650, 1100, 900, paintColor);


    }


}
