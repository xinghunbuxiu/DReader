package com.duokan.reader.domain.bookshelf;

/* renamed from: com.duokan.reader.domain.bookshelf.b */
/* synthetic */ class C0799b {
    /* renamed from: a */
    static final /* synthetic */ int[] f2800a = new int[BookFormat.values().length];

    static {
        try {
            f2800a[BookFormat.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f2800a[BookFormat.SBK.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f2800a[BookFormat.TXT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            f2800a[BookFormat.PDF.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
    }
}
