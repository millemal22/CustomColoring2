package com.example.customcoloring2;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Canvas;
import android.os.Bundle;
import android.text.Layout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
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
        //Layout Widgets
        View seekbars = findViewById(R.id.seekbars);
        View doodle = findViewById(R.id.doodleLayout);
        View wrapped = findViewById(R.id.Necessary);
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
        SeekBar.OnSeekBarChangeListener GseekListener = new ElementChange(drawing, wrapped);
        SeekBar.OnSeekBarChangeListener RseekListener = new ElementChange(drawing, wrapped);
        SeekBar.OnSeekBarChangeListener BseekListener = new ElementChange(drawing, wrapped);

        //Seekbar Listeners
        redSeek.setOnSeekBarChangeListener(RseekListener);
        greenSeek.setOnSeekBarChangeListener(GseekListener);
        blueSeek.setOnSeekBarChangeListener(BseekListener);

        //TextView Listener for Element Name
        View.OnTouchListener touch = new ElementChange(drawing, wrapped);
        drawing.setOnTouchListener(touch);
    }

}
