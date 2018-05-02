package com.duokan.reader.ui.personal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

class hb extends Drawable {
    final /* synthetic */ ClipDrawable a;
    final /* synthetic */ fl b;

    hb(fl flVar, ClipDrawable clipDrawable) {
        this.b = flVar;
        this.a = clipDrawable;
    }

    public void draw(Canvas canvas) {
        this.a.setBounds(0, 0, this.b.d.getWidth(), this.b.d.getHeight());
        this.a.setLevel((this.b.d.getHeight() * 10000) / this.b.d.getHeight());
        this.a.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
