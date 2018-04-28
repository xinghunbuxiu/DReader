package com.duokan.reader.ui.bookshelf;

import com.duokan.common.FileTypeRecognizer.FileType;

/* synthetic */ class gv {
    /* renamed from: a */
    static final /* synthetic */ int[] f6529a = new int[FileType.values().length];

    static {
        try {
            f6529a[FileType.EPUB.ordinal()] = 1;
        } catch (NoSuchFieldError e) {
        }
        try {
            f6529a[FileType.TXT.ordinal()] = 2;
        } catch (NoSuchFieldError e2) {
        }
        try {
            f6529a[FileType.PDF.ordinal()] = 3;
        } catch (NoSuchFieldError e3) {
        }
    }
}
