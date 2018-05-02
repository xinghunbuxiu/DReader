package com.duokan.reader.domain.document.epub;

import com.duokan.kernel.epublib.DkeBook.Callback;
import com.duokan.kernel.epublib.DkeResourceDescriptor;
import com.duokan.kernel.epublib.DkeResourceStream;
import java.util.HashSet;
import java.util.UUID;

/* renamed from: com.duokan.reader.domain.document.epub.x */
class C0957x implements Callback {
    /* renamed from: a */
    final /* synthetic */ C0952s f4749a;

    C0957x(C0952s c0952s) {
        this.f4749a = c0952s;
    }

    public byte[][] queryCert() {
        byte[][] a = this.f4749a.f4723j.mo1063a(UUID.randomUUID().toString());
        if (a == null) {
            this.f4749a.m5927d(2);
        }
        return a;
    }

    public DkeResourceStream queryResource(DkeResourceDescriptor dkeResourceDescriptor) {
        if (this.f4749a.f4723j == null) {
            return null;
        }
        aw awVar = new aw(dkeResourceDescriptor);
        av a = this.f4749a.f4723j.mo1060a(awVar, false);
        av a2 = this.f4749a.f4723j.mo1060a(awVar, true);
        if (this.f4749a.f4734u.get() == null) {
            this.f4749a.f4734u.set(new HashSet());
        }
        if (this.f4749a.f4735v.get() == null) {
            this.f4749a.f4735v.set(new HashSet());
        }
        ((HashSet) this.f4749a.f4734u.get()).add(a);
        if (a2 != null) {
            ((HashSet) this.f4749a.f4734u.get()).add(a2);
        }
        ax m;
        if (a.mo1073i()) {
            m = a.mo1077m();
            return m != null ? new C0933a(m) : null;
        } else {
            ((HashSet) this.f4749a.f4735v.get()).add(a);
            if (a2 != null) {
                if (a2.mo1073i()) {
                    m = a2.mo1077m();
                    return m != null ? new C0933a(m) : null;
                } else {
                    ((HashSet) this.f4749a.f4735v.get()).add(a2);
                }
            }
            return null;
        }
    }
}
