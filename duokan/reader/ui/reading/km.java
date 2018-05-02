package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class km implements OnTouchListener {
    final /* synthetic */ kd a;

    km(kd kdVar) {
        this.a = kdVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() == 1) {
            this.a.h();
        }
        return true;
    }
}
