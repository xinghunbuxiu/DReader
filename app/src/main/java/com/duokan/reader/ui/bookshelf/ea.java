package com.duokan.reader.ui.bookshelf;

import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

class ea implements OnTouchListener {
    final /* synthetic */ du a;

    ea(du duVar) {
        this.a = duVar;
    }

    public boolean onTouch(View view, MotionEvent motionEvent) {
        if (motionEvent.getActionMasked() != 0) {
            return false;
        }
        if (this.a.g.hasFocus()) {
            view.requestFocus();
        } else {
            this.a.e.a(null);
        }
        return true;
    }
}
