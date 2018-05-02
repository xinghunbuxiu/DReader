package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;
import com.duokan.reader.domain.document.C0808w;
import com.duokan.reader.domain.document.C0903n;
import com.duokan.reader.domain.document.C0919l;
import com.duokan.reader.domain.document.txt.C0827z;
import com.duokan.reader.domain.document.txt.C1000p;
import com.duokan.reader.domain.document.txt.ae;
import java.io.File;

public class lo extends C0800c {
    /* renamed from: a */
    public /* synthetic */ C0903n mo1026a(jz jzVar, C0808w c0808w) {
        return m4946b(jzVar, c0808w);
    }

    protected lo(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected lo(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    /* renamed from: b */
    public C1000p m4946b(jz jzVar, C0808w c0808w) {
        this.a.incrementAndGet();
        File d = m4219d();
        am aV = aV();
        C0827z c0827z = (C0827z) c0808w;
        C1000p c1000p = new C1000p(m4225f(), new lp(this, aV, aV.mo1106i(), d));
        c1000p.m5910a(new lq(this, c0827z));
        c1000p.mo1219a((ae) mo1033b());
        return c1000p;
    }

    /* renamed from: q */
    public final BookFormat mo1039q() {
        return BookFormat.TXT;
    }

    /* renamed from: b */
    public C0919l mo1033b() {
        if (!m4219d().exists()) {
            return null;
        }
        C0919l aeVar = new ae();
        aeVar.a = m4225f();
        return aeVar;
    }
}
