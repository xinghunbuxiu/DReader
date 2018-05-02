package com.duokan.reader.domain.micloud;

import com.duokan.reader.common.async.work.C0523c;
import com.duokan.reader.common.async.work.C0531i;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.micloud.q */
class C1076q extends C0531i<bl> {
    /* renamed from: a */
    final /* synthetic */ C1074o f5296a;

    C1076q(C1074o c1074o) {
        this.f5296a = c1074o;
    }

    /* renamed from: e */
    public /* synthetic */ void mo749e(C0523c c0523c) {
        m8276a((bl) c0523c);
    }

    /* renamed from: a */
    public void m8276a(bl blVar) {
        List<C0812t> linkedList = new LinkedList();
        synchronized (this.f5296a) {
            linkedList.addAll(this.f5296a.f5294c);
        }
        for (C0812t b : linkedList) {
            b.mo1110b(this.f5296a);
        }
    }
}
