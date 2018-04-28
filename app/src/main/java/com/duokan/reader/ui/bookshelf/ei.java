package com.duokan.reader.ui.bookshelf;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ei implements OnTouchListener {
    /* renamed from: a */
    final /* synthetic */ ec f6383a;

    ei(ec ecVar) {
        this.f6383a = ecVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.f6383a.f6375g.hasFocus()) {
            view.requestFocus();
        } else {
            this.f6383a.f6373e.mo1647a(null);
        }
        return true;
    }
}
