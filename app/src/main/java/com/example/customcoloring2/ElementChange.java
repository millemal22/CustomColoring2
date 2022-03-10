package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ElementChange implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    private SeekBar redSeek;
    private TextView rProg;
    private SeekBar greenSeek;
    private TextView gProg;
    private SeekBar blueSeek;
    private TextView bProg;
    private TextView ele;
    private Drawing drawing;
    private ObjectArray array;
    private Paint paintColor;
    private int hex;
    private int tapX;
    private int tapY;
    int r;
    int g;
    int b;
    private int shapeRadius;
    public static final int TAP_MARGIN = 10;


    //Change name of shape
    public ElementChange(Drawing d, View layout) {
        drawing = d;
        array = d.getArray();

        rProg = layout.findViewById(R.id.redCount);
        gProg = layout.findViewById(R.id.greenCount);
        bProg = layout.findViewById(R.id.blueCount);
        ele = layout.findViewById(R.id.element);

        redSeek = layout.findViewById(R.id.redSeekBar);
        greenSeek = layout.findViewById(R.id.greenSeekBar);
        blueSeek = layout.findViewById(R.id.blueSeekBar);

    }

    //This works, but not entirely
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        this.tapX = (int)motionEvent.getX();
        this.tapY = (int)motionEvent.getY();
        int currTap = -1;

        for (int i=0; i<6; i++) {

            Log.d("entered", "Entered");

            this.shapeRadius = drawing.shapeArray[i].radius;
            //ele.setText("works");

            if (containsPoint(drawing.shapeArray[i].x, drawing.shapeArray[i].y, this.tapX, this.tapY) == true) {
                Log.d("containsPoint", "does");
                currTap = i;
                drawing.shapeArray[i].tapped = true;
            }
            else {
                Log.d("containsPoint", "doesn't");
                drawing.shapeArray[i].tapped = false;
            }
        }


        if (currTap >= 0) {
            this.ele.setText(drawing.shapeArray[currTap].name);
            redSeek.setProgress(drawing.shapeArray[currTap].rProg);
            greenSeek.setProgress(drawing.shapeArray[currTap].gProg);
            blueSeek.setProgress(drawing.shapeArray[currTap].bProg);
        }

        return false;
    }

    //This definitely works
    public boolean containsPoint(int x, int y, int tapX, int tapY){
        //Calculate the distance between this point and the center

        if ( tapX >= x && tapX <= x+this.shapeRadius){
            if (tapY >= y && tapY <= y+this.shapeRadius){
                return true;
            }
            else{ return false; }
        }
        else{ return false; }
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

        Log.d("SeekBar", "entered");

        //should be converting into hexadecimal code for the paint color as the sliders move
        //I got help with this from Jake Uyechi but updated some parts to fit my needs
        //@author Jake Uyechi
        this.r = redSeek.getProgress();
        this.g = greenSeek.getProgress();
        this.b = blueSeek.getProgress();


        this.rProg.setText("" + r);
        this.gProg.setText("" + g);
        this.bProg.setText("" + b);

        hex = 0xFF000000 + r * 256 * 256 + g * 256 + b;

        for (int i=0; i<6; i++){
            if (drawing.shapeArray[i].tapped == true){

                Log.d("set new color", "works");
                drawing.shapeArray[i].rProg = this.r;
                drawing.shapeArray[i].gProg = this.g;
                drawing.shapeArray[i].bProg = this.b;
                drawing.shapeArray[i].color = hex;
            }
        }
        drawing.invalidate();

    }


    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //empty
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //empty
    }

}
