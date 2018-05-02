package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;

import com.duokan.b.e;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.ej;

public class l {
    private static final String a = l.class.getName();
    private static l b = null;
    private Context c;

    private l(Context context) {
        this.c = context;
    }

    public static l a(Context context) {
        if (b == null) {
            synchronized (l.class) {
                if (b == null) {
                    b = new l(context.getApplicationContext());
                }
            }
        }
        return b;
    }

    public o a() {
        return new o();
    }

    public Drawable a(c cVar) {
        if (cVar == null) {
            return null;
        }
        switch (m.a[cVar.r().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return this.c.getResources().getDrawable(e.general__book_cover_view__comic);
            case 4:
                return this.c.getResources().getDrawable(e.general__book_cover_view__sound);
            default:
                return null;
        }
    }

    public Drawable b(c cVar) {
        if (cVar == null) {
            return null;
        }
        if (cVar.aj()) {
            return this.c.getResources().getDrawable(e.general__book_cover_view__cmread);
        }
        if (cVar.Q()) {
            ej ejVar = (ej) cVar;
            if (ejVar.aX()) {
                return this.c.getResources().getDrawable(e.general__book_cover_view__timing);
            }
            if (ejVar.y().b()) {
                return this.c.getResources().getDrawable(e.general__book_cover_view__trial);
            }
            return this.c.getResources().getDrawable(e.general__book_cover_view__timeout);
        } else if (cVar.o() == BookType.TRIAL || (cVar.o() == BookType.NORMAL && cVar.p() == BookLimitType.CONTENT)) {
            return this.c.getResources().getDrawable(e.general__book_cover_view__trial);
        } else {
            return null;
        }
    }

    public int c(c cVar) {
        BookFormat q = cVar.q();
        if (q == BookFormat.PDF) {
            return e.general__shared__pdf;
        }
        if (q == BookFormat.EPUB) {
            return e.general__shared__epub;
        }
        return e.general__shared__txt;
    }

    public int a(String str) {
        if (str.equals("PDF")) {
            return e.general__shared__pdf;
        }
        if (str.equals("EPUB")) {
            return e.general__shared__epub;
        }
        return e.general__shared__txt;
    }
}
