package com.example.customcoloring2;

import android.graphics.Color;

public class ShapeMaker{
    String name = "";
    int x;
    int y;
    int rProg = 0;
    int gProg = 0;
    int bProg = 0;
    int endX = x+300;
    int endY = y+300;
    int radius = 300;
    boolean tapped = false;
    int color = 0xFF000000 + rProg * 256 * 256 + gProg * 256 + bProg;
}
