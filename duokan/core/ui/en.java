package com.duokan.core.ui;

import android.graphics.RectF;

import com.duokan.core.sys.ap;

final class en extends ap {
    en() {
    }

    protected Object b() {
        return c();
    }

    protected  void b(Object obj) {
        a((RectF) obj);
    }

    protected RectF c() {
        return new RectF();
    }

    protected void a(RectF rectF) {
        rectF.setEmpty();
    }
}
