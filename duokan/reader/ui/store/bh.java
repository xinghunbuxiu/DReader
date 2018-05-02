package com.duokan.reader.ui.store;

import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;

/* synthetic */ class bh {
    static final /* synthetic */ int[] a = new int[ChapterState.values().length];

    static {
        try {
            a[ChapterState.ORDER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[ChapterState.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[ChapterState.FREE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
