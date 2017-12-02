package com.duokan.reader.domain.bookshelf;

/* synthetic */ class ib {
    static final /* synthetic */ int[] a = new int[BookFormat.values().length];

    static {
        try {
            a[BookFormat.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[BookFormat.PDF.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[BookFormat.TXT.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
        try {
            a[BookFormat.UNKNOWN.ordinal()] = 4;
        } catch (NoSuchFieldError e4) {
        }
        try {
            a[BookFormat.SBK.ordinal()] = 5;
        } catch (NoSuchFieldError e5) {
        }
    }
}
