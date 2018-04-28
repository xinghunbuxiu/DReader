package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class jt implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f10468a;
    /* renamed from: b */
    final /* synthetic */ jq f10469b;

    jt(jq jqVar, Runnable runnable) {
        this.f10469b = jqVar;
        this.f10468a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(this.f10468a);
    }
}
