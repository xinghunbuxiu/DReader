package com.duokan.reader.ui.reading;

import android.graphics.drawable.ColorDrawable;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class rc implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ qr f10885a;

    rc(qr qrVar) {
        this.f10885a = qrVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f10885a.f9281e.getPagesFrameView().setForeground(new ColorDrawable(-16777216));
    }
}
