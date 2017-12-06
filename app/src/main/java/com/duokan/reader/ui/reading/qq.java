package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;

import com.duokan.core.ui.er;
import com.duokan.core.ui.OnTouchChangeListener;

class qq extends er {
    final /* synthetic */ qh a;

    qq(qh qhVar) {
        this.a = qhVar;
    }

    protected void a(View view, boolean z) {
    }

    protected void a(View view, MotionEvent motionEvent, boolean z, OnTouchChangeListener esVar) {
        if (motionEvent.getActionMasked() == 0 && motionEvent.getY() < ((float) a(view, 20))) {
            c(true);
            d(true);
        }
    }
}
