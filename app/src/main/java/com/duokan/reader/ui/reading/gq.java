package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;

class gq extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ gp f10263a;

    public gq(gp gpVar, Context context) {
        this.f10263a = gpVar;
        super(context);
    }

    /* renamed from: a */
    public void m14265a(View view, Rect rect) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        addView(view, layoutParams);
    }
}
