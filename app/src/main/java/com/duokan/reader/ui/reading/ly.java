package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class ly extends View {
    /* renamed from: a */
    final /* synthetic */ ll f10600a;
    /* renamed from: b */
    private float f10601b = 1.0f;
    /* renamed from: c */
    private boolean f10602c = true;
    /* renamed from: d */
    private ValueAnimator f10603d = null;

    public ly(ll llVar, Context context) {
        this.f10600a = llVar;
        super(context);
        setWillNotDraw(false);
    }

    /* renamed from: a */
    public boolean m14627a() {
        return this.f10602c;
    }

    /* renamed from: b */
    public void m14628b() {
        this.f10601b = 0.0f;
        this.f10602c = false;
        this.f10600a.f10250b.mo2126c(1.0f - this.f10601b);
        m14626e();
        invalidate();
    }

    /* renamed from: c */
    public void m14629c() {
        if (!this.f10602c) {
            this.f10602c = true;
            m14626e();
            this.f10603d = ValueAnimator.ofFloat(new float[]{this.f10601b, 1.0f});
            this.f10603d.setDuration((long) Math.round((1.0f - this.f10601b) * 500.0f));
            this.f10603d.addUpdateListener(new lz(this));
            this.f10603d.start();
        }
    }

    /* renamed from: d */
    public void m14630d() {
        if (this.f10602c) {
            this.f10602c = false;
            m14626e();
            this.f10603d = ValueAnimator.ofFloat(new float[]{this.f10601b, 0.0f});
            this.f10603d.setDuration((long) Math.round(this.f10601b * 500.0f));
            this.f10603d.addUpdateListener(new ma(this));
            this.f10603d.start();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawARGB(Math.round(this.f10601b * 255.0f), 0, 0, 0);
    }

    /* renamed from: e */
    private void m14626e() {
        if (this.f10603d != null) {
            this.f10603d.cancel();
            this.f10603d = null;
        }
    }
}
