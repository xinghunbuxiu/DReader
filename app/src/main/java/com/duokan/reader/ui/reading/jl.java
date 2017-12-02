package com.duokan.reader.ui.reading;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;

class jl implements OnPreDrawListener {
    final /* synthetic */ jg a;

    jl(jg jgVar) {
        this.a = jgVar;
    }

    public boolean onPreDraw() {
        Animation b = this.a.c.b(this.a.b, this.a.a);
        b.setDuration(200);
        this.a.startAnimation(b);
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
