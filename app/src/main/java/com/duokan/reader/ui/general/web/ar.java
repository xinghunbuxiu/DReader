package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.duokan.core.ui.dv;

class ar extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ SearchController f7594a;

    public ar(SearchController searchController, Context context) {
        this.f7594a = searchController;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dv.m1909a(getContext());
        return super.onInterceptTouchEvent(motionEvent);
    }
}
