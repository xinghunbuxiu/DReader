package com.duokan.reader;

import android.content.Context;

import com.duokan.c.j;
import com.duokan.core.app.y;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.document.a;
import com.duokan.reader.ui.reading.aev;
import com.duokan.reader.ui.reading.hb;
import com.duokan.reader.ui.reading.ok;
import com.duokan.reader.ui.reading.qh;
import com.duokan.reader.ui.reading.xm;

import java.io.File;

public class BookOpener {
    private final y a;

    interface ErrorHandler {
        void onError(String str);
    }

    private BookOpener(y yVar) {
        this.a = yVar;
    }

    public static BookOpener with(y yVar) {
        return new BookOpener(yVar);
    }

    public qh open(c cVar, a aVar, ErrorHandler errorHandler) {
        Context context = (Context) this.a;
        if (ReaderEnv.get().isExternalStorageMounted()) {
            if (cVar.s() == BookPackageType.EPUB_OPF || cVar.o() == BookType.SERIAL || cVar.R()) {
                File d = cVar.d();
                if (cVar.s() == BookPackageType.EPUB_OPF || cVar.o() == BookType.SERIAL || d.length() != 0) {
                    qh hbVar;
                    switch (cVar.q()) {
                        case EPUB:
                            hbVar = new hb(this.a, cVar, aVar);
                            break;
                        case TXT:
                            hbVar = new aev(this.a, cVar, aVar);
                            break;
                        case PDF:
                            hbVar = new ok(this.a, cVar, aVar);
                            break;
                        case SBK:
                            hbVar = new xm(this.a, cVar, aVar);
                            break;
                        default:
                            hbVar = null;
                            break;
                    }
                    if (hbVar != null) {
                        return hbVar;
                    }
                    if (errorHandler == null) {
                        return null;
                    }
                    errorHandler.onError(context.getString(j.general__shared__unkown_book_format));
                    return null;
                } else if (errorHandler == null) {
                    return null;
                } else {
                    errorHandler.onError(context.getString(j.empty_books));
                    return null;
                }
            } else if (errorHandler == null) {
                return null;
            } else {
                errorHandler.onError(context.getString(j.general__shared__invaild_book));
                return null;
            }
        } else if (errorHandler == null) {
            return null;
        } else {
            errorHandler.onError(context.getString(j.general__shared__sd_card_unmounted));
            return null;
        }
    }
}
