package com.duokan.reader.ui.general;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.Drawable;

class dt extends Drawable {
    final /* synthetic */ ds a;

    dt(ds dsVar) {
        this.a = dsVar;
    }

    public void draw(Canvas canvas) {
        this.a.e();
        this.a.a(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return -3;
    }
}
