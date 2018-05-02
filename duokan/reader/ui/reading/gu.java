package com.duokan.reader.ui.reading;

import android.content.Context;
import android.view.MotionEvent;

import com.duokan.core.ui.ZoomView;

class gu extends ZoomView {
    final /* synthetic */ gs b;

    gu(gs gsVar, Context context) {
        this.b = gsVar;
        super(context);
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return false;
    }
}
