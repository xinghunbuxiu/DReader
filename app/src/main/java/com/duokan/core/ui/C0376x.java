package com.duokan.core.ui;

/* renamed from: com.duokan.core.ui.x */
public abstract class C0376x extends aw implements C0375w {
    /* renamed from: b */
    public final int[] m1404b(int i) {
        int i2;
        int a = mo486a();
        for (i2 = 0; i2 < a; i2++) {
            int a2 = mo487a(i2);
            if (i < a2) {
                break;
            }
            i -= a2;
        }
        return new int[]{i2, i};
    }

    /* renamed from: a */
    public final int m1403a(int i, int i2) {
        for (int i3 = 0; i3 <= i - 1; i3++) {
            i2 += mo487a(i3);
        }
        return i2;
    }
}
