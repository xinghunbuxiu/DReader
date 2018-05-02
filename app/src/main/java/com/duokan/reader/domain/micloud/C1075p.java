package com.duokan.reader.domain.micloud;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.duokan.reader.domain.micloud.p */
class C1075p implements ad {
    /* renamed from: a */
    final /* synthetic */ C1074o f5295a;

    C1075p(C1074o c1074o) {
        this.f5295a = c1074o;
    }

    /* renamed from: a */
    public bj mo1481a() {
        return this.f5295a.f5292a.mo1481a();
    }

    /* renamed from: a */
    public void mo1483a(bj bjVar) {
        this.f5295a.f5292a.mo1483a(bjVar);
        List<C0812t> linkedList = new LinkedList();
        synchronized (this.f5295a) {
            linkedList.addAll(this.f5295a.f5294c);
        }
        for (C0812t a : linkedList) {
            a.mo1108a(this.f5295a);
        }
    }

    /* renamed from: a */
    public bi mo1480a(String str) {
        return this.f5295a.f5292a.mo1480a(str);
    }

    /* renamed from: b */
    public Collection<bi> mo1486b(String str) {
        return this.f5295a.f5292a.mo1486b(str);
    }

    /* renamed from: a */
    public void mo1482a(bi biVar) {
        this.f5295a.f5292a.mo1482a(biVar);
    }

    /* renamed from: a */
    public void mo1484a(String str, Collection<bi> collection) {
        this.f5295a.f5292a.mo1484a(str, collection);
    }

    /* renamed from: c */
    public void mo1487c(String str) {
        this.f5295a.f5292a.mo1487c(str);
    }

    /* renamed from: a */
    public void mo1485a(Collection<bi> collection) {
        this.f5295a.f5292a.mo1485a((Collection) collection);
    }
}
