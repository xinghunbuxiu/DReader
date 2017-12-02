package com.duokan.core.ui;

import android.graphics.Point;

import com.duokan.core.sys.ap;

final class ek extends ap {
    ek() {
    }

    protected /* synthetic */ Object b() {
        return c();
    }

    protected /* synthetic */ void b(Object obj) {
        a((Point) obj);
    }

    protected Point c() {
        return new Point();
    }

    protected void a(Point point) {
        point.y = 0;
        point.x = 0;
    }
}
