package com.duokan.reader.ui.bookshelf;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

class ha extends FrameLayout {
    final /* synthetic */ gx a;

    public ha(gx gxVar, Context context) {
        this.a = gxVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.a.c()) {
            return super.dispatchTouchEvent(motionEvent);
        }
        return true;
    }
}
