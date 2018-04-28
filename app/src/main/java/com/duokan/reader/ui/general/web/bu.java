package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.BookState;

/* synthetic */ class bu {
    /* renamed from: a */
    static final /* synthetic */ int[] f7648a = new int[TabState.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f7649b = new int[BookState.values().length];

    static {
        try {
            f7649b[BookState.UPDATING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7649b[BookState.PULLING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7649b[BookState.CLOUD_ONLY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7649b[BookState.NORMAL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f7648a[TabState.OVER_SURFING_BAR_HEAD.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f7648a[TabState.OVER_HALF_SURFING_BAR.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f7648a[TabState.OVER_SURFING_BAR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
