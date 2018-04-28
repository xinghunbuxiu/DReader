package com.duokan.core.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.widget.FrameLayout;

class dd extends FrameLayout {
    /* renamed from: a */
    private static Paint f1134a = new Paint();

    public dd(Context context) {
        super(context);
        f1134a.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        setWillNotDraw(false);
        setDrawingCacheEnabled(false);
        setAnimationCacheEnabled(false);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (cv.f1096d != Color.argb(255, 255, 255, 255)) {
            f1134a.setColor(cv.f1096d);
            canvas.drawRect(0.0f, 0.0f, (float) getWidth(), (float) getHeight(), f1134a);
        }
    }
}
