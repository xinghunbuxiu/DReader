package com.duokan.reader;

import android.content.Context;
import com.duokan.core.app.IFeature;
import com.duokan.p024c.C0258j;
import com.duokan.reader.domain.bookshelf.BookPackageType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.ui.reading.afv;
import com.duokan.reader.ui.reading.hl;
import com.duokan.reader.ui.reading.ou;
import com.duokan.reader.ui.reading.qr;
import com.duokan.reader.ui.reading.xz;
import java.io.File;

public class BookOpener {
    /* renamed from: a */
    private final IFeature f1361a;

    interface ErrorHandler {
        void onError(String str);
    }

    private BookOpener(IFeature mFeature) {
        this.f1361a = mFeature;
    }

    public static BookOpener with(IFeature mFeature) {
        return new BookOpener(mFeature);
    }

    public qr open(C0800c c0800c, C0896a c0896a, ErrorHandler errorHandler) {
        Context context = (Context) this.f1361a;
        if (ReaderEnv.get().isExternalStorageMounted()) {
            if (c0800c.m4247s() == BookPackageType.EPUB_OPF || c0800c.m4242o() == BookType.SERIAL || c0800c.m4167T()) {
                File d = c0800c.m4219d();
                if (c0800c.m4247s() == BookPackageType.EPUB_OPF || c0800c.m4242o() == BookType.SERIAL || d.length() != 0) {
                    qr hlVar;
                    switch (c0800c.mo1039q()) {
                        case EPUB:
                            hlVar = new hl(this.f1361a, c0800c, c0896a);
                            break;
                        case TXT:
                            hlVar = new afv(this.f1361a, c0800c, c0896a);
                            break;
                        case PDF:
                            hlVar = new ou(this.f1361a, c0800c, c0896a);
                            break;
                        case SBK:
                            hlVar = new xz(this.f1361a, c0800c, c0896a);
                            break;
                        default:
                            hlVar = null;
                            break;
                    }
                    if (hlVar != null) {
                        return hlVar;
                    }
                    if (errorHandler == null) {
                        return null;
                    }
                    errorHandler.onError(context.getString(C0258j.general__shared__unkown_book_format));
                    return null;
                } else if (errorHandler == null) {
                    return null;
                } else {
                    errorHandler.onError(context.getString(C0258j.empty_books));
                    return null;
                }
            } else if (errorHandler == null) {
                return null;
            } else {
                errorHandler.onError(context.getString(C0258j.general__shared__invaild_book));
                return null;
            }
        } else if (errorHandler == null) {
            return null;
        } else {
            errorHandler.onError(context.getString(C0258j.general__shared__sd_card_unmounted));
            return null;
        }
    }
}
