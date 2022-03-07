package com.example.customcoloring2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

// @author Maliyah Miller

public class MainActivity extends AppCompatActivity {

    int hex;
    public ShapeMaker[] shapeArray = new ShapeMaker[6];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Shapes
        ShapeMaker shape1 = new ShapeMaker();
        ShapeMaker shape2 = new ShapeMaker();
        ShapeMaker shape3 = new ShapeMaker();
        ShapeMaker shape4 = new ShapeMaker();
        ShapeMaker shape5 = new ShapeMaker();
        ShapeMaker shape6 = new ShapeMaker();

        //Shape Array
        shape1.x = 50;
        shape1.y = 50;
        shape1.name = "Shape 1";
        shapeArray[0] = shape1;

        shape2.x = 50;
        shape2.y = 350;
        shape2.name = "Shape 2";
        shapeArray[1] = shape2;

        shape3.x = 50;
        shape3.y = 650;
        shape3.name = "Shape 3";
        shapeArray[2] = shape3;

        shape4.x = 800;
        shape4.y = 50;
        shape4.name = "Shape 4";
        shapeArray[3] = shape4;

        shape5.x = 800;
        shape5.y = 350;
        shape5.name = "Shape 5";
        shapeArray[4] = shape5;

        shape6.x = 800;
        shape6.y = 650;
        shape6.name = "Shape 6";
        shapeArray[5] = shape6;

        //drawing widget
        Drawing drawing = findViewById(R.id.drawing);
        //Red Seekbar Listener
        TextView redBar = findViewById(R.id.redCount);
        //Green Seekbar Listener
        TextView greenBar = findViewById(R.id.greenCount);
        //Blue Seekbar Listener
        TextView blueBar = findViewById(R.id.blueCount);

        //Changes the bar progress count for red
        SeekBar redSeek = findViewById(R.id.redSeekBar);
        redSeek.setProgress(0);
        //Changes the bar progress count for green
        SeekBar greenSeek = findViewById(R.id.greenSeekBar);
        greenSeek.setProgress(0);
        //Changes the bar progress count for blue
        SeekBar blueSeek = findViewById(R.id.blueSeekBar);
        blueSeek.setProgress(0);

        //Seekbar Color Updates
        SeekBar.OnSeekBarChangeListener GseekListener = new ElementChange(greenBar, drawing, shapeArray, redSeek, greenSeek, blueSeek);
        SeekBar.OnSeekBarChangeListener RseekListener = new ElementChange(redBar, drawing, shapeArray, redSeek, greenSeek, blueSeek);
        SeekBar.OnSeekBarChangeListener BseekListener = new ElementChange(blueBar, drawing, shapeArray, redSeek, greenSeek, blueSeek);

        //Seekbar Listeners
        redSeek.setOnSeekBarChangeListener(RseekListener);
        greenSeek.setOnSeekBarChangeListener(GseekListener);
        blueSeek.setOnSeekBarChangeListener(BseekListener);

        //TextView Listener for Element Name
        TextView msg = findViewById(R.id.element);
        View.OnTouchListener touch = new ElementChange(msg, drawing, shapeArray, redSeek, greenSeek, blueSeek);
        drawing.setOnTouchListener(touch);
    }

}
