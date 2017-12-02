package com.duokan.reader.ui;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

import com.duokan.reader.ui.general.fy;

class n implements OnTouchListener {
    final /* synthetic */ i a;
    final /* synthetic */ l b;

    n(l lVar, i iVar) {
        this.b = lVar;
        this.a = iVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            for (int i = this.b.a.i() - 1; i >= 0; i--) {
                fy a = this.b.a.f(i);
                if (Float.compare(((l) a).a(), this.b.d) != 0) {
                    this.b.a.d(a.b(), null);
                    break;
                }
            }
            this.b.a.b(null);
        }
        return true;
    }
}
