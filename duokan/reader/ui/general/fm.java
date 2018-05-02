package com.duokan.reader.ui.general;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class fm implements AnimationListener {
    final /* synthetic */ Runnable a;
    final /* synthetic */ Runnable b;
    final /* synthetic */ fk c;

    fm(fk fkVar, Runnable runnable, Runnable runnable2) {
        this.c = fkVar;
        this.a = runnable;
        this.b = runnable2;
    }

    public void onAnimationStart(Animation animation) {
        if (this.a != null) {
            this.a.run();
        }
    }

    public void onAnimationEnd(Animation animation) {
        if (this.b != null) {
            this.b.run();
        }
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
