package com.duokan.reader.ui;

import android.content.Context;
import android.widget.FrameLayout;
import com.duokan.reader.ui.general.ReaderUi;

/* renamed from: com.duokan.reader.ui.m */
class C1388m extends FrameLayout {
    /* renamed from: a */
    final /* synthetic */ C1384i f8194a;
    /* renamed from: b */
    final /* synthetic */ C1387l f8195b;

    C1388m(C1387l c1387l, Context context, C1384i c1384i) {
        this.f8195b = c1387l;
        this.f8194a = c1384i;
        super(context);
    }

    protected void onMeasure(int i, int i2) {
        int a = ReaderUi.m10154a(getContext(), getResources().getDisplayMetrics().widthPixels, this.f8195b.f8193d);
        if (getPaddingLeft() != a) {
            setPadding(a, 0, 0, 0);
        }
        super.onMeasure(i, i2);
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i != i3 && this.f8195b.f8191a.m9244k() == this.f8195b) {
            this.f8195b.f8191a.m11319h(this.f8195b.m10670b());
        }
    }
}
