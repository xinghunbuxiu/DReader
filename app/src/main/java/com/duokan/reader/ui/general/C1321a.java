package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;
import android.widget.FrameLayout;

/* renamed from: com.duokan.reader.ui.general.a */
public class C1321a extends FrameLayout {
    /* renamed from: a */
    private float f6896a = 1.0f;
    /* renamed from: b */
    private boolean f6897b = true;
    /* renamed from: c */
    private AlphaAnimation f6898c;
    /* renamed from: d */
    private Transformation f6899d = new Transformation();

    public C1321a(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    /* renamed from: a */
    public void m10198a() {
        if (!this.f6897b) {
            this.f6897b = true;
            this.f6898c = new AlphaAnimation(this.f6896a, 1.0f);
            this.f6898c.setDuration((long) Math.round((1.0f - this.f6896a) * 200.0f));
            invalidate();
        }
    }

    /* renamed from: b */
    public void m10199b() {
        if (this.f6897b) {
            this.f6897b = false;
            this.f6898c = new AlphaAnimation(this.f6896a, 0.0f);
            this.f6898c.setDuration((long) Math.round(this.f6896a * 200.0f));
            invalidate();
        }
    }

    /* renamed from: c */
    public void m10200c() {
        this.f6896a = 0.0f;
        this.f6897b = false;
        this.f6898c = null;
        invalidate();
    }

    /* renamed from: d */
    public void m10201d() {
        this.f6896a = 1.0f;
        this.f6897b = true;
        this.f6898c = null;
        invalidate();
    }

    public float getAnimateRate() {
        return this.f6896a;
    }

    /* renamed from: e */
    public boolean m10202e() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        if (this.f6898c == null || this.f6898c.hasEnded()) {
            return false;
        }
        if (!this.f6898c.hasStarted()) {
            this.f6898c.setStartTime(currentAnimationTimeMillis);
        }
        this.f6898c.getTransformation(currentAnimationTimeMillis, this.f6899d);
        this.f6896a = this.f6899d.getAlpha();
        return true;
    }
}
