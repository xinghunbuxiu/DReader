package com.duokan.reader.ui.general.web;

import com.duokan.reader.domain.bookshelf.BookState;

/* synthetic */ class bw {
    static final /* synthetic */ int[] a = new int[TabState.values().length];
    static final /* synthetic */ int[] b = new int[BookState.values().length];

    static {
        try {
            b[BookState.UPDATING.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[BookState.PULLING.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[BookState.CLOUD_ONLY.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[BookState.NORMAL.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[TabState.OVER_SURFING_BAR_HEAD.ordinal()] = 1;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[TabState.OVER_HALF_SURFING_BAR.ordinal()] = 2;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[TabState.OVER_SURFING_BAR.ordinal()] = 3;
        } catch (NoSuchFieldError e7) {
        }
    }
}
