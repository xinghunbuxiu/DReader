package com.duokan.core.ui;

public abstract class x extends aw implements w {
    public final int[] b(int i) {
        int i2;
        int a = a();
        for (i2 = 0; i2 < a; i2++) {
            int a2 = a(i2);
            if (i < a2) {
                break;
            }
            i -= a2;
        }
        return new int[]{i2, i};
    }

    public final int a(int i, int i2) {
        for (int i3 = 0; i3 <= i - 1; i3++) {
            i2 += a(i3);
        }
        return i2;
    }
}
