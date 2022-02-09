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
    ShapeMaker[] shapes = getShapeArray();
    private int color;
    private int x;
    private int y;
    private int radius;

    //makes the drawing?
    public Drawing(Context context){
        super(context);
        initPaints();
        setWillNotDraw(false);
    }

    //also makes the drawing
    public Drawing(Context context, AttributeSet attr){
        super(context, attr);
        initPaints();
        setWillNotDraw(false);
    }

    //also also makes the drawing also
    public Drawing (Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaints();
        setWillNotDraw(false);
    }

    //changes the paintbrush and paint color
    private void initPaints(){
        this.paintColor.getColor();
        this.paintColor.setColor(Color.BLACK);
        this.paintColor.setStyle(Paint.Style.FILL);
    }

    public void setPaintColor(int color){
        this.paintColor.setColor(color);
        this.invalidate();
    }

    //should draw a circle just to test if the color slider works.
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);
        //for loop to pick which circle is drawn?
        //canvas.drawOval(100, 100, 200, 200, paintColor);
        //canvas.drawOval(200, 200, 300, 300, paintColor);
        //canvas.drawOval(300, 300, 400, 400, paintColor);

        insert(shapes, canvas);
    }


}
