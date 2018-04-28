package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

class fl implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f7238a;
    /* renamed from: b */
    final /* synthetic */ PagesController f7239b;

    fl(PagesController pagesController, Runnable runnable) {
        this.f7239b = pagesController;
        this.f7238a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.post(this.f7238a);
    }
}
