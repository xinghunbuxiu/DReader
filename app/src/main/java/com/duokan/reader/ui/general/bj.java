package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;
import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.Scrollable.ScrollState;

class bj extends HatGridView {
    /* renamed from: a */
    final /* synthetic */ DkWebListView f6999a;

    bj(DkWebListView dkWebListView, Context context) {
        this.f6999a = dkWebListView;
        super(context);
    }

    /* renamed from: a */
    protected void mo1621a(PointF pointF) {
        this.f6999a.m9957a(pointF);
    }

    /* renamed from: a */
    protected void mo1750a(ScrollState scrollState, RectF rectF) {
        this.f6999a.m9959a(scrollState, rectF);
    }
}
