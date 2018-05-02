package com.duokan.reader.ui.bookshelf;

import com.duokan.common.FileTypeRecognizer.FileType;

/* synthetic */ class go {
    static final /* synthetic */ int[] a = new int[FileType.values().length];

    static {
        try {
            a[FileType.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            a[FileType.TXT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            a[FileType.PDF.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
