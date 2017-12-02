package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;

import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.txt.ae;
import com.duokan.reader.domain.document.txt.p;
import com.duokan.reader.domain.document.txt.z;
import com.duokan.reader.domain.document.w;

import java.io.File;

public class lb extends c {
    public /* synthetic */ n a(jn jnVar, w wVar) {
        return b(jnVar, wVar);
    }

    protected lb(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected lb(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    public p b(jn jnVar, w wVar) {
        this.a.incrementAndGet();
        File d = d();
        am aT = aT();
        z zVar = (z) wVar;
        p pVar = new p(f(), new lc(this, aT, aT.i(), d));
        pVar.a(new ld(this, zVar));
        pVar.a((ae) b());
        return pVar;
    }

    public final BookFormat q() {
        return BookFormat.TXT;
    }

    public l b() {
        if (!d().exists()) {
            return null;
        }
        l aeVar = new ae();
        aeVar.a = f();
        return aeVar;
    }
}
