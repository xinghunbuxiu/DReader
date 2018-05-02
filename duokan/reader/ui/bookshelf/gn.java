package com.duokan.reader.ui.bookshelf;

import com.duokan.c.f;
import com.duokan.common.FileTypeRecognizer.FileType;

public class gn {
    public static int a(FileType fileType) {
        switch (go.a[fileType.ordinal()]) {
            case 1:
                return f.general__shared__epub_icon;
            case 2:
                return f.general__shared__txt_icon;
            case 3:
                return f.general__shared__pdf_icon;
            default:
                return f.general__shared__unsupported_book_icon;
        }
    }

    public static int b(FileType fileType) {
        switch (go.a[fileType.ordinal()]) {
            case 1:
                return f.general__shared__cover_epub;
            case 2:
                return f.general__shared__cover_txt;
            case 3:
                return f.general__shared__cover_pdf;
            default:
                return f.general__shared__unsupported_book_icon;
        }
    }
}
