package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.ui.general.gh;

public class fm implements gh {
    protected final a a;
    final /* synthetic */ fi b;

    public fm(fi fiVar, a aVar) {
        this.b = fiVar;
        this.a = aVar;
        fiVar.c.d(this.a);
    }

    public int a() {
        if (this.a instanceof av) {
            return (int) this.b.c.b((av) this.a);
        }
        return (int) this.b.c.c((ak) this.a);
    }

    public ak b() {
        return b(0);
    }

    public gh a(int i) {
        return i == 0 ? this : this.b.b(b(i));
    }

    protected ak b(int i) {
        if (this.a instanceof av) {
            return this.b.c.a(this.b.c.c((av) this.a), i);
        }
        return this.b.c.a((ak) this.a, i);
    }
}
