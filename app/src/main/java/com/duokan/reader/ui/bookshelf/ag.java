package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;

import com.duokan.b.e;

public class ag extends Drawable implements Animatable {
    private final Context a;
    private final Drawable b;
    private final AnimationDrawable c;
    private Callback d = new ah(this);

    public ag(Context context) {
        this.a = context;
        this.b = this.a.getResources().getDrawable(e.bookshelf__shared__book_download_background);
        this.c = (AnimationDrawable) this.a.getResources().getDrawable(e.bookshelf__shared__book_download_arrow);
        this.c.setCallback(this.d);
    }

    public void start() {
        if (!this.c.isRunning()) {
            this.c.start();
        }
    }

    public void stop() {
        if (this.c.isRunning()) {
            this.c.setVisible(true, true);
            this.c.stop();
        }
    }

    public boolean isRunning() {
        return this.c.isRunning();
    }

    public void draw(Canvas canvas) {
        this.b.draw(canvas);
        this.c.draw(canvas);
    }

    public void setAlpha(int i) {
        this.b.setAlpha(i);
        this.c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.b.setColorFilter(colorFilter);
        this.c.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        return this.b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.b.getIntrinsicHeight();
    }

    public int getOpacity() {
        return -3;
    }

    protected boolean onLevelChange(int i) {
        return this.b.setLevel(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.b.setBounds(rect);
        this.c.setBounds(rect);
    }
}
