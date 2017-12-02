package com.duokan.reader.domain.bookshelf;

import android.database.Cursor;

import com.duokan.reader.domain.document.a.d;
import com.duokan.reader.domain.document.a.r;
import com.duokan.reader.domain.document.l;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.domain.document.w;

import java.io.File;

public class jp extends c {
    public /* synthetic */ n a(jn jnVar, w wVar) {
        return b(jnVar, wVar);
    }

    protected jp(am amVar, long j, BookPackageType bookPackageType, BookType bookType, BookState bookState, boolean z, boolean z2) {
        super(amVar, j, bookPackageType, bookType, bookState, z, z2);
    }

    protected jp(am amVar, Cursor cursor) {
        super(amVar, cursor);
    }

    public d b(jn jnVar, w wVar) {
        this.a.incrementAndGet();
        File d = d();
        am aT = aT();
        com.duokan.reader.domain.document.a.n nVar = (com.duokan.reader.domain.document.a.n) wVar;
        d dVar = new d(new jq(this, aT, aT.i(), d));
        dVar.a(new jr(this, nVar));
        dVar.a((r) b());
        return dVar;
    }

    public final BookFormat q() {
        return BookFormat.PDF;
    }

    public l b() {
        if (!d().exists()) {
            return null;
        }
        l rVar = new r();
        rVar.a = f();
        return rVar;
    }
}
