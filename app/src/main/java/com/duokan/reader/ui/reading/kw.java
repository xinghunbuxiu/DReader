package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class kw implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ kn f10532a;

    kw(kn knVar) {
        this.f10532a = knVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            this.f10532a.m14576h();
        }
        return true;
    }
}
