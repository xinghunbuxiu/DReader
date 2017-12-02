package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

public class a extends FrameLayout {
    private float a = 1.0f;
    private boolean b = true;
    private AlphaAnimation c;
    private Transformation d = new Transformation();

    public a(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    public void a() {
        if (!this.b) {
            this.b = true;
            this.c = new AlphaAnimation(this.a, 1.0f);
            this.c.setDuration((long) Math.round((1.0f - this.a) * 200.0f));
            invalidate();
        }
    }

    public void b() {
        if (this.b) {
            this.b = false;
            this.c = new AlphaAnimation(this.a, 0.0f);
            this.c.setDuration((long) Math.round(this.a * 200.0f));
            invalidate();
        }
    }

    public void c() {
        this.a = 0.0f;
        this.b = false;
        this.c = null;
        invalidate();
    }

    public void d() {
        this.a = 1.0f;
        this.b = true;
        this.c = null;
        invalidate();
    }

    public float getAnimateRate() {
        return this.a;
    }

    public boolean e() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.c == null || this.c.hasEnded()) {
            return false;
        }
        if (!this.c.hasStarted()) {
            this.c.setStartTime(currentAnimationTimeMillis);
        }
        this.c.getTransformation(currentAnimationTimeMillis, this.d);
        this.a = this.d.getAlpha();
        return true;
    }
}
