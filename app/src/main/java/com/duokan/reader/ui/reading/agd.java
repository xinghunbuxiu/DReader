package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class agd implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ agc f9717a;

    agd(agc agc) {
        this.f9717a = agc;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.f9717a.dismiss();
        return true;
    }
}
