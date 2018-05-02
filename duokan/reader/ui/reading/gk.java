package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;

public class gk extends FrameLayout {
    private final gi a;
    private final gl b;

    public gk(Context context) {
        super(context);
        this.b = new gl(this, context);
        this.a = new gi(context);
        addView(this.b, new LayoutParams(-1, -1));
        addView(this.a, new LayoutParams(-1, -1));
        setClipChildren(false);
    }

    public void a(fu fuVar, View view, Rect rect) {
        this.a.e(fuVar);
        if (view != null && rect != null) {
            this.b.a(view, rect);
        }
    }

    public void a() {
        this.a.e();
        this.b.removeAllViews();
    }
}
