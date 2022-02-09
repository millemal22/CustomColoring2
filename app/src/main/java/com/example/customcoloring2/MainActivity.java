package com.example.customcoloring2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

// @author Maliyah Miller

public class MainActivity extends AppCompatActivity {

    int hex;

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

        //Seekbar Updates
        SeekBar.OnSeekBarChangeListener GseekListener = new SeekBarHandler(greenBar, redSeek, greenSeek, blueSeek, drawing);
        SeekBar.OnSeekBarChangeListener RseekListener = new SeekBarHandler(redBar, redSeek, greenSeek, blueSeek, drawing);
        SeekBar.OnSeekBarChangeListener BseekListener = new SeekBarHandler(blueBar, redSeek, greenSeek, blueSeek, drawing);

        redSeek.setOnSeekBarChangeListener(RseekListener);
        greenSeek.setOnSeekBarChangeListener(GseekListener);
        blueSeek.setOnSeekBarChangeListener(BseekListener);

        //Shape Array
        //Shapes[] shapeArray = new Shapes[6];
        //shapeArray[0] = new ShapeMaker("Circle 0", shapeArray[0].getColor());
        //shapeArray[1] = new ShapeMaker("Circle 1", shapeArray[1].getColor());
        //shapeArray[2] = new ShapeMaker("Circle 2", shapeArray[2].getColor());
        //shapeArray[3] = new ShapeMaker("Circle 3", shapeArray[3].getColor());
        //shapeArray[4] = new ShapeMaker("Circle 4", shapeArray[4].getColor());
        //shapeArray[5] = new ShapeMaker("Circle 5", shapeArray[5].getColor());

    }
}
