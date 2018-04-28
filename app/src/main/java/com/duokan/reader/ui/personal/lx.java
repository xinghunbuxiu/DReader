package com.duokan.reader.ui.personal;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.duokan.core.ui.PullDownRefreshBaseView.RefreshState;

class lx extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ lc f8914a;

    public lx(lc lcVar, Context context) {
        this.f8914a = lcVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!isEnabled() || this.f8914a.f.getPullRefreshState() == RefreshState.REFRESHING) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }
}
