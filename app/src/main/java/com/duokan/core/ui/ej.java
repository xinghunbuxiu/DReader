package com.duokan.core.ui;

import android.graphics.Matrix;
import com.duokan.core.sys.BaseAnimation;

final class ej extends BaseAnimation<Matrix> {
    ej() {
    }

    /* renamed from: b */
    protected /* synthetic */ Object createAnimation() {
        return m2004c();
    }

    /* renamed from: b */
    protected /* synthetic */ void mo516b(Object obj) {
        m2001a((Matrix) obj);
    }

    /* renamed from: c */
    protected Matrix m2004c() {
        return new Matrix();
    }

    /* renamed from: a */
    protected void m2001a(Matrix matrix) {
        matrix.reset();
    }
}
