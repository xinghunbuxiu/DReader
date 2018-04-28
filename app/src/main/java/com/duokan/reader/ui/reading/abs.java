package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.document.C0941i;
import com.duokan.reader.domain.document.as;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.Callable;

class abs implements Callable<List<as>> {
    /* renamed from: a */
    final /* synthetic */ int f9419a;
    /* renamed from: b */
    final /* synthetic */ abq f9420b;

    abs(abq abq, int i) {
        this.f9420b = abq;
        this.f9419a = i;
    }

    public /* synthetic */ Object call() {
        return m13261a();
    }

    /* renamed from: a */
    public List<as> m13261a() {
        List<as> linkedList = new LinkedList();
        gs X = this.f9420b.f9410b.f9379a.mo2007X();
        gs e = this.f9420b.f9410b.f9379a.mo2136e(this.f9419a);
        if (X.mo2332h() instanceof C0941i) {
            C0941i c0941i = (C0941i) X.mo2332h();
            linkedList.add(c0941i.mo1305b());
            linkedList.add(c0941i.mo1434c());
            if (e == null) {
                return linkedList;
            }
            if (this.f9420b.f9410b.f9379a.mo2135d(X.mo2331g()) && this.f9419a == -1) {
                return linkedList;
            }
            if (this.f9420b.f9410b.f9379a.mo2139e(X.mo2331g()) && this.f9419a == 1) {
                return linkedList;
            }
            c0941i = (C0941i) e.mo2332h();
            linkedList.add(c0941i.mo1305b());
            linkedList.add(c0941i.mo1434c());
        } else if (e == null) {
            return linkedList;
        } else {
            if (this.f9420b.f9410b.f9379a.mo2135d(X.mo2331g()) && this.f9419a == -1) {
                return linkedList;
            }
            if (this.f9420b.f9410b.f9379a.mo2139e(X.mo2331g()) && this.f9419a == 1) {
                return linkedList;
            }
            linkedList.add(X.mo2332h());
            linkedList.add(e.mo2332h());
        }
        return linkedList;
    }
}
