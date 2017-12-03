package com.duokan.reader.ui.reading;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

import com.duokan.core.sys.TaskHandler;

class ne implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ mx b;

    ne(mx mxVar, Runnable runnable) {
        this.b = mxVar;
        this.a = runnable;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        TaskHandler.PostTask(this.a);
    }
}
