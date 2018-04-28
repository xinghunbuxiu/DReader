package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.Callback;
import android.view.View;
import com.duokan.reader.domain.document.as;

class jl extends View {
    /* renamed from: a */
    final /* synthetic */ FixedPageClipView f10439a;
    /* renamed from: b */
    private as f10440b;
    /* renamed from: c */
    private RectF f10441c;
    /* renamed from: d */
    private final Callback f10442d;

    public jl(FixedPageClipView fixedPageClipView, Context context) {
        this.f10439a = fixedPageClipView;
        super(context);
        this.f10440b = fixedPageClipView.f9092e.getDocument().m5898a(fixedPageClipView.f9092e.mo2009Z());
        this.f10442d = new jm(this, fixedPageClipView);
        this.f10440b.setCallback(this.f10442d);
        setWillNotDraw(false);
    }

    /* renamed from: a */
    public Drawable m14481a() {
        return this.f10440b;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF b = m14480b();
        this.f10440b.setBounds((int) b.left, (int) b.top, getWidth() - ((int) b.right), getHeight() - ((int) b.bottom));
        this.f10440b.m6120a(new Rect(-((int) b.left), -((int) b.top), getWidth(), getHeight()));
        this.f10440b.m6115a(getWidth());
        this.f10440b.m6129b(getHeight());
        this.f10440b.draw(canvas);
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.f10440b != null) {
            this.f10440b.mo1285H();
        }
    }

    /* renamed from: b */
    private RectF m14480b() {
        if (this.f10441c == null) {
            this.f10441c = new RectF();
            RectF rectF = this.f10439a.f9091d.m4623d()[0];
            this.f10441c.left = rectF.left * ((float) getWidth());
            this.f10441c.right = rectF.right * ((float) getWidth());
            this.f10441c.top = rectF.top * ((float) getHeight());
            this.f10441c.bottom = rectF.bottom * ((float) getHeight());
        }
        return this.f10441c;
    }
}
