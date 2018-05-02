package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.widget.FrameLayout;

class dd extends FrameLayout {
    private static Paint a = new Paint();

    public dd(Context context) {
        super(context);
        a.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (cv.d != Color.argb(255, 255, 255, 255)) {
            a.setColor(cv.d);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), a);
        }
    }
}
