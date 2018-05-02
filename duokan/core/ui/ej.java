package com.duokan.core.ui;

import android.graphics.Matrix;

import com.duokan.core.sys.ap;

final class ej extends ap {
    ej() {
    }

    protected Object b() {
        return c();
    }

    protected void b(Object obj) {
        a((Matrix) obj);
    }

    protected Matrix c() {
        return new Matrix();
    }

    protected void a(Matrix matrix) {
        matrix.reset();
    }
}
