package com.duokan.reader.ui.reading;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class bf implements OnTouchListener {
    final /* synthetic */ bd a;

    bf(bd bdVar) {
        this.a = bdVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        this.a.a.a();
        return true;
    }
}
