package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.duokan.core.ui.dv;

class hj extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ View f8653a;
    /* renamed from: b */
    final /* synthetic */ Rect f8654b;
    /* renamed from: c */
    final /* synthetic */ ImageView f8655c;
    /* renamed from: d */
    final /* synthetic */ ImageView f8656d;
    /* renamed from: e */
    final /* synthetic */ fz f8657e;

    hj(fz fzVar, Context context, View view, Rect rect, ImageView imageView, ImageView imageView2) {
        this.f8657e = fzVar;
        this.f8653a = view;
        this.f8654b = rect;
        this.f8655c = imageView;
        this.f8656d = imageView2;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.f8653a.layout(i, this.f8654b.top, i3, this.f8654b.bottom);
        int b = dv.m1932b(getContext(), 78.0f);
        int b2 = dv.m1932b(getContext(), 5.0f);
        this.f8655c.layout(i + b, (this.f8653a.getTop() - this.f8655c.getMeasuredHeight()) - b2, b + this.f8655c.getMeasuredWidth(), this.f8653a.getTop() - b2);
        this.f8656d.layout(this.f8655c.getRight() + b2, (this.f8655c.getTop() - this.f8656d.getMeasuredHeight()) - b2, (this.f8655c.getRight() + this.f8656d.getMeasuredWidth()) + b2, this.f8655c.getTop() - b2);
    }
}
