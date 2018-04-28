package com.duokan.reader.ui.reading;

import android.view.ViewTreeObserver.OnPreDrawListener;
import android.view.animation.Animation;

class jv implements OnPreDrawListener {
    /* renamed from: a */
    final /* synthetic */ jq f10474a;

    jv(jq jqVar) {
        this.f10474a = jqVar;
    }

    public boolean onPreDraw() {
        Animation b = this.f10474a.f10457c.m14489b(this.f10474a.f10456b, this.f10474a.f10455a);
        b.setDuration(200);
        this.f10474a.startAnimation(b);
        this.f10474a.getViewTreeObserver().removeOnPreDrawListener(this);
        return false;
    }
}
