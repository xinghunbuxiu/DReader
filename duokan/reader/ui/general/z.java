package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

import com.duokan.core.ui.UTools;

public abstract class z extends Drawable {
    protected static final int b = ((int) Math.round(76.5d));
    private int a = 255;
    protected final Context c;
    protected final ab d;
    protected final Rect e = new Rect();
    protected final Rect f = new Rect();
    protected boolean g = false;
    private final Callback h = new aa(this);

    public z(Context context, boolean z) {
        this.c = context;
        int b = UTools.getMinimumHeight(this.c, 5.0f);
        this.e.set(b, b, b, b);
        this.d = new ab(this);
        this.d.setCallback(this.h);
        this.d.getPadding(this.f);
        this.g = z;
    }

    public void f() {
        this.d.b();
    }

    public void g() {
        this.d.c();
    }

    protected void a(boolean z) {
        this.g = z;
    }

    public boolean getPadding(Rect rect) {
        if (this.g) {
            rect.set(this.f);
        }
        return !rect.isEmpty();
    }

    public void setBounds(int i, int i2, int i3, int i4) {
        super.setBounds(i, i2, i3, i4);
        this.d.setBounds(getBounds());
    }

    public void draw(Canvas canvas) {
        if (this.g || this.d.a()) {
            canvas.save();
            this.d.draw(canvas);
            canvas.restore();
        }
    }

    public void setAlpha(int i) {
        this.d.setAlpha(i);
    }
}
