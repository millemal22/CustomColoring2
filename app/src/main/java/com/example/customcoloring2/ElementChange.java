package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.TextView;

public class ElementChange implements View.OnTouchListener {
    private Drawing drawing = null;
    private TextView message;
    private ShapeMaker[] shapeArray;
    private Canvas canvas;
    private Paint paintColor;
    private int tapX;
    private int tapY;
    private int shapeRadius;
    public static final int TAP_MARGIN = 10;


    //Change name of shape
    public ElementChange(TextView msg, Drawing initDrawing, ShapeMaker[] shapes) {

        this.drawing = initDrawing;
        this.message = msg;
        this.shapeArray = shapes;
    }

    //This works, but not entirely
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        this.tapX = (int)motionEvent.getX();
        this.tapY = (int)motionEvent.getY();

        for (int i=0; i<6; i++) {

            this.shapeRadius = this.shapeArray[i].radius;

            if (containsPoint(this.shapeArray[i].x, this.shapeArray[i].y, this.tapX, this.tapY) == true) {
                this.message.setText(this.shapeArray[i].name);
                reDraw(canvas, this.shapeArray[i]);
            }
        }
        return false;
    }

    //This definitely works
    public boolean containsPoint(int x, int y, int tapX, int tapY){
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - tapX);
        int yDist = Math.abs(y - tapY);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);
        return (dist < this.shapeRadius + TAP_MARGIN);
    }
    //This doesn't work. The drawing changes the colors of all the circles
    public void reDraw(Canvas canvas, ShapeMaker shape){

        int x2 = shape.x + shape.radius;
        int y2 = shape.y + shape.radius;
        this.drawing.setPaintColor(shape.color);

        //this should have reassigned the shape to have the slider color
        //shape.color = this.drawing.getSolidColor();
        //Drawing redo = new Drawing(this.drawing.getContext());
    }
}
