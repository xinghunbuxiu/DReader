package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class jd implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ ja f7430a;

    jd(ja jaVar) {
        this.f7430a = jaVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(this.f7430a.f7427f);
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
