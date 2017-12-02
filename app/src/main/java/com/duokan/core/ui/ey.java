package com.duokan.core.ui;

import com.duokan.core.ui.Scrollable.OverScrollMode;

/* synthetic */ class ey {
    static final /* synthetic */ int[] a = new int[OverScrollMode.values().length];

    static {
        try {
            a[OverScrollMode.ALWAYS.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[OverScrollMode.AUTO.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[OverScrollMode.STRETCH.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[OverScrollMode.NEVER.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
