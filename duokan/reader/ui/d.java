package com.duokan.reader.ui;

import com.duokan.reader.SystemUiMode;

/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[SystemUiMode.values().length];

    static {
        try {
            a[SystemUiMode.GONE.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[SystemUiMode.DOCK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[SystemUiMode.VISIBLE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
