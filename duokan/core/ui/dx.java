package com.duokan.core.ui;

import com.duokan.core.sys.ap;

import java.util.Arrays;

final class dx extends ap {
    dx() {
    }

    protected  Object b() {
        return c();
    }

    protected  void b(Object obj) {
        a((float[]) obj);
    }

    protected float[] c() {
        float[] fArr = new float[4];
        Arrays.fill(fArr, 0.0f);
        return fArr;
    }

    protected void a(float[] fArr) {
        Arrays.fill(fArr, 0.0f);
    }
}
