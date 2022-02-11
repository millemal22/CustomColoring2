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

    public void insert(ShapeMaker[] shapes, Canvas canvas){

        for (int i=0; i<6; i++){
            Paint paintColor = new Paint(shapes[i].getColor());
            canvas.drawOval(shapes[i].x, shapes[i].y, (shapes[i].x + shapes[i].radius), (shapes[i].y + shapes[i].radius), paintColor);
        }
    }

    //public void makeShapeArray(){
        //Shape Array
   //     shapeArray[0] = new NewShape("Circle 0", shapeArray[0].getColor(), 100, 100 ,100);
     //   shapeArray[1] = new NewShape("Circle 1", shapeArray[1].getColor(), 200, 200, 100);
       // shapeArray[2] = new NewShape("Circle 2", shapeArray[2].getColor(), 300, 300, 100);
  //      shapeArray[3] = new NewShape("Circle 3", shapeArray[3].getColor(), 400, 400, 100);
    //    shapeArray[4] = new NewShape("Circle 4", shapeArray[4].getColor(), 500, 500, 100);
      //  shapeArray[5] = new NewShape("Circle 5", shapeArray[5].getColor(), 600 , 600, 100);
    //}

//    public ShapeMaker[] getShapeArray(){ return (ShapeMaker[]) shapeArray;}

    //should draw a circle just to test if the color slider works.
    public void onDraw(Canvas canvas){
        super.onDraw(canvas);

        //for loop to pick which circle is drawn?
        canvas.drawOval(100, 100, 200, 200, paintColor);
        canvas.drawOval(100, 200, 200, 300, paintColor);
        canvas.drawOval(100, 300, 200, 400, paintColor);
        canvas.drawOval(300, 100, 400, 200, paintColor);
        canvas.drawOval(300, 200, 400, 300, paintColor);
        canvas.drawOval(300, 300, 400, 400, paintColor);



    }

    public void reDraw(Canvas canvas, ShapeMaker shape){

        int x2 = shape.x + shape.radius;
        int y2 = shape.y + shape.radius;
        canvas.drawOval(shape.x, shape.y, x2, y2, paintColor);

    }


}
