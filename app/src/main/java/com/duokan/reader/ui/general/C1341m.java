package com.duokan.reader.ui.general;

import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;

/* renamed from: com.duokan.reader.ui.general.m */
/* synthetic */ class C1341m {
    /* renamed from: a */
    static final /* synthetic */ int[] f7533a = new int[BookContent.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f7534b = new int[CoverSource.values().length];

    static {
        try {
            f7534b[CoverSource.COVER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f7534b[CoverSource.ONLINE_COVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f7534b[CoverSource.BOOK.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f7533a[BookContent.FRAME_COMIC.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f7533a[BookContent.PAGE_COMIC.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f7533a[BookContent.VERTICAL_COMIC.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f7533a[BookContent.AUDIO_TEXT.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
    }
}
