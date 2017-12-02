package com.duokan.reader.ui.general.web;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.duokan.core.ui.dv;

class by implements Runnable {
    final /* synthetic */ StorePageController a;

    by(StorePageController storePageController) {
        this.a = storePageController;
    }

    public void run() {
        if (!this.a.mTransparent) {
            this.a.mPageLoadingDlg.dismiss();
            if (this.a.mPageLoadingView.getAnimation() != null && this.a.mPageLoadingView.getAnimation().hasStarted() && !this.a.mPageLoadingView.getAnimation().hasEnded()) {
                return;
            }
            if (this.a.webPageLoading() && this.a.mPageLoadingView.getVisibility() != 0) {
                this.a.mPageLoadingView.setVisibility(0);
                dv.b(this.a.mPageLoadingView, (Runnable) this);
            } else if (!this.a.webPageLoading() && this.a.mPageLoadingView.getVisibility() != 4) {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillBefore(true);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500);
                alphaAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 300);
                this.a.mPageLoadingView.startAnimation(alphaAnimation);
                alphaAnimation.setAnimationListener(new bz(this, alphaAnimation, this));
            }
        }
    }
}
