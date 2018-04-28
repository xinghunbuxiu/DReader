package com.duokan.reader.ui.bookshelf;

import com.duokan.common.FileTypeRecognizer.FileType;
import com.duokan.p024c.C0254f;

public class gu {
    /* renamed from: a */
    public static int m9742a(FileType fileType) {
        switch (gv.f6529a[fileType.ordinal()]) {
            case 1:
                return C0254f.general__shared__epub_icon;
            case 2:
                return C0254f.general__shared__txt_icon;
            case 3:
                return C0254f.general__shared__pdf_icon;
            default:
                return C0254f.general__shared__unsupported_book_icon;
        }
    }

    /* renamed from: b */
    public static int m9743b(FileType fileType) {
        switch (gv.f6529a[fileType.ordinal()]) {
            case 1:
                return C0254f.general__shared__cover_epub;
            case 2:
                return C0254f.general__shared__cover_txt;
            case 3:
                return C0254f.general__shared__cover_pdf;
            default:
                return C0254f.general__shared__unsupported_book_icon;
        }
    }
}
