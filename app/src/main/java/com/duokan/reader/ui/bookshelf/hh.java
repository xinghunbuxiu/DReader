package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

class hh extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ he f6547a;

    public hh(he heVar, Context context) {
        this.f6547a = heVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.f6547a.mo1721e()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }
}
