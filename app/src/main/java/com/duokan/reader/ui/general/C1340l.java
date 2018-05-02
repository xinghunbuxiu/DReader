package com.duokan.reader.ui.general;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.duokan.p023b.C0243e;
import com.duokan.reader.domain.bookshelf.BookFormat;
import com.duokan.reader.domain.bookshelf.BookLimitType;
import com.duokan.reader.domain.bookshelf.BookState;
import com.duokan.reader.domain.bookshelf.BookType;
import com.duokan.reader.domain.bookshelf.C0800c;
import com.duokan.reader.domain.bookshelf.ee;

/* renamed from: com.duokan.reader.ui.general.l */
public class C1340l {
    /* renamed from: a */
    private static final String f7530a = C1340l.class.getName();
    /* renamed from: b */
    private static C1340l f7531b = null;
    /* renamed from: c */
    private Context f7532c;

    private C1340l(Context context) {
        this.f7532c = context;
    }

    /* renamed from: a */
    public static C1340l m10931a(Context context) {
        if (f7531b == null) {
            synchronized (C1340l.class) {
                if (f7531b == null) {
                    f7531b = new C1340l(context.getApplicationContext());
                }
            }
        }
        return f7531b;
    }

    /* renamed from: a */
    public C1343o m10935a() {
        return new C1343o();
    }

    /* renamed from: a */
    public Drawable m10934a(C0800c c0800c) {
        if (c0800c == null) {
            return null;
        }
        switch (C1341m.f7533a[c0800c.m4246r().ordinal()]) {
            case 1:
            case 2:
            case 3:
                return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__comic);
            case 4:
                return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__sound);
            default:
                return null;
        }
    }

    /* renamed from: b */
    public Drawable m10936b(C0800c c0800c) {
        if (c0800c != null && c0800c.m4252x()) {
            return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__free);
        }
        return null;
    }

    /* renamed from: c */
    public Drawable m10937c(C0800c c0800c) {
        if (c0800c == null) {
            return null;
        }
        if (c0800c.al()) {
            return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__cmread);
        }
        if (!c0800c.m4166S()) {
            return ((c0800c.m4242o() != BookType.TRIAL || c0800c.m4233i() == BookState.UPDATING) && c0800c.m4242o() == BookType.NORMAL && c0800c.m4243p() == BookLimitType.CONTENT) ? null : null;
        } else {
            ee eeVar = (ee) c0800c;
            if (eeVar.aZ()) {
                return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__timing);
            }
            if (eeVar.mo1020z().m3781b()) {
                return null;
            }
            return this.f7532c.getResources().getDrawable(C0243e.general__book_cover_view__timeout);
        }
    }

    /* renamed from: d */
    public int m10938d(C0800c c0800c) {
        BookFormat q = c0800c.mo1039q();
        if (q == BookFormat.PDF) {
            return C0243e.general__shared__pdf;
        }
        if (q == BookFormat.EPUB || q == BookFormat.SBK) {
            return C0243e.general__shared__epub;
        }
        return C0243e.general__shared__txt;
    }

    /* renamed from: a */
    public int m10933a(String str) {
        if (str.equals("PDF")) {
            return C0243e.general__shared__pdf;
        }
        if (str.equals("EPUB")) {
            return C0243e.general__shared__epub;
        }
        return C0243e.general__shared__txt;
    }
}
