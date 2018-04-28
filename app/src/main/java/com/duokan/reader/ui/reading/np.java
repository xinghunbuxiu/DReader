package com.duokan.reader.ui.reading;

import android.view.animation.AlphaAnimation;
import android.view.animation.AnimationUtils;
import android.view.animation.Transformation;

class np implements Runnable {
    /* renamed from: a */
    final /* synthetic */ AlphaAnimation f10687a;
    /* renamed from: b */
    final /* synthetic */ int f10688b;
    /* renamed from: c */
    final /* synthetic */ int f10689c;
    /* renamed from: d */
    final /* synthetic */ int f10690d;
    /* renamed from: e */
    final /* synthetic */ int f10691e;
    /* renamed from: f */
    final /* synthetic */ nh f10692f;

    np(nh nhVar, AlphaAnimation alphaAnimation, int i, int i2, int i3, int i4) {
        this.f10692f = nhVar;
        this.f10687a = alphaAnimation;
        this.f10688b = i;
        this.f10689c = i2;
        this.f10690d = i3;
        this.f10691e = i4;
    }

    public void run() {
        long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
        Transformation transformation = new Transformation();
        this.f10687a.getTransformation(currentAnimationTimeMillis, transformation);
        float alpha = transformation.getAlpha();
        int i = (int) (((float) this.f10688b) + (((float) (this.f10689c - this.f10688b)) * alpha));
        int i2 = (int) ((alpha * ((float) (this.f10691e - this.f10690d))) + ((float) this.f10690d));
        this.f10692f.f10668b.getPagesFrameView().scrollTo(i, 0);
        this.f10692f.f10669c.scrollTo(i2, 0);
        this.f10692f.m14729a(this.f10692f.f10668b.getPagesFrameView().getScrollX());
        if (!this.f10687a.hasEnded()) {
            this.f10692f.f10669c.post(this);
        }
    }
}
