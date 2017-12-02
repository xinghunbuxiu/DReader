package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap.Config;

/* synthetic */ class d {
    static final /* synthetic */ int[] a = new int[Config.values().length];

    static {
        try {
            a[Config.ALPHA_8.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[Config.ARGB_4444.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[Config.RGB_565.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[Config.ARGB_8888.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
