package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook;
import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.e;
import com.duokan.reader.domain.document.f;

class aa extends f {
    final /* synthetic */ s a;
    private final DkeBook b;
    private d[] c = null;

    public /* synthetic */ e a(int i) {
        return b(i);
    }

    public aa(s sVar, DkeBook dkeBook) {
        this.a = sVar;
        this.b = dkeBook;
    }

    public int a() {
        a.c().b(this.a.A());
        if (this.a.p()) {
            return b().length;
        }
        return 0;
    }

    public d b(int i) {
        a.c().b(this.a.A());
        if (!this.a.p() || i < 0 || i >= a()) {
            return null;
        }
        if (b()[i] == null) {
            Document_a a = this.a.a(this.b.getChapterIndexOfFrame((long) i), 0);
            if (!this.a.d(a) || !a.e()) {
                return null;
            }
            b()[i] = new d(this.b, i);
        }
        return b()[i];
    }

    public int a(av avVar) {
        a.c().b(this.a.A());
        if (!this.a.p()) {
            return -1;
        }
        e p = this.a.k;
        c cVar = (c) avVar;
        for (int i = 0; i < a(); i++) {
            if (p.h().getChapterIndexOfFrame((long) i) >= cVar.g()) {
                return i;
            }
        }
        return -1;
    }

    private d[] b() {
        a.c().b(this.a.A());
        if (!this.a.p()) {
            return new d[0];
        }
        if (this.c == null) {
            this.c = new d[((int) this.b.getComicsFrameCount())];
        }
        return this.c;
    }
}
