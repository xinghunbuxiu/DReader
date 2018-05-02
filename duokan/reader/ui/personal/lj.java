package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;

class lj extends FrameLayout {
    final /* synthetic */ ko a;

    public lj(ko koVar, Context context) {
        this.a = koVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.a.e.getPullRefreshState() == RefreshState.REFRESHING) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
