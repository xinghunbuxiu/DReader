package com.duokan.reader.ui.welcome;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class l implements OnTouchListener {
    final /* synthetic */ j a;

    l(j jVar) {
        this.a = jVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        this.a.e.a(false);
        return false;
    }
}
