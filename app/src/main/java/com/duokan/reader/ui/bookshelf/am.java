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

public class am extends Drawable implements Animatable {
    /* renamed from: a */
    private final Context f6116a;
    /* renamed from: b */
    private final Drawable f6117b;
    /* renamed from: c */
    private final AnimationDrawable f6118c;
    /* renamed from: d */
    private Callback f6119d = new an(this);

    public am(Context context) {
        this.f6116a = context;
        this.f6117b = this.f6116a.getResources().getDrawable(C0243e.bookshelf__shared__book_download_background);
        this.f6118c = (AnimationDrawable) this.f6116a.getResources().getDrawable(C0243e.bookshelf__shared__book_download_arrow);
        this.f6118c.setCallback(this.f6119d);
    }

    public void start() {
        if (!this.f6118c.isRunning()) {
            this.f6118c.start();
        }
    }

    public void stop() {
        if (this.f6118c.isRunning()) {
            this.f6118c.setVisible(true, true);
            this.f6118c.stop();
        }
    }

    public boolean isRunning() {
        return this.f6118c.isRunning();
    }

    public void draw(Canvas canvas) {
        this.f6117b.draw(canvas);
        this.f6118c.draw(canvas);
    }

    public void setAlpha(int i) {
        this.f6117b.setAlpha(i);
        this.f6118c.setAlpha(i);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        this.f6117b.setColorFilter(colorFilter);
        this.f6118c.setColorFilter(colorFilter);
    }

    public int getIntrinsicWidth() {
        return this.f6117b.getIntrinsicWidth();
    }

    public int getIntrinsicHeight() {
        return this.f6117b.getIntrinsicHeight();
    }

    public int getOpacity() {
        return -3;
    }

    protected boolean onLevelChange(int i) {
        return this.f6117b.setLevel(i);
    }

    protected void onBoundsChange(Rect rect) {
        this.f6117b.setBounds(rect);
        this.f6118c.setBounds(rect);
    }
}
