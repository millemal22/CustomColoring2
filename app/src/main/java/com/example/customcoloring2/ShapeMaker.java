package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Paint;

public class ShapeMaker extends Shapes{
    private int x;
    private int y;
    private int radius;


    public ShapeMaker(String name, int color, int x, int y, int radius){
        super(name, color);

        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public ShapeMaker(String name, int paintColor) {
        super(name, paintColor);

    }

    @Override
    public void drawMe(Canvas canvas, Shapes[] shapes){
            for (int i=0; i<6; i++){
                Paint color = new Paint(shapes[i].paintColor);
                canvas.drawOval(this.x, this.y, this.x+(2*this.radius), this.y+(2*this.radius), color);
            }
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
    public int getSize(){
        return (int)(Math.PI*this.radius*this.radius);
    }
}
