package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Color;

public class NewShape extends ShapeMaker{

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


    public void insert(ShapeMaker[] shapes, Canvas canvas){
        for (int i=0; i<6; i++){
            canvas.drawOval(shapes[i].x, shapes[i].y, (shapes[i].x + shapes[i].radius), (shapes[i].y + shapes[i].radius), paintColor);
        }
    }
}
