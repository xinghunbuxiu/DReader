package com.duokan.reader.ui.personal;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;

class ho extends Drawable {
    /* renamed from: a */
    final /* synthetic */ ClipDrawable f8665a;
    /* renamed from: b */
    final /* synthetic */ fz f8666b;

    ho(fz fzVar, ClipDrawable clipDrawable) {
        this.f8666b = fzVar;
        this.f8665a = clipDrawable;
    }

    public void draw(Canvas canvas) {
        this.f8665a.setBounds(0, 0, this.f8666b.f8577d.getWidth(), this.f8666b.f8577d.getHeight());
        this.f8665a.setLevel((this.f8666b.f8577d.getHeight() * 10000) / this.f8666b.f8577d.getHeight());
        this.f8665a.draw(canvas);
    }

    public void setAlpha(int i) {
    }

    public void setColorFilter(ColorFilter colorFilter) {
    }

    public int getOpacity() {
        return 0;
    }
}
