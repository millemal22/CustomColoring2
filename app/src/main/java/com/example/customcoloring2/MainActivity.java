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
    public Shapes[] shapeArray = new Shapes[6];

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
        shapeArray[0] = new NewShape("Circle 0", shapeArray[0].getColor(), 100, 100 ,100);
        shapeArray[1] = new NewShape("Circle 1", shapeArray[1].getColor(), 200, 200, 100);
        shapeArray[2] = new NewShape("Circle 2", shapeArray[2].getColor(), 300, 300, 100);
        shapeArray[3] = new NewShape("Circle 3", shapeArray[3].getColor(), 400, 400, 100);
        shapeArray[4] = new NewShape("Circle 4", shapeArray[4].getColor(), 500, 500, 100);
        shapeArray[5] = new NewShape("Circle 5", shapeArray[5].getColor(), 600 , 600, 100);
    }

    public ShapeMaker[] getShapeArray(){ return (ShapeMaker[]) shapeArray;}
}
