package com.duokan.reader.ui.reading;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.view.View;

class lo extends View {
    final /* synthetic */ lb a;
    private float b = 1.0f;
    private boolean c = true;
    private ValueAnimator d = null;

    public lo(lb lbVar, Context context) {
        this.a = lbVar;
        super(context);
        setWillNotDraw(false);
    }

    public boolean a() {
        return this.c;
    }

    public void b() {
        this.b = 0.0f;
        this.c = false;
        this.a.b.c(1.0f - this.b);
        e();
        invalidate();
    }

    public void c() {
        if (!this.c) {
            this.c = true;
            e();
            this.d = ValueAnimator.ofFloat(new float[]{this.b, 1.0f});
            this.d.setDuration((long) Math.round((1.0f - this.b) * 500.0f));
            this.d.addUpdateListener(new lp(this));
            this.d.start();
        }
    }

    public void d() {
        if (this.c) {
            this.c = false;
            e();
            this.d = ValueAnimator.ofFloat(new float[]{this.b, 0.0f});
            this.d.setDuration((long) Math.round(this.b * 500.0f));
            this.d.addUpdateListener(new lq(this));
            this.d.start();
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawARGB(Math.round(this.b * 255.0f), 0, 0, 0);
    }

    private void e() {
        if (this.d != null) {
            this.d.cancel();
            this.d = null;
        }
    }
}
