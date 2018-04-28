package com.duokan.reader.ui.reading;

import com.duokan.reader.domain.bookshelf.C0798a;
import com.duokan.reader.domain.document.C0896a;
import com.duokan.reader.domain.document.C0897d;
import com.duokan.reader.domain.document.bb;
import java.util.Comparator;

class st implements Comparator<C0798a> {
    /* renamed from: a */
    final /* synthetic */ si f10956a;

    st(si siVar) {
        this.f10956a = siVar;
    }

    public /* synthetic */ int compare(Object obj, Object obj2) {
        return m14977a((C0798a) obj, (C0798a) obj2);
    }

    /* renamed from: a */
    public int m14977a(C0798a c0798a, C0798a c0798a2) {
        bb a = this.f10956a.getDocument().mo1216a((C0897d) c0798a.m3726d(), (C0897d) c0798a.m3728e());
        C0896a a2 = this.f10956a.getDocument().mo1216a((C0897d) c0798a2.m3726d(), (C0897d) c0798a2.m3728e());
        if (a.mo1188a(a2)) {
            return -1;
        }
        if (a.mo1190c(a2)) {
            return 1;
        }
        return 0;
    }
}
