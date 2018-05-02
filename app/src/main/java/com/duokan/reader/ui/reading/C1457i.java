package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.ui.reading.i */
class C1457i implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ C1456h f10363a;

    C1457i(C1456h c1456h) {
        this.f10363a = c1456h;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f10363a.f10309a.f10217l = false;
        UThread.post(new C1459j(this));
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
