package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class fo extends FrameLayout {
    final /* synthetic */ fs a;
    final /* synthetic */ PagesController b;

    fo(PagesController pagesController, Context context, fs fsVar) {
        this.b = pagesController;
        this.a = fsVar;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.b.c.a((View) this, motionEvent);
        return this.a.d();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.b.c.onTouch(this, motionEvent);
    }
}
