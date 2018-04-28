package com.duokan.reader.ui.store;

import com.duokan.reader.domain.cloud.DkCloudFictionChapter.ChapterState;

/* synthetic */ class bh {
    /* renamed from: a */
    static final /* synthetic */ int[] f11367a = new int[ChapterState.values().length];

    static {
        try {
            f11367a[ChapterState.ORDER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f11367a[ChapterState.NORMAL.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f11367a[ChapterState.FREE.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
