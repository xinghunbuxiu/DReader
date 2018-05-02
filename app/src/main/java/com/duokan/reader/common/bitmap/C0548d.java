package com.duokan.reader.common.bitmap;

import android.graphics.Bitmap.Config;

/* renamed from: com.duokan.reader.common.bitmap.d */
/* synthetic */ class C0548d {
    /* renamed from: a */
    static final /* synthetic */ int[] f1817a = new int[Config.values().length];

    static {
        try {
            f1817a[Config.ALPHA_8.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f1817a[Config.ARGB_4444.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f1817a[Config.RGB_565.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f1817a[Config.ARGB_8888.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
