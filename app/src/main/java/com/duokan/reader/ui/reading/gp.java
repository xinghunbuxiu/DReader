package com.duokan.reader.ui.reading;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;

public class gp extends FrameLayout {
    /* renamed from: a */
    private final gn f10261a;
    /* renamed from: b */
    private final gq f10262b;

    public gp(Context context) {
        super(context);
        this.f10262b = new gq(this, context);
        this.f10261a = new gn(context);
        addView(this.f10262b, new LayoutParams(-1, -1));
        addView(this.f10261a, new LayoutParams(-1, -1));
        setClipChildren(false);
    }

    /* renamed from: a */
    public void m14264a(fz fzVar, View view, Rect rect) {
        this.f10261a.m14249e(fzVar);
        if (view != null && rect != null) {
            this.f10262b.m14265a(view, rect);
        }
    }

    /* renamed from: a */
    public void m14263a() {
        this.f10261a.m14248e();
        this.f10262b.removeAllViews();
    }
}
