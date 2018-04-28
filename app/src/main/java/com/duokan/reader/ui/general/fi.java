package com.duokan.reader.ui.general;

import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

class fi extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ fm f7225a;
    /* renamed from: b */
    final /* synthetic */ PagesController f7226b;

    fi(PagesController pagesController, Context context, fm fmVar) {
        this.f7226b = pagesController;
        this.f7225a = fmVar;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        this.f7226b.f6185c.m2044a((View) this, motionEvent);
        return this.f7225a.m1621d();
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return this.f7226b.f6185c.onTouch(this, motionEvent);
    }
}
