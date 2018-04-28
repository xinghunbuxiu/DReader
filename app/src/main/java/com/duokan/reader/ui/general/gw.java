package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.Point;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;
import com.duokan.reader.ReaderEnv;

class gw extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ gs f7309a;
    /* renamed from: b */
    final /* synthetic */ int f7310b;
    /* renamed from: c */
    final /* synthetic */ gv f7311c;

    gw(gv gvVar, Context context, gs gsVar, int i) {
        this.f7311c = gvVar;
        this.f7309a = gsVar;
        this.f7310b = i;
        super(context);
    }

    protected void measureChildWithMargins(View view, int i, int i2, int i3, int i4) {
        if (ReaderEnv.get().forHd() && this.f7310b == 17) {
            Point a = ReaderUi.m10155a(this.f7311c.getActivity());
            super.measureChildWithMargins(view, MeasureSpec.makeMeasureSpec(a.x, 1073741824), i2, MeasureSpec.makeMeasureSpec(a.y, 1073741824), i4);
            return;
        }
        super.measureChildWithMargins(view, i, i2, i3, i4);
    }
}
