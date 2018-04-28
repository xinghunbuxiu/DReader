package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Canvas;
import android.widget.FrameLayout;

class ar extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ aq f9803a;

    ar(aq aqVar, Context context) {
        this.f9803a = aqVar;
        super(context);
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.f9803a.f9793l != null) {
            this.f9803a.m13753a(canvas);
        }
    }
}
