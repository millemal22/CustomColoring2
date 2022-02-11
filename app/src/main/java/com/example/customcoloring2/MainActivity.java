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
        SeekBar.OnSeekBarChangeListener GseekListener = new SeekBarHandler(greenBar, redSeek, greenSeek, blueSeek, drawing);
        SeekBar.OnSeekBarChangeListener RseekListener = new SeekBarHandler(redBar, redSeek, greenSeek, blueSeek, drawing);
        SeekBar.OnSeekBarChangeListener BseekListener = new SeekBarHandler(blueBar, redSeek, greenSeek, blueSeek, drawing);

        //Seekbar Listeners
        redSeek.setOnSeekBarChangeListener(RseekListener);
        greenSeek.setOnSeekBarChangeListener(GseekListener);
        blueSeek.setOnSeekBarChangeListener(BseekListener);

        //TextView Listener for Element Name
        TextView msg = findViewById(R.id.element);
        View.OnTouchListener touch = new ElementChange(msg, drawing);
        drawing.setOnTouchListener(touch);

        //Shapes
        ShapeMaker shape1 = new ShapeMaker("circle1", 0xFF000000, 100, 100, 100);
        ShapeMaker shape2 = new ShapeMaker("circle2", 0xFF000000, 100, 200, 100);
        ShapeMaker shape3 = new ShapeMaker("circle3", 0xFF000000, 100, 300, 100);
        ShapeMaker shape4 = new ShapeMaker("circle4", 0xFF000000, 300, 100, 100);
        ShapeMaker shape5 = new ShapeMaker("circle5", 0xFF000000, 300, 200, 100);
        ShapeMaker shape6 = new ShapeMaker("circle6", 0xFF000000, 300, 300, 100);

        //Shape Array
        //shapeArray


    }

}
