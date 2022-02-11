package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class NewShape extends ShapeMaker {

    private String name;
    private int color;
    private int x;
    private int y;
    private int radius;

    public NewShape(String name, int color, int x, int y, int radius) {
        super(name, color, x, y, radius);
    }

    public ShapeMaker NewShape(String name, int color, int x, int y, int radius) {
        this.name = name;
        this.color = color;
        this.x = x;
        this.y = y;
        this.radius = radius;

        return NewShape(name, color, x, y, radius);
    }
}



