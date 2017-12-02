package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.RectF;

import com.duokan.core.ui.HatGridView;
import com.duokan.core.ui.Scrollable.ScrollState;

class bj extends HatGridView {
    final /* synthetic */ DkWebListView a;

    bj(DkWebListView dkWebListView, Context context) {
        this.a = dkWebListView;
        super(context);
    }

    protected void a(PointF pointF) {
        this.a.a(pointF);
    }

    protected void a(ScrollState scrollState, RectF rectF) {
        this.a.a(scrollState, rectF);
    }
}
