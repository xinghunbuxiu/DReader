package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class je implements AnimationListener {
    final /* synthetic */ jd a;

    je(jd jdVar) {
        this.a = jdVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.post(new jf(this));
    }
}
