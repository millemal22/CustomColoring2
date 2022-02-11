package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.Shape;

public class ShapeMaker extends Shapes{
    String name;
    int color;
    int x;
    int y;
    int radius;

    public ShapeMaker(String name, int color, int x, int y, int radius){ super(name, color); }


    public ShapeMaker(String name, int paintColor) {
        super(name, paintColor);

    }

    @Override
    public void drawMe(Canvas canvas){
        }

    @Override
    public boolean containsPoint(int x, int y){
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - this.x);
        int yDist = Math.abs(y - this.y);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);
        return (dist < this.radius + TAP_MARGIN);
    }

    @Override
    public String getName(){
        return null;
    }
}
