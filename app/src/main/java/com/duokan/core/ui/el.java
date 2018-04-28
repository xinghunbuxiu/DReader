package com.duokan.core.ui;

import android.graphics.PointF;
import com.duokan.core.sys.BaseAnimation;

final class el extends BaseAnimation<PointF> {
    el() {
    }

    /* renamed from: b */
    protected /* synthetic */ Object createAnimation() {
        return m2012c();
    }

    /* renamed from: b */
    protected /* synthetic */ void mo516b(Object obj) {
        m2009a((PointF) obj);
    }

    /* renamed from: c */
    protected PointF m2012c() {
        return new PointF();
    }

    /* renamed from: a */
    protected void m2009a(PointF pointF) {
        pointF.y = 0.0f;
        pointF.x = 0.0f;
    }
}
