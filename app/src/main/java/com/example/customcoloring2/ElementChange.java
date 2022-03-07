package com.example.customcoloring2;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.shapes.OvalShape;
import android.view.MotionEvent;
import android.view.SurfaceView;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class ElementChange implements View.OnTouchListener, SeekBar.OnSeekBarChangeListener {

    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private Drawing drawing = null;
    private TextView message;
    private ShapeMaker[] shapeArray;
    private Canvas canvas;
    private Paint paintColor;
    private int hex;
    private int tapX;
    private int tapY;
    private int shapeRadius;
    public static final int TAP_MARGIN = 10;


    //Change name of shape
    public ElementChange(TextView msg, Drawing initDrawing, ShapeMaker[] shapes, SeekBar r, SeekBar g, SeekBar b) {

        this.drawing = initDrawing;
        this.message = msg;
        this.shapeArray = shapes;
        redSeek = r;
        greenSeek = g;
        blueSeek = b;
    }

    //This works, but not entirely
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {

        this.tapX = (int)motionEvent.getX();
        this.tapY = (int)motionEvent.getY();

        for (int i=0; i<6; i++) {

            this.shapeRadius = this.shapeArray[i].radius;

            if (containsPoint(this.shapeArray[i].x, this.shapeArray[i].y, this.tapX, this.tapY) == true) {
                this.message.setText(this.shapeArray[i].name);
                this.shapeArray[i].tapped = true;
            }
            else {
                this.shapeArray[i].tapped = false;
            }
        }
        return false;
    }

    //This definitely works
    public boolean containsPoint(int x, int y, int tapX, int tapY){
        //Calculate the distance between this point and the center
        int xDist = Math.abs(x - tapX);
        int yDist = Math.abs(y - tapY);
        int dist = (int)Math.sqrt(xDist*xDist + yDist*yDist);
        return (dist < this.shapeRadius + TAP_MARGIN);
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.message.setText("" + progress);

        //should be converting into hexadecimal code for the paint color as the sliders move
        //I got help with this from Jake Uyechi but updated some parts to fit my needs
        //@author Jake Uyechi
        int r = redSeek.getProgress();
        int g = greenSeek.getProgress();
        int b = blueSeek.getProgress();

        hex = 0xFF000000 + r * 256 * 256 + g * 256 + b;

        for (int i=0; i<6; i++){
            if (this.shapeArray[i].tapped == true){
                this.shapeArray[i].color = hex;
                this.drawing.invalidate();
            }
        }

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
