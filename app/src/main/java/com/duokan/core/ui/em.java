package com.duokan.core.ui;

import android.graphics.Rect;

import com.duokan.core.sys.ap;

final class em extends ap {
    em() {
    }

    protected  Object b() {
        return c();
    }

    protected  void b(Object obj) {
        a((Rect) obj);
    }

    protected Rect c() {
        return new Rect();
    }

    protected void a(Rect rect) {
        rect.setEmpty();
    }
}
