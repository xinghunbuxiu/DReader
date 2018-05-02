package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class ar extends FrameLayout {
    final /* synthetic */ aq a;

    ar(aq aqVar, Context context) {
        this.a = aqVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.a.l != null) {
            this.a.a(canvas);
        }
    }
}
