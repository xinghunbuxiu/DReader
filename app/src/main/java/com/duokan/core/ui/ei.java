package com.duokan.core.ui;

import android.view.animation.Transformation;

import com.duokan.core.sys.ap;

final class ei extends ap {
    ei() {
    }

    protected Object b() {
        return c();
    }

    protected  void b(Object obj) {
        a((Transformation) obj);
    }

    protected Transformation c() {
        return new Transformation();
    }

    protected void a(Transformation transformation) {
        transformation.clear();
    }
}
