package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import com.duokan.p023b.C0243e;

public class bf extends Drawable implements Animatable {
    /* renamed from: a */
    private final Context f6158a;
    /* renamed from: b */
    private final Drawable f6159b;
    /* renamed from: c */
    private final AnimationDrawable f6160c;
    /* renamed from: d */
    private Callback f6161d = new bg(this);

    public bf(Context context) {
        this.f6158a = context;
        this.f6159b = this.f6158a.getResources().getDrawable(C0243e.bookshelf__shared__book_upload_background);
        this.f6160c = (AnimationDrawable) this.f6158a.getResources().getDrawable(C0243e.bookshelf__shared__book_upload_arrow);
        this.f6160c.setCallback(this.f6161d);
    }

    public void start() {
        if (!this.f6160c.isRunning()) {
            this.f6160c.start();
        }
    }

    public void stop() {
        if (this.f6160c.isRunning()) {
            this.f6160c.setVisible(true, true);
            this.f6160c.stop();
        }
    }

    public boolean isRunning() {
        return this.f6160c.isRunning();
    }

    public void draw(Canvas canvas) {
        this.f6159b.draw(canvas);
        this.f6160c.draw(canvas);
    }

    public void setAlpha(int i) {
        this.f6159b.setAlpha(i);
        this.f6160c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6159b.setColorFilter(colorFilter);
        this.f6160c.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        return this.f6159b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f6159b.getIntrinsicHeight();
    }

    public int getOpacity() {
        return -3;
    }

    protected boolean onLevelChange(int i) {
        return this.f6159b.setLevel(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f6159b.setBounds(rect);
        this.f6160c.setBounds(rect);
    }
}
