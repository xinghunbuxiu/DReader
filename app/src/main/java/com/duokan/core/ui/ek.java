package com.duokan.core.ui;

import android.graphics.Point;
import com.duokan.core.sys.BaseAnimation;

final class ek extends BaseAnimation<Point> {
    ek() {
    }

    /* renamed from: b */
    protected /* synthetic */ Object createAnimation() {
        return m2008c();
    }

    /* renamed from: b */
    protected /* synthetic */ void mo516b(Object obj) {
        m2005a((Point) obj);
    }

    /* renamed from: c */
    protected Point m2008c() {
        return new Point();
    }

    /* renamed from: a */
    protected void m2005a(Point point) {
        point.y = 0;
        point.x = 0;
    }
}
