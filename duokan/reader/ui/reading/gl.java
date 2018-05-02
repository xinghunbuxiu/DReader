package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

class gl extends FrameLayout {
    final /* synthetic */ gk a;

    public gl(gk gkVar, Context context) {
        this.a = gkVar;
        super(context);
    }

    public void a(View view, Rect rect) {
        LayoutParams layoutParams = new FrameLayout.LayoutParams(rect.width(), rect.height());
        layoutParams.leftMargin = rect.left;
        layoutParams.topMargin = rect.top;
        addView(view, layoutParams);
    }
}
