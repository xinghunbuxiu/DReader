package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class jo implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ jn f10453a;

    jo(jn jnVar) {
        this.f10453a = jnVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f10453a.post(new jp(this));
    }
}
