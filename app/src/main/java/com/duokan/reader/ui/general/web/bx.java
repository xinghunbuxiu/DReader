package com.duokan.reader.ui.general.web;

import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import com.duokan.core.ui.dv;

class bx implements Runnable {
    /* renamed from: a */
    final /* synthetic */ StorePageController f7652a;

    bx(StorePageController storePageController) {
        this.f7652a = storePageController;
    }

    public void run() {
        if (!this.f7652a.mTransparent) {
            this.f7652a.mPageLoadingDlg.dismiss();
            if (this.f7652a.mPageLoadingView.getAnimation() != null && this.f7652a.mPageLoadingView.getAnimation().hasStarted() && !this.f7652a.mPageLoadingView.getAnimation().hasEnded()) {
                return;
            }
            if (this.f7652a.webPageLoading() && this.f7652a.mPageLoadingView.getVisibility() != 0) {
                this.f7652a.mPageLoadingView.setVisibility(0);
                dv.showAnimation(this.f7652a.mPageLoadingView, (Runnable) this);
            } else if (!this.f7652a.webPageLoading() && this.f7652a.mPageLoadingView.getVisibility() != 4) {
                Animation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
                alphaAnimation.setFillEnabled(true);
                alphaAnimation.setFillBefore(true);
                alphaAnimation.setFillAfter(true);
                alphaAnimation.setDuration(500);
                alphaAnimation.setStartTime(AnimationUtils.currentAnimationTimeMillis() + 300);
                this.f7652a.mPageLoadingView.startAnimation(alphaAnimation);
                alphaAnimation.setAnimationListener(new by(this, alphaAnimation, this));
            }
        }
    }
}
