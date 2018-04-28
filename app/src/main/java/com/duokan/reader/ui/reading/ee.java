package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ee implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ dg f10069a;

    ee(dg dgVar) {
        this.f10069a = dgVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 0) {
            this.f10069a.f10003d.set(motionEvent.getX(), motionEvent.getY());
        }
        return false;
    }
}
