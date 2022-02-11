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

    //Shape Constructor
    public ShapeMaker(String name, int color, int x, int y, int radius){
        super(name, color);

        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;
    }


    public ShapeMaker(String name, int paintColor) {
        super(name, paintColor);

    }

    @Override
    public void drawMe(Canvas canvas){
        }

    @Override
    public String getName(){
        return null;
    }
}
