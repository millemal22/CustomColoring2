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
    Paint paintColor;
    private int color;
    private int left;
    private int top;
    private int radius;
    int right;
    int bottom;

    private ObjectArray array = new ObjectArray();
    ShapeMaker[] shapeArray = array.array;

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
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        MakeArray();

        //draws my circles
       for (int i=0; i<6; i++){
           this.left = shapeArray[i].x;
           this.top = shapeArray[i].y;
           this.radius = shapeArray[i].radius;
           this.right = this.left + this.radius;
           this.bottom = this.top + this.radius;
           paintColor = new Paint();
           paintColor.setColor(shapeArray[i].color);

           canvas.drawOval(this.left, this.top, this.right, this.bottom, paintColor);
       }
        //paintColor = new Paint();
        //paintColor.setColor(Color.RED);
        //canvas.drawOval(20, 20, 1400, 900, paintColor);

    }

    public void MakeArray(){

        //Shape Array
        array.shape1.x = 50;
        array.shape1.y = 20;
        array.shape1.name = "Shape 1";
        shapeArray[0] = array.shape1;

        array.shape2.x = 50;
        array.shape2.y = 320;
        array.shape2.name = "Shape 2";
        shapeArray[1] = array.shape2;

        array.shape3.x = 50;
        array.shape3.y = 620;
        array.shape3.name = "Shape 3";
        shapeArray[2] = array.shape3;

        array.shape4.x = 800;
        array.shape4.y = 20;
        array.shape4.name = "Shape 4";
        shapeArray[3] = array.shape4;

        array.shape5.x = 800;
        array.shape5.y = 320;
        array.shape5.name = "Shape 5";
        shapeArray[4] = array.shape5;

        array.shape6.x = 800;
        array.shape6.y = 620;
        array.shape6.name = "Shape 6";
        shapeArray[5] = array.shape6;

        array.array = shapeArray;
    }

    public ObjectArray getArray(){
        return array; }


}
