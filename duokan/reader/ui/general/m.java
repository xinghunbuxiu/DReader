package com.duokan.reader.ui.general;

import com.duokan.reader.domain.bookshelf.BookContent;
import com.duokan.reader.ui.general.BookCoverView.CoverSource;

/* synthetic */ class m {
    static final /* synthetic */ int[] a = new int[BookContent.values().length];
    static final /* synthetic */ int[] b = new int[CoverSource.values().length];

    static {
        try {
            b[CoverSource.COVER.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            b[CoverSource.ONLINE_COVER.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            b[CoverSource.BOOK.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[BookContent.FRAME_COMIC.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[BookContent.PAGE_COMIC.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            a[BookContent.VERTICAL_COMIC.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            a[BookContent.AUDIO_TEXT.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
    }
}
