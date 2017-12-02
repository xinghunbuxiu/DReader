package com.duokan.reader.ui.general.web;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.FrameLayout;

import com.duokan.core.ui.dv;

class ap extends FrameLayout {
    final /* synthetic */ SearchController a;

    public ap(SearchController searchController, Context context) {
        this.a = searchController;
        super(context);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        dv.a(getContext());
        return super.onInterceptTouchEvent(motionEvent);
    }
}
