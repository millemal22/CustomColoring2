package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;

//I don't actually think I ended up using this class
public abstract class Shapes {


    protected String eleName = "Current Element";
    protected Paint myPaint = new Paint();

    public Shapes(String name, int paintColor) {
        setColor(paintColor);
        this.eleName = name;
    }


    public String getEleName() {
        return this.eleName;
    }

    public void setColor(int paintColor) {
        if (paintColor == myPaint.getColor()) {
            return;
        }
        this.myPaint.setColor(paintColor);
    }

    public int getColor() {
        return this.myPaint.getColor();
    }


    public abstract void drawMe(Canvas canvas);

    public abstract String getName();

}

