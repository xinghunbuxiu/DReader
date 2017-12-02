package com.duokan.reader.ui.personal;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.duokan.core.ui.dv;

class gw extends FrameLayout {
    final /* synthetic */ View a;
    final /* synthetic */ Rect b;
    final /* synthetic */ ImageView c;
    final /* synthetic */ ImageView d;
    final /* synthetic */ fl e;

    gw(fl flVar, Context context, View view, Rect rect, ImageView imageView, ImageView imageView2) {
        this.e = flVar;
        this.a = view;
        this.b = rect;
        this.c = imageView;
        this.d = imageView2;
        super(context);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.a.layout(i, this.b.top, i3, this.b.bottom);
        int b = dv.b(getContext(), 78.0f);
        int b2 = dv.b(getContext(), 5.0f);
        this.c.layout(i + b, (this.a.getTop() - this.c.getMeasuredHeight()) - b2, b + this.c.getMeasuredWidth(), this.a.getTop() - b2);
        this.d.layout(this.c.getRight() + b2, (this.c.getTop() - this.d.getMeasuredHeight()) - b2, (this.c.getRight() + this.d.getMeasuredWidth()) + b2, this.c.getTop() - b2);
    }
}
