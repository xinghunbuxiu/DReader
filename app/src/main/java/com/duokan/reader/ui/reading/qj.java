package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.c;
import com.duokan.reader.domain.bookshelf.y;

class qj implements y {
    final /* synthetic */ qh a;

    qj(qh qhVar) {
        this.a = qhVar;
    }

    public void a(c cVar, boolean z) {
        if (z) {
            this.a.c.b(new qk(this, cVar));
        }
    }

    public void a(c cVar, String str) {
        if (this.a.f == cVar) {
        }
    }

    public void a(c cVar) {
        if (this.a.f == cVar) {
            this.a.runAfterActive(new qm(this));
        }
    }

    public void b(c cVar, boolean z) {
        if (this.a.f == cVar && z) {
            this.a.runAfterActive(new qn(this));
        }
    }

    public void b(c cVar, String str) {
        if (this.a.f == cVar) {
        }
    }
}
