package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.t;

class jt implements AnimationListener {
    final /* synthetic */ jq a;

    jt(jq jqVar) {
        this.a = jqVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        t.b(this.a.f);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
