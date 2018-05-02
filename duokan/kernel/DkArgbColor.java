package com.duokan.kernel;

import android.graphics.Color;

public class DkArgbColor {
    public int mAlpha = 0;
    public int mBlue = 0;
    public int mGreen = 0;
    public int mRed = 0;

    public DkArgbColor(int i) {
        this.mAlpha = Color.alpha(i);
        this.mRed = Color.red(i);
        this.mGreen = Color.green(i);
        this.mBlue = Color.blue(i);
    }
}
