package com.duokan.core.ui;

import com.duokan.core.sys.ap;

import java.util.Arrays;

final class dz extends ap {
    dz() {
    }

    protected Object b() {
        return c();
    }

    protected void b(Object obj) {
        a((int[]) obj);
    }

    protected int[] c() {
        int[] iArr = new int[2];
        Arrays.fill(iArr, 0);
        return iArr;
    }

    protected void a(int[] iArr) {
        Arrays.fill(iArr, 0);
    }
}
