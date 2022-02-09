package com.example.customcoloring2;

import android.widget.SeekBar;
import android.widget.TextView;

//This was copied from the notes we took in class
//@author Mr. Nuxoll
public class SeekBarHandler implements SeekBar.OnSeekBarChangeListener {
    private TextView updateMe = null;


    private SeekBar redSeek;
    private SeekBar greenSeek;
    private SeekBar blueSeek;
    private int hex;
    private Drawing draw;

    public SeekBarHandler(TextView count, SeekBar r, SeekBar g, SeekBar b, Drawing d) {
        this.updateMe = count;
        redSeek = r;
        greenSeek = g;
        blueSeek = b;
        draw = d;
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        this.updateMe.setText("" + progress);

        //should be converting into hexadecimal code for the paint color as the sliders move
        //I got help with this from Jake Uyechi but updated some parts to fit my needs
        //@author Jake Uyechi
        int r = redSeek.getProgress();
        int g = greenSeek.getProgress();
        int b = blueSeek.getProgress();

        hex = 0xFF000000 + r * 256 * 256 + g * 256 + b;
        draw.setPaintColor(hex);

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
