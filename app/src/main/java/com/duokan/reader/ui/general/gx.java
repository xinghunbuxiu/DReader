package com.duokan.reader.ui.general;

import android.graphics.Rect;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import com.duokan.core.ui.AnimUtils;

class gx implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ gs f7312a;
    /* renamed from: b */
    final /* synthetic */ int f7313b;
    /* renamed from: c */
    final /* synthetic */ gv f7314c;

    gx(gv gvVar, gs gsVar, int i) {
        this.f7314c = gvVar;
        this.f7312a = gsVar;
        this.f7313b = i;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            View b = this.f7314c.m10733b();
            Rect rect = (Rect) AnimUtils.f1198g.addAnimation();
            rect.set(b.getLeft(), b.getTop(), b.getRight(), b.getBottom());
            boolean z = !rect.contains((int) motionEvent.getX(), (int) motionEvent.getY());
            AnimUtils.f1198g.clearAnimation(rect);
            if (z && (this.f7313b & 1) == 1) {
                this.f7314c.requestDetach();
            }
        }
        if ((this.f7313b & 2) == 2) {
            return true;
        }
        return false;
    }
}
