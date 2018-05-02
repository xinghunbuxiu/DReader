package com.duokan.reader.domain.bookshelf;

/* renamed from: com.duokan.reader.domain.bookshelf.f */
/* synthetic */ class C0805f {
    /* renamed from: a */
    static final /* synthetic */ int[] f3150a = new int[BookContent.values().length];
    /* renamed from: b */
    static final /* synthetic */ int[] f3151b = new int[BookState.values().length];
    /* renamed from: c */
    static final /* synthetic */ int[] f3152c = new int[BookFormat.values().length];

    static {
        try {
            f3152c[BookFormat.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f3152c[BookFormat.PDF.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f3152c[BookFormat.TXT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f3151b[BookState.CLOUD_ONLY.ordinal()] = 1;
        } catch (NoSuchFieldError e4) {
        }
        try {
            f3151b[BookState.PULLING.ordinal()] = 2;
        } catch (NoSuchFieldError e5) {
        }
        try {
            f3151b[BookState.UPDATING.ordinal()] = 3;
        } catch (NoSuchFieldError e6) {
        }
        try {
            f3151b[BookState.NORMAL.ordinal()] = 4;
        } catch (NoSuchFieldError e7) {
        }
        try {
            f3150a[BookContent.FRAME_COMIC.ordinal()] = 1;
        } catch (NoSuchFieldError e8) {
        }
        try {
            f3150a[BookContent.PAGE_COMIC.ordinal()] = 2;
        } catch (NoSuchFieldError e9) {
        }
        try {
            f3150a[BookContent.VERTICAL_COMIC.ordinal()] = 3;
        } catch (NoSuchFieldError e10) {
        }
    }
}
