package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.Document_a;
import com.duokan.reader.domain.document.ak;
import com.duokan.reader.domain.document.av;
import com.duokan.reader.domain.document.n;
import com.duokan.reader.ui.general.gh;

public class fs implements gh {
    protected final Document_a a;
    final /* synthetic */ fo b;

    public fs(fo foVar, Document_a aVar) {
        this.b = foVar;
        this.a = aVar;
        foVar.b.d(this.a);
    }

    public ak a() {
        return b(0);
    }

    public gh a(int i) {
        if (i == 0) {
            return this.b.b(this.a);
        }
        return this.b.b(b(i));
    }

    protected ak b(int i) {
        ak b;
        if (this.a instanceof av) {
            n a = this.b.b;
            if (this.b.h) {
                b = this.b.b.b(this.a);
            } else {
                b = this.b.b.a(this.a);
            }
            return a.a(b, i);
        }
        a = this.b.b;
        if (this.b.h) {
            b = this.b.b.b(this.a);
        } else {
            b = this.b.b.a(this.a);
        }
        return a.a(b, i);
    }
}
