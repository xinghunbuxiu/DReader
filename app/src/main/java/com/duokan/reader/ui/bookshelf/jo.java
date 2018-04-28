package com.duokan.reader.ui.bookshelf;

import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;

class jo implements AnimationListener {
    /* renamed from: a */
    final /* synthetic */ jj f6674a;

    jo(jj jjVar) {
        this.f6674a = jjVar;
    }

    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        this.f6674a.requestDetach();
    }

    public void onAnimationRepeat(Animation animation) {
    }
}
