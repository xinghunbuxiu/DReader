package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;

import com.duokan.reader.domain.document.as;

class jb extends View {
    final /* synthetic */ FixedPageClipView a;
    private as b;
    private RectF c;
    private final Callback d;

    public jb(FixedPageClipView fixedPageClipView, Context context) {
        this.a = fixedPageClipView;
        super(context);
        this.b = fixedPageClipView.e.getDocument().a(fixedPageClipView.e.Z());
        this.d = new jc(this, fixedPageClipView);
        this.b.setCallback(this.d);
        setWillNotDraw(false);
    }

    public Drawable a() {
        return this.b;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF b = b();
        this.b.setBounds((int) b.left, (int) b.top, getWidth() - ((int) b.right), getHeight() - ((int) b.bottom));
        this.b.a(new Rect(-((int) b.left), -((int) b.top), getWidth(), getHeight()));
        this.b.a(getWidth());
        this.b.b(getHeight());
        this.b.draw(canvas);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.b != null) {
            this.b.H();
        }
    }

    private RectF b() {
        if (this.c == null) {
            this.c = new RectF();
            RectF rectF = this.a.d.d()[0];
            this.c.left = rectF.left * ((float) getWidth());
            this.c.right = rectF.right * ((float) getWidth());
            this.c.top = rectF.top * ((float) getHeight());
            this.c.bottom = rectF.bottom * ((float) getHeight());
        }
        return this.c;
    }
}
