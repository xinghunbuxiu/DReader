package com.duokan.reader.domain.bookshelf;

/* synthetic */ class f {
    static final /* synthetic */ int[] a = new int[BookContent.values().length];
    static final /* synthetic */ int[] b = new int[BookState.values().length];
    static final /* synthetic */ int[] c = new int[BookFormat.values().length];

    static {
        try {
            c[BookFormat.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            c[BookFormat.PDF.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            c[BookFormat.TXT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            b[BookState.CLOUD_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            b[BookState.PULLING.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            b[BookState.UPDATING.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            b[BookState.NORMAL.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            a[BookContent.FRAME_COMIC.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            a[BookContent.PAGE_COMIC.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            a[BookContent.VERTICAL_COMIC.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
    }
}
