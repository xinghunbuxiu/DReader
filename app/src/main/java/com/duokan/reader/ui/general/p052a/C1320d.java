package com.duokan.reader.ui.general.p052a;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import com.duokan.core.sys.UThread;

/* renamed from: com.duokan.reader.ui.general.a.d */
final class C1320d implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ Runnable f6895a;

    C1320d(Runnable runnable) {
        this.f6895a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        UThread.runOnThread(this.f6895a);
    }
}
