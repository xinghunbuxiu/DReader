package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.p045a.C0818n;
import com.duokan.reader.domain.document.p045a.C0904d;
import com.duokan.reader.domain.document.p045a.C0920r;
import java.io.File;

public class kb extends C0800c {
    /* renamed from: a */
    public /* synthetic */ C0903n mo1026a(jz jzVar, C0808w c0808w) {
        return m4804b(jzVar, c0808w);
    }

    protected kb(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected kb(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    /* renamed from: b */
    public C0904d m4804b(jz jzVar, C0808w c0808w) {
        this.a.incrementAndGet();
        File d = m4219d();
        am aV = aV();
        C0818n c0818n = (C0818n) c0808w;
        C0904d c0904d = new C0904d(new kc(this, aV, aV.mo1106i(), d));
        c0904d.m5910a(new kd(this, c0818n));
        c0904d.m5992a((C0920r) mo1033b());
        return c0904d;
    }

    /* renamed from: q */
    public final BookFormat mo1039q() {
        return BookFormat.PDF;
    }

    /* renamed from: b */
    public C0919l mo1033b() {
        if (!m4219d().exists()) {
            return null;
        }
        C0919l c0920r = new C0920r();
        c0920r.a = m4225f();
        return c0920r;
    }
}
