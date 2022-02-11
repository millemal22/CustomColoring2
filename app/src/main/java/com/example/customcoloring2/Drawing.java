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
    public Shapes[] shapeArray = new Shapes[6];

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

    //right now this method isn't called, but it was supposed to make each circle individually so they are different colors
    //public void insert(ShapeMaker[] shapes, Canvas canvas){

        //setWillNotDraw(false);
        //this.shapeArray = shapes;

        //for (int i=0; i<6; i++){
            //Paint paintColor = new Paint(shapes[i].getColor());
            //canvas.drawOval(shapes[i].x, shapes[i].y, (shapes[i].x + shapes[i].radius), (shapes[i].y + shapes[i].radius), paintColor);
        //}
    //}


    //should draw the test circles
    public void onDraw(Canvas canvas/*, ShapeMaker[] shapes*/){
        super.onDraw(canvas);
        setWillNotDraw(false);
        //this.shapeArray = shapes;

        //draws my circles
        canvas.drawOval(50, 50, 350, 300, paintColor);
        canvas.drawOval(50, 350, 350, 600, paintColor);
        canvas.drawOval(50, 650, 350, 900, paintColor);
        canvas.drawOval(800, 50, 1100, 300, paintColor);
        canvas.drawOval(800, 350, 1100, 600, paintColor);
        canvas.drawOval(800, 650, 1100, 900, paintColor);

        //I could not get the variables to carry over when I set this.shapeArray = shapes
        //for (int i=0; i<6; i++){
        //    Paint paintColor = new Paint(shapes[i].color);
        //    canvas.drawOval(shapes[i].x, shapes[i].y, (shapes[i].x + shapes[i].radius), (shapes[i].y + shapes[i].radius), paintColor);
        //}

        //insert(shapes, canvas);

    }


}
