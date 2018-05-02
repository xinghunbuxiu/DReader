package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook.Callback;
import com.duokan.kernel.epublib.DkeResourceDescriptor;
import com.duokan.kernel.epublib.DkeResourceStream;

import java.util.HashSet;
import java.util.UUID;

class x implements Callback {
    final /* synthetic */ s a;

    x(s sVar) {
        this.a = sVar;
    }

    public byte[][] queryCert() {
        byte[][] a = this.a.j.a(UUID.randomUUID().toString());
        if (a == null) {
            this.a.d(2);
        }
        return a;
    }

    public DkeResourceStream queryResource(DkeResourceDescriptor dkeResourceDescriptor) {
        if (this.a.j == null) {
            return null;
        }
        aw awVar = new aw(dkeResourceDescriptor);
        av a = this.a.j.a(awVar, false);
        av a2 = this.a.j.a(awVar, true);
        if (this.a.u.get() == null) {
            this.a.u.set(new HashSet());
        }
        if (this.a.v.get() == null) {
            this.a.v.set(new HashSet());
        }
        ((HashSet) this.a.u.get()).add(a);
        if (a2 != null) {
            ((HashSet) this.a.u.get()).add(a2);
        }
        ax m;
        if (a.i()) {
            m = a.m();
            return m != null ? new a(m) : null;
        } else {
            ((HashSet) this.a.v.get()).add(a);
            if (a2 != null) {
                if (a2.i()) {
                    m = a2.m();
                    return m != null ? new a(m) : null;
                } else {
                    ((HashSet) this.a.v.get()).add(a2);
                }
            }
            return null;
        }
    }
}
