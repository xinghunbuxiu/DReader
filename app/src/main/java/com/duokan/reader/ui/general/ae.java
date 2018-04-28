package com.duokan.reader.ui.general;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;

class ae implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ ad f6928a;

    ae(ad adVar) {
        this.f6928a = adVar;
    }

    public boolean onPreDraw() {
        Animation a = this.f6928a.f6916b.m9923a(this.f6928a.f6924j, this.f6928a.f6927m);
        a.setDuration((long) this.f6928a.f6916b.f6769b);
        this.f6928a.startAnimation(a);
        this.f6928a.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
