package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class i implements AnimationListener {
    final /* synthetic */ h a;

    i(h hVar) {
        this.a = hVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.a.a.l = false;
        t.b(new j(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
