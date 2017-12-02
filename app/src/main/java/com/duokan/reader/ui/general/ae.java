package com.duokan.reader.ui.general;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;

class ae implements OnPreDrawListener {
    final /* synthetic */ ad a;

    ae(ad adVar) {
        this.a = adVar;
    }

    public boolean onPreDraw() {
        Animation a = this.a.b.a(this.a.j, this.a.m);
        a.setDuration((long) this.a.b.b);
        this.a.startAnimation(a);
        this.a.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
